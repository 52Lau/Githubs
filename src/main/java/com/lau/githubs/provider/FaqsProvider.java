package com.lau.githubs.provider;

import tk.mybatis.mapper.util.StringUtil;

/**
 * @author SteveLau
 * @date 2018/4/9
 * <p>
 * 人生可否变作漫长浪漫程序！
 * @description
 */
public class FaqsProvider {
    public String findFaqsTitle(String title){
        StringBuffer sql=new StringBuffer("SELECT f.*,c.cname FROM faqs f left join classes c on c.id=f.classid where 1=1 ");
        if (StringUtil.isNotEmpty(title)){
            sql.append(" and title like CONCAT('%',#{title},'%') ");
        }
        return sql.toString();
    }
}
