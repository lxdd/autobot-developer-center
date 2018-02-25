package com.autobot.res.adc.model;

import java.util.Date;

public class App {
    private Integer appId;

    private String appCode;

    private String appName;

    private String appKey;

    private String appSecret;

    private Integer isAuth;

    private Date gmtCreate;

    private Date gmtModified;

    private String nameCreate;

    private String nameModified;

    private Integer isDeleted;

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode == null ? null : appCode.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    public Integer getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(Integer isAuth) {
        this.isAuth = isAuth;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getNameCreate() {
        return nameCreate;
    }

    public void setNameCreate(String nameCreate) {
        this.nameCreate = nameCreate == null ? null : nameCreate.trim();
    }

    public String getNameModified() {
        return nameModified;
    }

    public void setNameModified(String nameModified) {
        this.nameModified = nameModified == null ? null : nameModified.trim();
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}