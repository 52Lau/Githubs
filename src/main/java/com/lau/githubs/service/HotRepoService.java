package com.lau.githubs.service;

import com.lau.githubs.common.Page;
import com.lau.githubs.model.Hotrepo;

/**
 * @author lau52y
 * @date 2019-06-24 10:43
 */
public interface HotRepoService extends IService<Hotrepo>{
    Page  findHotRepo(Hotrepo hotrepo, Page page);
}
