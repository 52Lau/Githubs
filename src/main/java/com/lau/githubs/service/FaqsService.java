package com.lau.githubs.service;

import com.lau.githubs.model.Faqs;

import java.util.List;

/**
 * @author SteveLau
 * @date 2018/4/9
 * <p>
 * 人生可否变作漫长浪漫程序！
 * @description Faqs业务接口
 */
public interface FaqsService extends IService<Faqs> {

    List<Faqs> findPage(Faqs faqs, int page, int rows);
}
