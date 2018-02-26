package com.autobot.base.support;

import java.io.Serializable;

import com.autobot.base.util.JsonUtil;

/**
 * Rest服务 返回 结果类
 * 
 * @author (li_xiaodong)
 * @date 2016年1月19日 下午5:30:20
 * @param <T>
 */
public class PageResult<T> implements Serializable {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -7675268884737656024L;

	private String code;

	private String msg;

	private T data;

	// Extension拓展字段，供分页用

	/**
	 * 当前页数
	 */
	private Integer current;

	/**
	 * 每页多少条
	 */
	private Integer pageSize;

	/**
	 * 总条数
	 */
	private Integer totalCount;

	public PageResult() {
		// 实例化默认设置成功
		setSuccess();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 设置成功
	 */
	public void setSuccess() {
		this.setSuccess(ReturnMsg.SUCCESS_MSG);
	}

	/**
	 * 设置成功
	 */
	public void setSuccess(String successMsg) {
		this.setCode(ReturnCode.SUCCESS);
		this.setMsg(successMsg);
	}

	/**
	 * 设置失败
	 */
	public void setFail() {
		this.setFail(ReturnMsg.FAILURE_MSG);
	}

	/**
	 * 设置失败
	 */
	public void setFail(String failMsg) {
		this.setCode(ReturnCode.FAILURE);
		this.setMsg(failMsg);
	}

	@Override
	public String toString() {
		return JsonUtil.parseToJson(this);
	}
}