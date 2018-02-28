package com.autobot.res.adc.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: TODO
 * @author li_xiaodong
 * @date: 2018年2月28日 下午7:28:50 
 */
public class ServeBO implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

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

	@Override
	public String toString() {
		return "ServeBO [serveId=" + serveId + ", serveName=" + serveName + ", serveAddr=" + serveAddr
				+ ", serveRemark=" + serveRemark + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified
				+ ", nameCreate=" + nameCreate + ", nameModified=" + nameModified + ", isDeleted=" + isDeleted + "]";
	}

}