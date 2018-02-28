package com.autobot.res.adc.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 模板业务数据
 * @author li_xiaodong
 * @date: 2018年2月28日 上午11:54:19
 */
public class TemplateBO implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String templateName;

	private Date gmtCreate;

	private String nameCreate;

	private Date gmtModified;

	private String nameModified;

	private String templateContent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName == null ? null : templateName.trim();
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

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent == null ? null : templateContent.trim();
	}

	@Override
	public String toString() {
		return "TemplateBO [id=" + id + ", templateName=" + templateName + ", gmtCreate=" + gmtCreate + ", nameCreate="
				+ nameCreate + ", gmtModified=" + gmtModified + ", nameModified=" + nameModified + ", templateContent="
				+ templateContent + "]";
	}

}