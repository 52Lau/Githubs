package com.lau.githubs.model;

import com.lau.githubs.githubspider.dto.GitHubUserRepo;

import java.util.Date;
import javax.persistence.*;

public class Repo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "node_id")
    private String nodeId;

    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "owner_id")
    private String ownerId;

    @Column(name = "html_url")
    private String htmlUrl;

    private String description;

    private String fork;

    private String url;

    @Column(name = "forks_url")
    private String forksUrl;

    @Column(name = "keys_url")
    private String keysUrl;

    @Column(name = "collaborators_url")
    private String collaboratorsUrl;

    @Column(name = "teams_url")
    private String teamsUrl;

    @Column(name = "hooks_url")
    private String hooksUrl;

    @Column(name = "issue_events_url")
    private String issueEventsUrl;

    @Column(name = "events_url")
    private String eventsUrl;

    @Column(name = "assignees_url")
    private String assigneesUrl;

    @Column(name = "branches_url")
    private String branchesUrl;

    @Column(name = "tags_url")
    private String tagsUrl;

    @Column(name = "blobs_url")
    private String blobsUrl;

    @Column(name = "git_tags_url")
    private String gitTagsUrl;

    @Column(name = "git_refs_url")
    private String gitRefsUrl;

    @Column(name = "trees_url")
    private String treesUrl;

    @Column(name = "statuses_url")
    private String statusesUrl;

    @Column(name = "languages_url")
    private String languagesUrl;

    @Column(name = "stargazers_url")
    private String stargazersUrl;

    @Column(name = "contributors_url")
    private String contributorsUrl;

    @Column(name = "subscribers_url")
    private String subscribersUrl;

    @Column(name = "subscription_url")
    private String subscriptionUrl;

    @Column(name = "commits_url")
    private String commitsUrl;

    @Column(name = "git_commits_url")
    private String gitCommitsUrl;

    @Column(name = "comments_url")
    private String commentsUrl;

    @Column(name = "issue_comment_url")
    private String issueCommentUrl;

    @Column(name = "contents_url")
    private String contentsUrl;

    @Column(name = "compare_url")
    private String compareUrl;

    @Column(name = "merges_url")
    private String mergesUrl;

    @Column(name = "archive_url")
    private String archiveUrl;

    @Column(name = "downloads_url")
    private String downloadsUrl;

    @Column(name = "issues_url")
    private String issuesUrl;

    @Column(name = "pulls_url")
    private String pullsUrl;

    @Column(name = "milestones_url")
    private String milestonesUrl;

    @Column(name = "notifications_url")
    private String notificationsUrl;

    @Column(name = "labels_url")
    private String labelsUrl;

    @Column(name = "releases_url")
    private String releasesUrl;

    @Column(name = "deployments_url")
    private String deploymentsUrl;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @Column(name = "pushed_at")
    private String pushedAt;

    @Column(name = "git_url")
    private String gitUrl;

    @Column(name = "ssh_url")
    private String sshUrl;

    @Column(name = "clone_url")
    private String cloneUrl;

    @Column(name = "svn_url")
    private String svnUrl;

    private String homepage;

    private String size;

    @Column(name = "stargazers_count")
    private String stargazersCount;

    @Column(name = "watchers_count")
    private String watchersCount;

    private String language;

    @Column(name = "has_issues")
    private Boolean hasIssues;

    @Column(name = "has_projects")
    private Boolean hasProjects;

    @Column(name = "has_downloads")
    private Boolean hasDownloads;

    @Column(name = "has_wiki")
    private Boolean hasWiki;

    @Column(name = "has_pages")
    private Boolean hasPages;

    @Column(name = "forks_count")
    private String forksCount;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;



    public Repo(GitHubUserRepo repo) {
        this.nodeId = repo.getNode_id();
        this.name = repo.getName();
        this.fullName = repo.getFull_name();
        this.ownerId = repo.getOwner().getLogin();
        this.htmlUrl = repo.getHtml_url();
        this.description = repo.getDescription();
        this.fork = repo.getArchive_url();
        this.url = repo.getUrl();
        this.forksUrl = repo.getForks_url();
        this.keysUrl = repo.getKeys_url();
        this.collaboratorsUrl = repo.getCollaborators_url();
        this.teamsUrl = repo.getTeams_url();
        this.hooksUrl = repo.getHooks_url();
        this.issueEventsUrl = repo.getIssue_events_url();
        this.eventsUrl = repo.getEvents_url();
        this.assigneesUrl = repo.getAssignees_url();
        this.branchesUrl = repo.getBranches_url();
        this.tagsUrl = repo.getTags_url();
        this.blobsUrl = repo.getBlobs_url();
        this.gitTagsUrl = repo.getGit_tags_url();
        this.gitRefsUrl = repo.getGit_refs_url();
        this.treesUrl = repo.getTrees_url();
        this.statusesUrl = repo.getStatuses_url();
        this.languagesUrl = repo.getLanguages_url();
        this.stargazersUrl = repo.getStargazers_url();
        this.contributorsUrl = repo.getContributors_url();
        this.subscribersUrl = repo.getSubscribers_url();
        this.subscriptionUrl = repo.getSubscription_url();
        this.commitsUrl = repo.getCommits_url();
        this.gitCommitsUrl = repo.getGit_commits_url();
        this.commentsUrl = repo.getComments_url();
        this.issueCommentUrl = repo.getIssue_comment_url();
        this.contentsUrl = repo.getContents_url();
        this.compareUrl = repo.getCompare_url();
        this.mergesUrl = repo.getMerges_url();
        this.archiveUrl = repo.getArchive_url();
        this.downloadsUrl = repo.getDownloads_url();
        this.issuesUrl = repo.getIssues_url();
        this.pullsUrl = repo.getPulls_url();
        this.milestonesUrl = repo.getMilestones_url();
        this.notificationsUrl = repo.getNotifications_url();
        this.labelsUrl = repo.getLabels_url();
        this.releasesUrl = repo.getReleases_url();
        this.deploymentsUrl = repo.getDeployments_url();
        this.createdAt = repo.getCreated_at();
        this.updatedAt = repo.getUpdated_at();
        this.pushedAt = repo.getPushed_at();
        this.gitUrl = repo.getUrl();
        this.sshUrl = repo.getSsh_url();
        this.cloneUrl = repo.getClone_url();
        this.svnUrl = repo.getSvn_url();
        if (repo.getHomepage() != null) {
            this.homepage = repo.getHomepage().toString();
        }
        this.size = String.valueOf(repo.getSize());
        this.stargazersCount = String.valueOf(repo.getStargazers_count());
        this.watchersCount = String.valueOf(repo.getWatchers_count());
        this.language = repo.getLanguage();
        this.hasIssues = repo.isHas_issues();
        this.hasProjects = repo.isHas_projects();
        this.hasDownloads = repo.isHas_downloads();
        this.hasWiki = repo.isHas_wiki();
        this.hasPages = repo.isHas_pages();
        this.forksCount = String.valueOf(repo.getForks_count());
        this.createTime=new Date();
        this.updateTime=new Date();
    }


    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return full_name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return owner_id
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * @param ownerId
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
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
     * @return fork
     */
    public String getFork() {
        return fork;
    }

    /**
     * @param fork
     */
    public void setFork(String fork) {
        this.fork = fork;
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
     * @return forks_url
     */
    public String getForksUrl() {
        return forksUrl;
    }

    /**
     * @param forksUrl
     */
    public void setForksUrl(String forksUrl) {
        this.forksUrl = forksUrl;
    }

    /**
     * @return keys_url
     */
    public String getKeysUrl() {
        return keysUrl;
    }

    /**
     * @param keysUrl
     */
    public void setKeysUrl(String keysUrl) {
        this.keysUrl = keysUrl;
    }

    /**
     * @return collaborators_url
     */
    public String getCollaboratorsUrl() {
        return collaboratorsUrl;
    }

    /**
     * @param collaboratorsUrl
     */
    public void setCollaboratorsUrl(String collaboratorsUrl) {
        this.collaboratorsUrl = collaboratorsUrl;
    }

    /**
     * @return teams_url
     */
    public String getTeamsUrl() {
        return teamsUrl;
    }

    /**
     * @param teamsUrl
     */
    public void setTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
    }

    /**
     * @return hooks_url
     */
    public String getHooksUrl() {
        return hooksUrl;
    }

    /**
     * @param hooksUrl
     */
    public void setHooksUrl(String hooksUrl) {
        this.hooksUrl = hooksUrl;
    }

    /**
     * @return issue_events_url
     */
    public String getIssueEventsUrl() {
        return issueEventsUrl;
    }

    /**
     * @param issueEventsUrl
     */
    public void setIssueEventsUrl(String issueEventsUrl) {
        this.issueEventsUrl = issueEventsUrl;
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
     * @return assignees_url
     */
    public String getAssigneesUrl() {
        return assigneesUrl;
    }

    /**
     * @param assigneesUrl
     */
    public void setAssigneesUrl(String assigneesUrl) {
        this.assigneesUrl = assigneesUrl;
    }

    /**
     * @return branches_url
     */
    public String getBranchesUrl() {
        return branchesUrl;
    }

    /**
     * @param branchesUrl
     */
    public void setBranchesUrl(String branchesUrl) {
        this.branchesUrl = branchesUrl;
    }

    /**
     * @return tags_url
     */
    public String getTagsUrl() {
        return tagsUrl;
    }

    /**
     * @param tagsUrl
     */
    public void setTagsUrl(String tagsUrl) {
        this.tagsUrl = tagsUrl;
    }

    /**
     * @return blobs_url
     */
    public String getBlobsUrl() {
        return blobsUrl;
    }

    /**
     * @param blobsUrl
     */
    public void setBlobsUrl(String blobsUrl) {
        this.blobsUrl = blobsUrl;
    }

    /**
     * @return git_tags_url
     */
    public String getGitTagsUrl() {
        return gitTagsUrl;
    }

    /**
     * @param gitTagsUrl
     */
    public void setGitTagsUrl(String gitTagsUrl) {
        this.gitTagsUrl = gitTagsUrl;
    }

    /**
     * @return git_refs_url
     */
    public String getGitRefsUrl() {
        return gitRefsUrl;
    }

    /**
     * @param gitRefsUrl
     */
    public void setGitRefsUrl(String gitRefsUrl) {
        this.gitRefsUrl = gitRefsUrl;
    }

    /**
     * @return trees_url
     */
    public String getTreesUrl() {
        return treesUrl;
    }

    /**
     * @param treesUrl
     */
    public void setTreesUrl(String treesUrl) {
        this.treesUrl = treesUrl;
    }

    /**
     * @return statuses_url
     */
    public String getStatusesUrl() {
        return statusesUrl;
    }

    /**
     * @param statusesUrl
     */
    public void setStatusesUrl(String statusesUrl) {
        this.statusesUrl = statusesUrl;
    }

    /**
     * @return languages_url
     */
    public String getLanguagesUrl() {
        return languagesUrl;
    }

    /**
     * @param languagesUrl
     */
    public void setLanguagesUrl(String languagesUrl) {
        this.languagesUrl = languagesUrl;
    }

    /**
     * @return stargazers_url
     */
    public String getStargazersUrl() {
        return stargazersUrl;
    }

    /**
     * @param stargazersUrl
     */
    public void setStargazersUrl(String stargazersUrl) {
        this.stargazersUrl = stargazersUrl;
    }

    /**
     * @return contributors_url
     */
    public String getContributorsUrl() {
        return contributorsUrl;
    }

    /**
     * @param contributorsUrl
     */
    public void setContributorsUrl(String contributorsUrl) {
        this.contributorsUrl = contributorsUrl;
    }

    /**
     * @return subscribers_url
     */
    public String getSubscribersUrl() {
        return subscribersUrl;
    }

    /**
     * @param subscribersUrl
     */
    public void setSubscribersUrl(String subscribersUrl) {
        this.subscribersUrl = subscribersUrl;
    }

    /**
     * @return subscription_url
     */
    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    /**
     * @param subscriptionUrl
     */
    public void setSubscriptionUrl(String subscriptionUrl) {
        this.subscriptionUrl = subscriptionUrl;
    }

    /**
     * @return commits_url
     */
    public String getCommitsUrl() {
        return commitsUrl;
    }

    /**
     * @param commitsUrl
     */
    public void setCommitsUrl(String commitsUrl) {
        this.commitsUrl = commitsUrl;
    }

    /**
     * @return git_commits_url
     */
    public String getGitCommitsUrl() {
        return gitCommitsUrl;
    }

    /**
     * @param gitCommitsUrl
     */
    public void setGitCommitsUrl(String gitCommitsUrl) {
        this.gitCommitsUrl = gitCommitsUrl;
    }

    /**
     * @return comments_url
     */
    public String getCommentsUrl() {
        return commentsUrl;
    }

    /**
     * @param commentsUrl
     */
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    /**
     * @return issue_comment_url
     */
    public String getIssueCommentUrl() {
        return issueCommentUrl;
    }

    /**
     * @param issueCommentUrl
     */
    public void setIssueCommentUrl(String issueCommentUrl) {
        this.issueCommentUrl = issueCommentUrl;
    }

    /**
     * @return contents_url
     */
    public String getContentsUrl() {
        return contentsUrl;
    }

    /**
     * @param contentsUrl
     */
    public void setContentsUrl(String contentsUrl) {
        this.contentsUrl = contentsUrl;
    }

    /**
     * @return compare_url
     */
    public String getCompareUrl() {
        return compareUrl;
    }

    /**
     * @param compareUrl
     */
    public void setCompareUrl(String compareUrl) {
        this.compareUrl = compareUrl;
    }

    /**
     * @return merges_url
     */
    public String getMergesUrl() {
        return mergesUrl;
    }

    /**
     * @param mergesUrl
     */
    public void setMergesUrl(String mergesUrl) {
        this.mergesUrl = mergesUrl;
    }

    /**
     * @return archive_url
     */
    public String getArchiveUrl() {
        return archiveUrl;
    }

    /**
     * @param archiveUrl
     */
    public void setArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl;
    }

    /**
     * @return downloads_url
     */
    public String getDownloadsUrl() {
        return downloadsUrl;
    }

    /**
     * @param downloadsUrl
     */
    public void setDownloadsUrl(String downloadsUrl) {
        this.downloadsUrl = downloadsUrl;
    }

    /**
     * @return issues_url
     */
    public String getIssuesUrl() {
        return issuesUrl;
    }

    /**
     * @param issuesUrl
     */
    public void setIssuesUrl(String issuesUrl) {
        this.issuesUrl = issuesUrl;
    }

    /**
     * @return pulls_url
     */
    public String getPullsUrl() {
        return pullsUrl;
    }

    /**
     * @param pullsUrl
     */
    public void setPullsUrl(String pullsUrl) {
        this.pullsUrl = pullsUrl;
    }

    /**
     * @return milestones_url
     */
    public String getMilestonesUrl() {
        return milestonesUrl;
    }

    /**
     * @param milestonesUrl
     */
    public void setMilestonesUrl(String milestonesUrl) {
        this.milestonesUrl = milestonesUrl;
    }

    /**
     * @return notifications_url
     */
    public String getNotificationsUrl() {
        return notificationsUrl;
    }

    /**
     * @param notificationsUrl
     */
    public void setNotificationsUrl(String notificationsUrl) {
        this.notificationsUrl = notificationsUrl;
    }

    /**
     * @return labels_url
     */
    public String getLabelsUrl() {
        return labelsUrl;
    }

    /**
     * @param labelsUrl
     */
    public void setLabelsUrl(String labelsUrl) {
        this.labelsUrl = labelsUrl;
    }

    /**
     * @return releases_url
     */
    public String getReleasesUrl() {
        return releasesUrl;
    }

    /**
     * @param releasesUrl
     */
    public void setReleasesUrl(String releasesUrl) {
        this.releasesUrl = releasesUrl;
    }

    /**
     * @return deployments_url
     */
    public String getDeploymentsUrl() {
        return deploymentsUrl;
    }

    /**
     * @param deploymentsUrl
     */
    public void setDeploymentsUrl(String deploymentsUrl) {
        this.deploymentsUrl = deploymentsUrl;
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

    /**
     * @return pushed_at
     */
    public String getPushedAt() {
        return pushedAt;
    }

    /**
     * @param pushedAt
     */
    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    /**
     * @return git_url
     */
    public String getGitUrl() {
        return gitUrl;
    }

    /**
     * @param gitUrl
     */
    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    /**
     * @return ssh_url
     */
    public String getSshUrl() {
        return sshUrl;
    }

    /**
     * @param sshUrl
     */
    public void setSshUrl(String sshUrl) {
        this.sshUrl = sshUrl;
    }

    /**
     * @return clone_url
     */
    public String getCloneUrl() {
        return cloneUrl;
    }

    /**
     * @param cloneUrl
     */
    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    /**
     * @return svn_url
     */
    public String getSvnUrl() {
        return svnUrl;
    }

    /**
     * @param svnUrl
     */
    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    /**
     * @return homepage
     */
    public String getHomepage() {
        return homepage;
    }

    /**
     * @param homepage
     */
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    /**
     * @return size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return stargazers_count
     */
    public String getStargazersCount() {
        return stargazersCount;
    }

    /**
     * @param stargazersCount
     */
    public void setStargazersCount(String stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    /**
     * @return watchers_count
     */
    public String getWatchersCount() {
        return watchersCount;
    }

    /**
     * @param watchersCount
     */
    public void setWatchersCount(String watchersCount) {
        this.watchersCount = watchersCount;
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
     * @return has_issues
     */
    public Boolean getHasIssues() {
        return hasIssues;
    }

    /**
     * @param hasIssues
     */
    public void setHasIssues(Boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    /**
     * @return has_projects
     */
    public Boolean getHasProjects() {
        return hasProjects;
    }

    /**
     * @param hasProjects
     */
    public void setHasProjects(Boolean hasProjects) {
        this.hasProjects = hasProjects;
    }

    /**
     * @return has_downloads
     */
    public Boolean getHasDownloads() {
        return hasDownloads;
    }

    /**
     * @param hasDownloads
     */
    public void setHasDownloads(Boolean hasDownloads) {
        this.hasDownloads = hasDownloads;
    }

    /**
     * @return has_wiki
     */
    public Boolean getHasWiki() {
        return hasWiki;
    }

    /**
     * @param hasWiki
     */
    public void setHasWiki(Boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    /**
     * @return has_pages
     */
    public Boolean getHasPages() {
        return hasPages;
    }

    /**
     * @param hasPages
     */
    public void setHasPages(Boolean hasPages) {
        this.hasPages = hasPages;
    }

    /**
     * @return forks_count
     */
    public String getForksCount() {
        return forksCount;
    }

    /**
     * @param forksCount
     */
    public void setForksCount(String forksCount) {
        this.forksCount = forksCount;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}