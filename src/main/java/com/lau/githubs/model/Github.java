package com.lau.githubs.model;

import java.util.Date;
import javax.persistence.*;

public class Github {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "create_date")
    private Date createDate;

    private String description;

    @Column(name = "first_commit_date")
    private Date firstCommitDate;

    private Integer forks;

    private String language;

    @Column(name = "last_commit_date")
    private Date lastCommitDate;

    private String owner;

    @Column(name = "owner_avatar_url")
    private String ownerAvatarUrl;

    private Integer ownerid;

    private Integer projectid;

    @Column(name = "project_name")
    private String projectName;

    private Integer stars;

    private Integer watchers;

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
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return first_commit_date
     */
    public Date getFirstCommitDate() {
        return firstCommitDate;
    }

    /**
     * @param firstCommitDate
     */
    public void setFirstCommitDate(Date firstCommitDate) {
        this.firstCommitDate = firstCommitDate;
    }

    /**
     * @return forks
     */
    public Integer getForks() {
        return forks;
    }

    /**
     * @param forks
     */
    public void setForks(Integer forks) {
        this.forks = forks;
    }

    /**
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return last_commit_date
     */
    public Date getLastCommitDate() {
        return lastCommitDate;
    }

    /**
     * @param lastCommitDate
     */
    public void setLastCommitDate(Date lastCommitDate) {
        this.lastCommitDate = lastCommitDate;
    }

    /**
     * @return owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return owner_avatar_url
     */
    public String getOwnerAvatarUrl() {
        return ownerAvatarUrl;
    }

    /**
     * @param ownerAvatarUrl
     */
    public void setOwnerAvatarUrl(String ownerAvatarUrl) {
        this.ownerAvatarUrl = ownerAvatarUrl;
    }

    /**
     * @return ownerid
     */
    public Integer getOwnerid() {
        return ownerid;
    }

    /**
     * @param ownerid
     */
    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    /**
     * @return projectid
     */
    public Integer getProjectid() {
        return projectid;
    }

    /**
     * @param projectid
     */
    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    /**
     * @return project_name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return stars
     */
    public Integer getStars() {
        return stars;
    }

    /**
     * @param stars
     */
    public void setStars(Integer stars) {
        this.stars = stars;
    }

    /**
     * @return watchers
     */
    public Integer getWatchers() {
        return watchers;
    }

    /**
     * @param watchers
     */
    public void setWatchers(Integer watchers) {
        this.watchers = watchers;
    }
}