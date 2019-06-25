package com.lau.githubs.mapper;
import org.apache.ibatis.annotations.Param;



import com.lau.githubs.model.Hotrepo;

import com.lau.githubs.util.MyMapper;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Component;



import java.util.List;



@Mapper

@Component

public interface HotrepoMapper extends MyMapper<Hotrepo> {

    Integer getHotRepoCount(Hotrepo hotrepo);

    Integer countByLanguagesAndMtype(Hotrepo hotrepo);

    List<Hotrepo> findAllByLanguagesAndMtype(Hotrepo hotrepo);




    List<Hotrepo> getHotRepoList(Hotrepo hotrepo);



}