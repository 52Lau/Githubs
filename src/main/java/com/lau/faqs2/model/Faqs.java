package com.lau.faqs2.model;

import javax.persistence.*;

public class Faqs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String createdate;

    private String content;

    private Integer classid;
    private Classes classes;

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return createdate
     */
    public String getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate
     */
    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return classid
     */
    public Integer getClassid() {
        return classid;
    }

    /**
     * @param classid
     */
    public void setClassid(Integer classid) {
        this.classid = classid;
    }
}