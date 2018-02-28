package com.autobot.res.adc.vo;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author li_xiaodong
 * @date: 2018年2月28日 下午7:41:36 
 */
public class ServeVO  implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */
	private static final long serialVersionUID = 1L;

	private String serveName;

	private String serveAddr;

	private String serveRemark;

	private String nameCreate;

	private String nameModified;

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

	@Override
	public String toString() {
		return "ServeVO [serveName=" + serveName + ", serveAddr=" + serveAddr + ", serveRemark=" + serveRemark
				+ ", nameCreate=" + nameCreate + ", nameModified=" + nameModified + "]";
	}

}