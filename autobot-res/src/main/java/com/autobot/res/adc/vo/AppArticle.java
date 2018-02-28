package com.autobot.res.adc.vo;

import java.io.Serializable;
import java.util.Date;

public class AppArticle  implements Serializable {
    /**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer appId;

    private Integer articleId;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
    
}