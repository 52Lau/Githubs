package com.lau.faqs2.controller;

import com.github.pagehelper.PageInfo;
import com.lau.faqs2.model.Classes;
import com.lau.faqs2.model.Faqs;
import com.lau.faqs2.service.ClassesService;
import com.lau.faqs2.service.FaqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author SteveLau
 * @date 2018/4/9
 * <p>
 * 人生可否变作漫长浪漫程序！
 * @description
 */
@Controller
@RequestMapping("/faqs2")
public class FaqsController {


    @Autowired
    private FaqsService faqsService;

    @Autowired
    private ClassesService classesService;

    /**
     *
     * @param faqs 对象
     * @param page 起始页
     * @param rows 每一页显示的记录数
     * @return
     */
    @RequestMapping(value = {"index", "index.html", "list", ""})
    public ModelAndView findPage(Faqs faqs, @RequestParam(required = false, defaultValue = "1") int page,
                                 @RequestParam(required = false, defaultValue = "5") int rows) {

        ModelAndView result = new ModelAndView("index");
        List<Faqs> list = faqsService.findPage(faqs, page, rows);
        result.addObject("pageInfo", new PageInfo<Faqs>(list));
        result.addObject("page", page);
        result.addObject("rows", rows);
        return result;
    }

    /**
     * 新增前查询classes
     * @return
     */
    @RequestMapping("drop")
    public ModelAndView drop() {
        ModelAndView result = new ModelAndView("insert");
        Example example = new Example(Classes.class);
        Example.Criteria criteria = example.createCriteria();
        List<Classes> list = classesService.selectByExample(example);
        result.addObject("list", list);
        return result;

    }

    /**
     * 新增
     * @param faqs
     * @return
     */
    @RequestMapping("insert")
    public ModelAndView insert(Faqs faqs) {
        ModelAndView result = new ModelAndView("success");
        int msg = faqsService.save(faqs);
        result.addObject("msg", msg > 0 ? "成功" : "失败");
        return result;

    }

    /**
     * 按id删除
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public ModelAndView delete(@RequestParam(required = true) int id) {
        ModelAndView result = new ModelAndView("success");
        int msg = faqsService.delete(id);
        result.addObject("msg", msg > 0 ? "成功" : "失败");
        return result;
    }

    /**
     * 修改查询数据跳转
     *
     */
    @RequestMapping("upDrop")
    public ModelAndView upDrop(@RequestParam(required = true)Integer id){
        ModelAndView result = new ModelAndView("update");
        Example example = new Example(Faqs.class);
        Example.Criteria criteria = example.createCriteria();
        if (id!=null){
            criteria.andEqualTo("id",id);
        }
        List<Faqs> list = faqsService.selectByExample(example);
        result.addObject("list", list);
        return result;
    }

    /**
     * 按对象修改
     * @param
     * @return
     */
    @RequestMapping("update")
    public ModelAndView update(Faqs faqs) {
        ModelAndView result = new ModelAndView("success");
        int msg = faqsService.updateNotNull(faqs);
        result.addObject("msg", msg > 0 ? "成功" : "失败");
        return result;
    }
}
