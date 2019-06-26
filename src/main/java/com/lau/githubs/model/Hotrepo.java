package com.lau.githubs.model;

import java.util.Date;
import javax.persistence.*;

public class Hotrepo {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 项目名
     */
    private String name;

    /**
     * 描述
     */
    private String des;

    /**
     * 语言，Java还是python等
     */
    private String languages;

    /**
     * 项目地址
     */
    private String url;

    /**
     * stars数量
     */
    private String stars;

    /**
     * fork数量
     */
    private String forks;

    /**
     * 增加的start
     */
    private String staradd;

    /**
     * 语言类型，感觉是多余的
     */
    private String ltype;

    /**
     * 时间类型，日1周2月3
     */
    private String mtype;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 是否有效，默认0，无效为1
     */
    private String status;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取项目名
     *
     * @return name - 项目名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置项目名
     *
     * @param name 项目名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取描述
     *
     * @return des - 描述
     */
    public String getDes() {
        return des;
    }

    /**
     * 设置描述
     *
     * @param des 描述
     */
    public void setDes(String des) {
        this.des = des;
    }

    /**
     * 获取语言，Java还是python等
     *
     * @return languages - 语言，Java还是python等
     */
    public String getLanguages() {
        return languages;
    }

    /**
     * 设置语言，Java还是python等
     *
     * @param languages 语言，Java还是python等
     */
    public void setLanguages(String languages) {
        this.languages = languages;
    }

    /**
     * 获取项目地址
     *
     * @return url - 项目地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置项目地址
     *
     * @param url 项目地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取stars数量
     *
     * @return stars - stars数量
     */
    public String getStars() {
        return stars;
    }

    /**
     * 设置stars数量
     *
     * @param stars stars数量
     */
    public void setStars(String stars) {
        this.stars = stars;
    }

    /**
     * 获取fork数量
     *
     * @return forks - fork数量
     */
    public String getForks() {
        return forks;
    }

    /**
     * 设置fork数量
     *
     * @param forks fork数量
     */
    public void setForks(String forks) {
        this.forks = forks;
    }

    /**
     * 获取增加的start
     *
     * @return staradd - 增加的start
     */
    public String getStaradd() {
        return staradd;
    }

    /**
     * 设置增加的start
     *
     * @param staradd 增加的start
     */
    public void setStaradd(String staradd) {
        this.staradd = staradd;
    }

    /**
     * 获取语言类型，感觉是多余的
     *
     * @return ltype - 语言类型，感觉是多余的
     */
    public String getLtype() {
        return ltype;
    }

    /**
     * 设置语言类型，感觉是多余的
     *
     * @param ltype 语言类型，感觉是多余的
     */
    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    /**
     * 获取时间类型，日1周2月3
     *
     * @return mtype - 时间类型，日1周2月3
     */
    public String getMtype() {
        return mtype;
    }

    /**
     * 设置时间类型，日1周2月3
     *
     * @param mtype 时间类型，日1周2月3
     */
    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取是否有效，默认0，无效为1
     *
     * @return status - 是否有效，默认0，无效为1
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置是否有效，默认0，无效为1
     *
     * @param status 是否有效，默认0，无效为1
     */
    public void setStatus(String status) {
        this.status = status;
    }
}