package com.lau.githubs.model;

import com.lau.githubs.githubspider.dto.GitHubUserInfo;

import javax.persistence.*;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String login;

    @Column(name = "node_id")
    private String nodeId;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "gravatar_id")
    private String gravatarId;

    private String url;

    @Column(name = "html_url")
    private String htmlUrl;

    @Column(name = "followers_url")
    private String followersUrl;

    @Column(name = "following_url")
    private String followingUrl;

    @Column(name = "gists_url")
    private String gistsUrl;

    @Column(name = "starred_url")
    private String starredUrl;

    @Column(name = "subscriptions_url")
    private String subscriptionsUrl;

    @Column(name = "organizations_url")
    private String organizationsUrl;

    @Column(name = "repos_url")
    private String reposUrl;

    @Column(name = "events_url")
    private String eventsUrl;

    @Column(name = "received_events_url")
    private String receivedEventsUrl;

    private String type;

    @Column(name = "site_admin")
    private Boolean siteAdmin;

    private String name;

    private String company;

    private String blog;

    private String location;

    private String email;

    private String hireable;

    private String bio;

    @Column(name = "public_repos")
    private String publicRepos;

    @Column(name = "public_gists")
    private String publicGists;

    private String followers;

    private String following;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;


    public User(GitHubUserInfo gitHubUserInfo) {
        this.login = gitHubUserInfo.getLogin();
        this.nodeId = gitHubUserInfo.getNode_id();
        this.avatarUrl = gitHubUserInfo.getAvatar_url();
        this.gravatarId = gitHubUserInfo.getGravatar_id();
        this.url = gitHubUserInfo.getUrl();
        this.htmlUrl = gitHubUserInfo.getHtml_url();
        this.followersUrl = gitHubUserInfo.getFollowers_url();
        this.followingUrl = gitHubUserInfo.getFollowing_url();
        this.gistsUrl = gitHubUserInfo.getGists_url();
        this.starredUrl = gitHubUserInfo.getStarred_url();
        this.subscriptionsUrl = gitHubUserInfo.getSubscriptions_url();
        this.organizationsUrl = gitHubUserInfo.getOrganizations_url();
        this.reposUrl = gitHubUserInfo.getRepos_url();
        this.eventsUrl = gitHubUserInfo.getEvents_url();
        this.receivedEventsUrl = gitHubUserInfo.getReceived_events_url();
        this.type = gitHubUserInfo.getType();
        this.siteAdmin = gitHubUserInfo.isSite_admin();
        if (gitHubUserInfo.getName() != null) {
            this.name = gitHubUserInfo.getName().toString();
        }
        if (gitHubUserInfo.getCompany() != null) {
            this.company = gitHubUserInfo.getCompany().toString();
        }
        this.blog = gitHubUserInfo.getBlog();
        if (gitHubUserInfo.getLocation() != null) {
            this.location = gitHubUserInfo.getLocation().toString();
        }
        if (gitHubUserInfo.getEmail() != null) {
            this.email = gitHubUserInfo.getEmail().toString();
        }

        if (gitHubUserInfo.getHireable() != null) {
            this.hireable = gitHubUserInfo.getHireable().toString();
        }
        if (gitHubUserInfo.getBio() != null) {
            this.bio = gitHubUserInfo.getBio().toString();
        }
        this.publicRepos = String.valueOf(gitHubUserInfo.getPublic_repos());
        this.publicGists = String.valueOf(gitHubUserInfo.getPublic_gists());
        this.followers = String.valueOf(gitHubUserInfo.getFollowers());
        this.following = String.valueOf(gitHubUserInfo.getFollowing());
        this.createdAt = gitHubUserInfo.getCreated_at();
        this.updatedAt = gitHubUserInfo.getUpdated_at();
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return node_id
     */
    public String getNodeId() {
        return nodeId;
    }

    /**
     * @param nodeId
     */
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * @return avatar_url
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * @param avatarUrl
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * @return gravatar_id
     */
    public String getGravatarId() {
        return gravatarId;
    }

    /**
     * @param gravatarId
     */
    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return html_url
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * @param htmlUrl
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     * @return followers_url
     */
    public String getFollowersUrl() {
        return followersUrl;
    }

    /**
     * @param followersUrl
     */
    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    /**
     * @return following_url
     */
    public String getFollowingUrl() {
        return followingUrl;
    }

    /**
     * @param followingUrl
     */
    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    /**
     * @return gists_url
     */
    public String getGistsUrl() {
        return gistsUrl;
    }

    /**
     * @param gistsUrl
     */
    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    /**
     * @return starred_url
     */
    public String getStarredUrl() {
        return starredUrl;
    }

    /**
     * @param starredUrl
     */
    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    /**
     * @return subscriptions_url
     */
    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    /**
     * @param subscriptionsUrl
     */
    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    /**
     * @return organizations_url
     */
    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    /**
     * @param organizationsUrl
     */
    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    /**
     * @return repos_url
     */
    public String getReposUrl() {
        return reposUrl;
    }

    /**
     * @param reposUrl
     */
    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    /**
     * @return events_url
     */
    public String getEventsUrl() {
        return eventsUrl;
    }

    /**
     * @param eventsUrl
     */
    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    /**
     * @return received_events_url
     */
    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    /**
     * @param receivedEventsUrl
     */
    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return site_admin
     */
    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    /**
     * @param siteAdmin
     */
    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return blog
     */
    public String getBlog() {
        return blog;
    }

    /**
     * @param blog
     */
    public void setBlog(String blog) {
        this.blog = blog;
    }

    /**
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return hireable
     */
    public String getHireable() {
        return hireable;
    }

    /**
     * @param hireable
     */
    public void setHireable(String hireable) {
        this.hireable = hireable;
    }

    /**
     * @return bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * @param bio
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * @return public_repos
     */
    public String getPublicRepos() {
        return publicRepos;
    }

    /**
     * @param publicRepos
     */
    public void setPublicRepos(String publicRepos) {
        this.publicRepos = publicRepos;
    }

    /**
     * @return public_gists
     */
    public String getPublicGists() {
        return publicGists;
    }

    /**
     * @param publicGists
     */
    public void setPublicGists(String publicGists) {
        this.publicGists = publicGists;
    }

    /**
     * @return followers
     */
    public String getFollowers() {
        return followers;
    }

    /**
     * @param followers
     */
    public void setFollowers(String followers) {
        this.followers = followers;
    }

    /**
     * @return following
     */
    public String getFollowing() {
        return following;
    }

    /**
     * @param following
     */
    public void setFollowing(String following) {
        this.following = following;
    }

    /**
     * @return created_at
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return updated_at
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}