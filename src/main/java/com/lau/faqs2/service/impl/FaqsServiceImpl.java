package com.lau.faqs2.service.impl;

import com.github.pagehelper.PageHelper;
import com.lau.faqs2.mapper.FaqsMapper;
import com.lau.faqs2.model.Faqs;
import com.lau.faqs2.service.FaqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * @author SteveLau
 * @date 2018/4/9
 * <p>
 * 人生可否变作漫长浪漫程序！
 * @description FaqsService实线类
 */
@Service
public class FaqsServiceImpl extends BaseService<Faqs> implements FaqsService {
    @Autowired
    private FaqsMapper faqsMapper;

    @Override
    public List<Faqs> findPage(Faqs faqs, int page, int rows) {
        PageHelper.startPage(page,rows);
        return faqsMapper.findFaqsTitle(faqs.getTitle());
    }
}
