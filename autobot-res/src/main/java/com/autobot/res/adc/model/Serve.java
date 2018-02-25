package com.autobot.res.adc.model;

import java.util.Date;

public class Serve {
    private Integer serveId;

    private String serveName;

    private String serveAddr;

    private String serveRemark;

    private Date gmtCreate;

    private Date gmtModified;

    private String nameCreate;

    private String nameModified;

    private Integer isDeleted;

    public Integer getServeId() {
        return serveId;
    }

    public void setServeId(Integer serveId) {
        this.serveId = serveId;
    }

    public String getServeName() {
        return serveName;
    }

    public void setServeName(String serveName) {
        this.serveName = serveName == null ? null : serveName.trim();
    }

    public String getServeAddr() {
        return serveAddr;
    }

    public void setServeAddr(String serveAddr) {
        this.serveAddr = serveAddr == null ? null : serveAddr.trim();
    }

    public String getServeRemark() {
        return serveRemark;
    }

    public void setServeRemark(String serveRemark) {
        this.serveRemark = serveRemark == null ? null : serveRemark.trim();
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