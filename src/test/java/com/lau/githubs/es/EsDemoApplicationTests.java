package com.lau.githubs.es;
import com.lau.githubs.elasticsearch.bean.SearchRepo;
import com.lau.githubs.elasticsearch.repository.RepoRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EsDemoApplicationTests {

    @Autowired
    private RepoRepository repoRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    /**
     * 使用elasticsearchTemplate添加索引
     * Indexing multiple Document(bulk index) using Elasticsearch Template
     */
    @Test
    public void addIndex03() {
        List<IndexQuery> indexQueries = new ArrayList<>();

        //first document
        SearchRepo searchRepo = new SearchRepo();
        searchRepo.setId(6);
        searchRepo.setAuthor("yyyy");
        searchRepo.setName("SpringDataElasticSearchQuickStartExample");
        searchRepo.setDescription("SpringDataElasticSearch快速入门");
        searchRepo.setReadme("SpringDataElasticSearch入门示例\n" +
                "演示 SpringDataElasticSearch 的基本查询语法的使用\n" +
                "详见：io.github.mosiki.search.BookRepositoryTest\n" +
                "演示 SpringDataElasticSearch 的高亮查询 以及权重查询 详见：io.github.mosiki.search.HighlightBookRepositoryTest\n" +
                "具体文章，详见我的博客 http://nullpointer.pw");
        IndexQuery query = new IndexQueryBuilder().withId(searchRepo.getId().toString()).withObject(searchRepo).build();
        indexQueries.add(query);

        //second document
        SearchRepo searchRepo1 = new SearchRepo();
        searchRepo1.setId(7);
        searchRepo1.setAuthor("52SQL");
        searchRepo1.setName("spring-notes");
        searchRepo1.setDescription("book Spring Framework 学习笔记。 https://dunwu.gitbooks.io/spring-notes/");
        searchRepo1.setReadme("spring-notes\n" +
                "Spring 学习笔记。\n" +
                "\n" +
                "以简单范例来展示 spring 在 web 开发中的各种应用。\n" +
                "\n" +
                "扩展学习：更多 Java 技术栈知识（JavaSE/JavaEE/Java 库/Java 工具/Java 框架）可以在 java-stack 了解。\n" +
                "\n" +
                " point_right spring-notes 文档在线阅读");

        IndexQuery query1 = new IndexQueryBuilder().withId(searchRepo.getId().toString()).withObject(searchRepo).build();
        indexQueries.add(query1);

        elasticsearchTemplate.bulkIndex(indexQueries);
    }

    /**
     * 使用elasticsearchTemplate添加索引
     * indexing a single document using Elasticsearch Template
     */
    @Test
    public void addIndex02() {
        SearchRepo repo = new SearchRepo();
        repo.setId(5);
        repo.setAuthor("wangyiyun_music");
        repo.setName("wangyiyun_music");
        repo.setDescription("网易云音乐爬虫系列，现在更新了爬取评论方面");
        repo.setReadme("wangyiyun_music\n" +
                "网易云音乐爬虫系列，现在更新了爬取评论方面 欢迎大家fork和star\n" +
                "\n" +
                "公众号日常学python有详细的解释");
        IndexQuery query = new IndexQueryBuilder().withId(repo.getId().toString()).withObject(repo).build();
       /* IndexQuery query = new IndexQuery();
        query.setIndexName("my");
        query.setType("user");
        query.setObject(user);*/
        elasticsearchTemplate.index(query);
    }

    /**
     * 使用elasticsearchTemplate查询用户
     */
    @Test
    public void queryByName(){
        List<SearchRepo> users = elasticsearchTemplate.queryForList(
                new CriteriaQuery(Criteria.where("name").contains("三")), SearchRepo.class);

        for (SearchRepo u: users) {
            System.out.println(u);
        }
    }


    /**
     * 使用userRepository添加索引
     */
    @Test
    public void addIndex() {
        SearchRepo user = new SearchRepo();
        user.setId(10);

        user.setAuthor("唐三");
        user.setName("ExtractTopicSentence");
        user.setDescription("基于标题分类的主题句提取方法可描述为: 给定一篇新闻报道, 计算标题与新闻主题词集的相似度, 判断标题是否具有提示性。对于提示性标题,抽取新闻报道中与其最相似的句子作为主题句; 否则, 综合利用多种特征计算新闻报道中句子的重要性, 将得分最高的句子作为主题句。");
        user.setReadme("基于标题分类的主题句提取 基于标题分类的主题句提取方法可描述为: 给定一篇新闻报道, 计算标题与新闻主题词集的相似度, 判断标题是否具有提示性。对于提示性标题,抽取新闻报道中与其最相似的句子作为主题句; 否则, 综合利用多种特征计算新闻报道中句子的重要性, 将得分最高的句子作为主题句。\n" +
                "\n" +
                "1.构造新闻的主题词集 （1）对于爬取的有标签的或关键词的文章，将标签作为主题词集的一部分。 （2）对文本做预处理，分句、分词并去除停用词，词性过滤、词频过滤。 （3）使用信息熵计算文章中每个词的权重。 （4）使用NLPIR关键词抽取工具抽取文章的关键词，然后加上标签作为每篇文章的主题词集。\n" +
                "\n" +
                "2.标题分类 将标题分为两类，一类是有提示性，一类是没有提示性。计算标题与主题词集的相似度。 （1）对标题分词，然后计算标题与主题词集中词的重合的个数。将个数作为相似度度量。仅考虑实义词如：动词、名词、命名实体等。这里设置相似度的阀值为1，即重合的个数大于等于1时该标题具有提示性，重合的个数小于1时不具有提示性。 标题具有提示性标记为1，不具有提示性标记为0。");
        //在user类中使用注解表明所处的index和type
        repoRepository.save(user);
    }

    /**
     * 使用userRepository中自定义方法查询user
     */
    @Test
    public void searchUser() {
        List<SearchRepo> userList = repoRepository.findUserByNameLike("三");
        for (SearchRepo repo : userList) {
            System.out.println("模糊查询的结果:" + repo);
        }

        SearchRepo repo = repoRepository.findUserById(3);
        System.out.println("按照id查询的结果：" + repo);

    }

    /**
     *userRepository 分页查询
     */
    @Test
    public void testQueryPage() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                // .withQuery(QueryBuilders.matchQuery("name", "三"))  //分词
                .withQuery(QueryBuilders.matchPhraseQuery("name", "三")) //不分词
                .withPageable(PageRequest.of(0, 2))
                .build();

        Page<SearchRepo> page = repoRepository.search(searchQuery);
        List<SearchRepo> users = page.getContent();
        for (SearchRepo user : users) {
            System.out.println(user);
        }
    }


}
