package com.lau.githubs.elasticsearch.service;

import com.lau.githubs.elasticsearch.bean.SearchRepo;
import com.lau.githubs.elasticsearch.mapper.ExtResultMapper;
import com.lau.githubs.elasticsearch.repository.RepoRepository;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RepoSearchServiceImpl implements RepoSearchService {

    @Resource
    private ExtResultMapper extResultMapper;

    @Autowired
    private RepoRepository repoRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public long count() {
        return repoRepository.count();
    }

    @Override
    public SearchRepo save(SearchRepo searchRepo) {
        return repoRepository.save(searchRepo);
    }

    @Override
    public void delete(SearchRepo searchRepo) {
        repoRepository.delete(searchRepo);
    }

    @Override
    public Iterable<SearchRepo> getAll() {
        return repoRepository.findAll();
    }

    /**
     * //根据用户名精确查询用户
     * @param name
     * @return
     */
    @Override
    public List<SearchRepo> getByName(String name) {
        List<SearchRepo> searchRepo = repoRepository.findUserByName(name);
        return searchRepo;
    }

    /**
     *对用户姓名进行分页查询
     */
    @Override
    public Page<SearchRepo> pageQuery(Integer pageNum, Integer pageSize, String q) {
        //matchPhraseQuery ：对查询条件不分词，当做一个整体查询
        //mathQuery:对查询条件进行分词，之后再查询

        //分页
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        //指定查询字段-单字段
        MatchPhraseQueryBuilder queryBuilder = QueryBuilders.matchPhraseQuery("name", q);

        //指定查询字段-多字段
        //MultiMatchQueryBuilder queryBuilder1 = QueryBuilders.multiMatchQuery(q, "name", "address");

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withPageable(pageable)
                .build();
        Page<SearchRepo> users = repoRepository.search(searchQuery);

        return users;
    }


  /*
     使用QueryBuilders的boolQuery方法可以进行多条件查询，即sql语句中的and和or查询这里and是must()，or是should()；
     例如：QueryBuilder qb1 = QueryBuilders.termsQuery("字段", 值);
     QueryBuilder qb2 = QueryBuilders.rangeQuery("字段").gt(值);
     QueryBuilder qb3 = QueryBuilders.boolQuery().must(qb1).must(qb2);//must链接两个查询条件，or的话使用should()。
  */

    /**
     * 对用户名和地址 分页查询 + 高亮显示
     * @param pageNum
     * @param pageSize
     * @param q
     * @return
     */
    @Override
    public Page<SearchRepo> pageQueryWithHighLight(Integer pageNum, Integer pageSize, String q) {
        //分页
        Pageable pageable = PageRequest.of(pageNum, pageSize);

        //google的色值
        String preTag = "<font color='#dd4b39'>";
        String postTag = "</font>";

        //添加查询的字段内容
        String [] fileds = {"author", "name","description","readme"};
        QueryBuilder mutiQueryBuilder = QueryBuilders.multiMatchQuery(q, fileds);

        SearchQuery searchQuery = new NativeSearchQueryBuilder().
                withQuery(mutiQueryBuilder).
                withHighlightFields(
                        new HighlightBuilder.Field("author").preTags(preTag).postTags(postTag),
                        new HighlightBuilder.Field("name").preTags(preTag).postTags(postTag),
                        new HighlightBuilder.Field("description").preTags(preTag).postTags(postTag),
                        new HighlightBuilder.Field("readme").preTags(preTag).postTags(postTag)
                ).withPageable(pageable).build();
        Page<SearchRepo> repos = elasticsearchTemplate.queryForPage(searchQuery, SearchRepo.class, extResultMapper);
        return repos;

    }
}
