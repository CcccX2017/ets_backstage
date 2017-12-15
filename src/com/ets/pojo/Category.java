package com.ets.pojo;

import java.util.Date;

public class Category {
    private Long categoryId;

    private Long parentId;

    private String name;

    private Integer state;

    private Integer sortOrder;

    private Date createdtime;

    private Date updatedtime;

    public Category(Long categoryId, Long parentId, String name, Integer state, Integer sortOrder, Date createdtime, Date updatedtime) {
        this.categoryId = categoryId;
        this.parentId = parentId;
        this.name = name;
        this.state = state;
        this.sortOrder = sortOrder;
        this.createdtime = createdtime;
        this.updatedtime = updatedtime;
    }

    public Category() {
        super();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public Date getUpdatedtime() {
        return updatedtime;
    }

    public void setUpdatedtime(Date updatedtime) {
        this.updatedtime = updatedtime;
    }
}