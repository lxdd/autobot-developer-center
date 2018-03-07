package com.autobot.base.util;

import java.io.Serializable;

/**
 * 分页必传参数
 * 
 * @author li_xiaodong
 *
 */
public class PageUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 当前页，从1开始
	 */
	protected Integer current;

	/**
	 * 每一页大小
	 */
	protected Integer pageSize;
	
	

	public PageUtil(Integer current, Integer pageSize) {
		super();
		this.current = current;
		this.pageSize = pageSize;
	}

	// 获取偏移量
	public Integer getOffset() {

		return (getCurrent() - 1) * getPageSize();

	}

	public Integer getCurrent() {
		if (current == null || current < 1) {
			return 1;
		}

		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Integer getPageSize() {
		if (null == pageSize || pageSize <= 0) {
			return 10;
		}

		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "PageVO [current=" + current + ", pageSize=" + pageSize + "]";
	}

}
