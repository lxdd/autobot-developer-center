package com.autobot.res.adc.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TODO
 * @author li_xiaodong
 * @date: 2018年2月28日 下午7:39:06
 */
public class ArticleVO implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	private List<Integer> serveIdList;

	private String title;

	private Integer type;

	private String interfacePath;

	private String nameCreate;

	private String nameModified;

	private String content;

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

	@Override
	public String toString() {
		return "ArticleVO [serveIdList=" + serveIdList + ", title=" + title + ", type=" + type + ", interfacePath="
				+ interfacePath + ", nameCreate=" + nameCreate + ", nameModified=" + nameModified + ", content="
				+ content + "]";
	}

}