/**
 * @author: li_xiaodong  
 * @date: 2018年3月1日 上午11:15:33
 */
package com.autobot.res;

/**
 * 类名称：Tree 类描述：树形结构
 */
public class Tree {

	private String id;
	private String pId;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tree [id=" + id + ", pId=" + pId + ", name=" + name + "]";
	}

}
