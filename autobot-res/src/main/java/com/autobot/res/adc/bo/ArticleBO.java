package com.autobot.res.adc.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description: ArticleBO
 * @author li_xiaodong
 * @date: 2018年3月1日 下午2:11:25
 */
public class ArticleBO implements Serializable {

	/**
	 * @Fields serialVersionUID : serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Integer articleId;

	private String title;

	private Integer type;

	private String interfacePath;

	private Date gmtCreate;

	private String nameCreate;

	private Date gmtModified;

	private String nameModified;

	private Integer isDeleted;

	private String content;

	/**
	 * @Fields serveList : 文档所属服务方List
	 */
	private List<ServeBO> serveList;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getInterfacePath() {
		return interfacePath;
	}

	public void setInterfacePath(String interfacePath) {
		this.interfacePath = interfacePath == null ? null : interfacePath.trim();
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getNameCreate() {
		return nameCreate;
	}

	public void setNameCreate(String nameCreate) {
		this.nameCreate = nameCreate == null ? null : nameCreate.trim();
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public List<ServeBO> getServeList() {
		return serveList;
	}

	public void setServeList(List<ServeBO> serveList) {
		this.serveList = serveList;
	}

	@Override
	public String toString() {
		return "ArticleBO [articleId=" + articleId + ", title=" + title + ", type=" + type + ", interfacePath="
				+ interfacePath + ", gmtCreate=" + gmtCreate + ", nameCreate=" + nameCreate + ", gmtModified="
				+ gmtModified + ", nameModified=" + nameModified + ", isDeleted=" + isDeleted + ", content=" + content
				+ ", serveList=" + serveList + "]";
	}

}