package com.lau.githubs.service.impl;

import com.lau.githubs.common.Page;
import com.lau.githubs.mapper.HotrepoMapper;
import com.lau.githubs.model.Hotrepo;
import com.lau.githubs.service.HotRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotRepoServiceImpl extends BaseService<Hotrepo>  implements HotRepoService {
    @Autowired
    HotrepoMapper hotrepoMapper;
    @Override
    public Page findHotRepo(Hotrepo hotrepo, Page pager) {
        if (pager ==null) pager = new Page();
        if(pager.getPageSize()==null){
            pager.setPageSize(10);
        }
        pager.setResultCount(hotrepoMapper.countByLanguagesAndMtype(hotrepo));
        hotrepo.setFirstrecord(pager.getFirstIndex()+1);
        hotrepo.setFinalmax(pager.getPageSize());
        hotrepo.setLastrecord(pager.getFirstIndex()+pager.getPageSize());
        pager.setList(hotrepoMapper.findAllByLanguagesAndMtype(hotrepo));
        return pager;
    }
}
