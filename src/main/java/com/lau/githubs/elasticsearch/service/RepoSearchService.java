package com.lau.githubs.elasticsearch.service;

import com.lau.githubs.elasticsearch.bean.SearchRepo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RepoSearchService {
    long count();

    SearchRepo save(SearchRepo searchRepo);

    void delete(SearchRepo searchRepo);

    Iterable<SearchRepo> getAll();

    List<SearchRepo> getByName(String name);

    Page<SearchRepo> pageQuery(Integer pageNum, Integer pageSize, String q);

    Page<SearchRepo> pageQueryWithHighLight(Integer pageNum, Integer pageSize, String q);
}
