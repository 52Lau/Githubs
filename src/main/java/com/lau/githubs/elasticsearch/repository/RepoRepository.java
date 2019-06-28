package com.lau.githubs.elasticsearch.repository;

import com.lau.githubs.elasticsearch.bean.SearchRepo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoRepository extends ElasticsearchRepository<SearchRepo, Integer> {
    //参考：https://docs.spring.io/spring-data/elasticsearch/docs/3.1.4.RELEASE/reference/html/
    //自定义方法，不用实现

    /**
     根据名称模糊查询
     */
    List<SearchRepo> findUserByNameLike(String name);

    /**
     * 自定义方法，根据名称精确查询
     * @param name
     * @return
     */
    List<SearchRepo> findUserByName(String name);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    SearchRepo findUserById(Integer id);
}
