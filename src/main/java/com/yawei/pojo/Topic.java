package com.yawei.pojo;


public class Topic {

    private Integer id;
    private String title;
    private String text;
    private String createtime;
    private Integer userid;
    private Integer viewnum;
    private Integer nodeid;
    private Integer favnum;
    private Integer likenum;
    private Integer replaynum;
    private String replaytime;

    private ForumUser forumUser;
    private Node node;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getViewnum() {
        return viewnum;
    }

    public void setViewnum(Integer viewnum) {
        this.viewnum = viewnum;
    }

    public Integer getNodeid() {
        return nodeid;
    }

    public void setNodeid(Integer nodeid) {
        this.nodeid = nodeid;
    }

    public Integer getFavnum() {
        return favnum;
    }

    public void setFavnum(Integer favnum) {
        this.favnum = favnum;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public Integer getReplaynum() {
        return replaynum;
    }

    public void setReplaynum(Integer replaynum) {
        this.replaynum = replaynum;
    }

    public String getReplaytime() {
        return replaytime;
    }

    public void setReplaytime(String replaytime) {
        this.replaytime = replaytime;
    }

    public ForumUser getForumUser() {
        return forumUser;
    }

    public void setForumUser(ForumUser forumUser) {
        this.forumUser = forumUser;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "replaytime='" + replaytime + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createtime='" + createtime + '\'' +
                ", userid=" + userid +
                ", viewnum=" + viewnum +
                ", nodeid=" + nodeid +
                ", favnum=" + favnum +
                ", likenum=" + likenum +
                ", replaynum=" + replaynum +
                '}';
    }
}

