package com.lau.githubs.mapper;

import com.lau.githubs.provider.FaqsProvider;
import com.lau.githubs.model.Faqs;
import com.lau.githubs.util.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**faqs接口
 *
 */
@Mapper
public interface FaqsMapper extends MyMapper<Faqs> {
    /**
     * 模糊分页查询
     * @param title 标题
     * @return
     */
    /*@Select("SELECT f.*,c.* FROM faqs f left join classes c on c.id=f.classid where title like #{title}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "createdate",column = "createdate"),
            @Result(property = "content",column = "content"),
            @Result(property = "classid",column = "classid"),
            @Result(property = "classes.id",column = "id"),
            @Result(property = "classes.cname",column = "cname"),
    })
    List<Faqs> findPage(@Param("title")String title);*/

    /*用script标签包围，然后像xml语法一样书写*/
    /*@Select("<script> " +
            "SELECT f.*,c.* FROM faqs f left join classes c on c.id=f.classid " +
            " <where> " +
            "  1=1" +
            " <if test=\"title != null\"> and title=#{title}</if> " +
            " </where> " +
            " </script> ")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "createdate",column = "createdate"),
            @Result(property = "content",column = "content"),
            @Result(property = "classid",column = "classid"),
            @Result(property = "classes.id",column = "id"),
            @Result(property = "classes.cname",column = "cname"),
    })
    List<Faqs> findFaqsByTitleXml(String title);*/

    /*用Provider去实现SQL拼接*/
    @SelectProvider(type = FaqsProvider.class,method = "findFaqsTitle")//多条件关键注释
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "createdate",column = "createdate"),
            @Result(property = "content",column = "content"),
            @Result(property = "classid",column = "classid"),
            @Result(property = "classes.id",column = "id"),
            @Result(property = "classes.cname",column = "cname"),
    })
    List<Faqs> findFaqsTitle(String title);


}