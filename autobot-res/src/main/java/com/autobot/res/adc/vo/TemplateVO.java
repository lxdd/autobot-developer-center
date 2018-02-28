package com.autobot.res.adc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: TODO
 * @author li_xiaodong
 * @date: 2018年2月28日 下午12:57:49
 */
public class TemplateVO implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	private String templateName;

	private String nameCreate;

	private String nameModified;

	private Date gmtCreate;

	private String templateContent;

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getNameCreate() {
		return nameCreate;
	}

	public void setNameCreate(String nameCreate) {
		this.nameCreate = nameCreate;
	}

	public String getNameModified() {
		return nameModified;
	}

	public void setNameModified(String nameModified) {
		this.nameModified = nameModified;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	@Override
	public String toString() {
		return "TemplateVO [templateName=" + templateName + ", nameCreate=" + nameCreate + ", nameModified="
				+ nameModified + ", gmtCreate=" + gmtCreate + ", templateContent=" + templateContent + "]";
	}

}