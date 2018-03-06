package com.autobot.res.adc.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @author li_xiaodong
 * @date: 2018年2月28日 下午7:11:31
 */
public class ArticleQuery implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	private List<Integer> serveIdList;

	private Integer articleId;

	private String title;

	private Integer type;

	private String interfacePath;

	private String nameCreate;

	private Date gmtCreate;

	private String nameModified;

	private Date gmtModified;

	private String content;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public List<Integer> getServeIdList() {
		return serveIdList;
	}

	public void setServeIdList(List<Integer> serveIdList) {
		this.serveIdList = serveIdList;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
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

	@Override
	public String toString() {
		return "ArticleQuery [serveIdList=" + serveIdList + ", articleId=" + articleId + ", title=" + title + ", type="
				+ type + ", interfacePath=" + interfacePath + ", nameCreate=" + nameCreate + ", gmtCreate=" + gmtCreate
				+ ", nameModified=" + nameModified + ", gmtModified=" + gmtModified + ", content=" + content + "]";
	}

}