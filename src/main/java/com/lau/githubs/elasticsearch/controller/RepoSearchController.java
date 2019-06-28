package com.lau.githubs.elasticsearch.controller;

import com.lau.githubs.elasticsearch.bean.SearchRepo;
import com.lau.githubs.elasticsearch.service.RepoSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RepoSearchController {

    @Autowired
    private RepoSearchService repoSearchService;

    @GetMapping("/count")
    public long count() {
        return repoSearchService.count();
    }

    @GetMapping("/getAll")
    public Iterable<SearchRepo> getAll() {
        return repoSearchService.getAll();
    }

    @PostMapping("/save")
    public SearchRepo save(@RequestBody SearchRepo searchRepo) {
        repoSearchService.save(searchRepo);
        return searchRepo;
    }

    @PostMapping("/delete")
    public SearchRepo delete(@RequestBody SearchRepo searchRepo) {
        repoSearchService.delete(searchRepo);
        return searchRepo;
    }

    @GetMapping("/getByName/{userName}")
    public List<SearchRepo> getByName(@PathVariable("userName") String userName) {
        return repoSearchService.getByName(userName);
    }

    @GetMapping("/pageQueryByName/{pageNum}/{pageSize}/{q}")
    public List<SearchRepo> pageQuery(@PathVariable("pageNum") Integer pageNum,
                                @PathVariable("pageSize") Integer pageSize,
                                @PathVariable("q") String q) {
        Page<SearchRepo> users = repoSearchService.pageQuery(pageNum, pageSize, q);
        List<SearchRepo> content = users.getContent();
        return content;
    }

    @GetMapping("/pageQueryWithHightLight/{pageNum}/{pageSize}/{q}")
    @ResponseBody
    public List<SearchRepo> pageQueryWithHightLight(@PathVariable("pageNum") Integer pageNum,
                                @PathVariable("pageSize") Integer pageSize,
                                @PathVariable("q") String q) {
        Page<SearchRepo> searchRepos = repoSearchService.pageQueryWithHighLight(pageNum, pageSize, q);
        if(searchRepos != null && searchRepos.getContent() != null) {
            List<SearchRepo> content = searchRepos.getContent();
            return content;
        }
        return null;
    }
}
