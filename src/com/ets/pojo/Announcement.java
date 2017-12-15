package com.ets.pojo;

import java.util.Date;

public class Announcement {
    private Integer anId;

    private String title;

    private String content;

    private Integer adId;

    private Date createtime;

    private Date updatetime;

    private Integer state;
    
    private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Announcement(Integer anId, String title, String content, Integer adId, Date createtime, Date updatetime, Integer state) {
        this.anId = anId;
        this.title = title;
        this.content = content;
        this.adId = adId;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.state = state;
    }

    public Announcement() {
        super();
    }

    public Integer getAnId() {
        return anId;
    }

    public void setAnId(Integer anId) {
        this.anId = anId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}