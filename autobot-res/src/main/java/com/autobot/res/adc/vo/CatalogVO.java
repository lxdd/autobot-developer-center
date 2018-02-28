package com.autobot.res.adc.vo;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author li_xiaodong
 * @date: 2018年2月28日 下午7:38:50
 */
public class CatalogVO implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	private Integer parentId;

	private Integer serveId;

	private String url;

	private String nameCreate;

	private String nameModified;

	private Integer isDeleted;

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

	@Override
	public String toString() {
		return "CatalogVO [parentId=" + parentId + ", serveId=" + serveId + ", url=" + url + ", nameCreate="
				+ nameCreate + ", nameModified=" + nameModified + ", isDeleted=" + isDeleted + "]";
	}

}