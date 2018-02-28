package com.autobot.res.adc.vo;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author li_xiaodong
 * @date: 2018年2月28日 下午7:16:49
 */
public class AppVO implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	private Integer appId;

	private String appCode;

	private String appName;

	private String appKey;

	private String appSecret;

	private Integer isAuth;

	private String nameCreate;

	private String nameModified;

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode == null ? null : appCode.trim();
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName == null ? null : appName.trim();
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey == null ? null : appKey.trim();
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret == null ? null : appSecret.trim();
	}

	public Integer getIsAuth() {
		return isAuth;
	}

	public void setIsAuth(Integer isAuth) {
		this.isAuth = isAuth;
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
		return "AppVO [appId=" + appId + ", appCode=" + appCode + ", appName=" + appName + ", appKey=" + appKey
				+ ", appSecret=" + appSecret + ", isAuth=" + isAuth + ", nameCreate=" + nameCreate + ", nameModified="
				+ nameModified + "]";
	}

}