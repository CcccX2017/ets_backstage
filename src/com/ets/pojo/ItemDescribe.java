package com.ets.pojo;

import java.util.Date;

public class ItemDescribe {
    private Long itemId;

    private String itemDesc;

    private Date createdtime;

    private Date updatedtime;

    public ItemDescribe(Long itemId, String itemDesc, Date createdtime, Date updatedtime) {
        this.itemId = itemId;
        this.itemDesc = itemDesc;
        this.createdtime = createdtime;
        this.updatedtime = updatedtime;
    }

    public ItemDescribe() {
        super();
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
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