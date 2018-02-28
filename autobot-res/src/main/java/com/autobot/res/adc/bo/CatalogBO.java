package com.autobot.res.adc.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: TODO
 * @author li_xiaodong
 * @date: 2018年2月28日 下午7:31:23 
 */
public class CatalogBO implements Serializable {
	
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer parentId;

	private Integer serveId;

	private String url;

	private Date gmtCreate;

	private String nameCreate;

	private Date gmtModified;

	private String nameModified;

	private Integer isDeleted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getServeId() {
		return serveId;
	}

	public void setServeId(Integer serveId) {
		this.serveId = serveId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
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

	@Override
	public String toString() {
		return "CatalogBO [id=" + id + ", parentId=" + parentId + ", serveId=" + serveId + ", url=" + url
				+ ", gmtCreate=" + gmtCreate + ", nameCreate=" + nameCreate + ", gmtModified=" + gmtModified
				+ ", nameModified=" + nameModified + ", isDeleted=" + isDeleted + "]";
	}

}