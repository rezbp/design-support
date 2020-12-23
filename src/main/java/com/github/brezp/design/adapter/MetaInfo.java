package com.github.brezp.design.adapter;

import java.util.Date;

/**
 * @author brezp
 */
public class MetaInfo {

    private String bizId;

    private Date bizTime;

    private String bizDesc;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Date getBizTime() {
        return bizTime;
    }

    public void setBizTime(Date bizTime) {
        this.bizTime = bizTime;
    }

    public String getDesc() {
        return bizDesc;
    }

    public void setDesc(String desc) {
        this.bizDesc = desc;
    }
}
