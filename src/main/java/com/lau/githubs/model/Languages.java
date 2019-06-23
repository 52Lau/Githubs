package com.lau.githubs.model;

import javax.persistence.*;

public class Languages {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 语言类型
     */
    private String languages;

    /**
     * 状态
     */
    private Integer status;

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
     * 获取语言类型
     *
     * @return languages - 语言类型
     */
    public String getLanguages() {
        return languages;
    }

    /**
     * 设置语言类型
     *
     * @param languages 语言类型
     */
    public void setLanguages(String languages) {
        this.languages = languages;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}