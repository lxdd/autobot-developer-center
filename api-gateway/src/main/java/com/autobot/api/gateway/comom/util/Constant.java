/**
 * @author: li_xiaodong  
 * @date: 2018年3月4日 下午10:45:18
 */
package com.autobot.api.gateway.comom.util;

/**
 * (常量接口)
 * 
 * @author (li_xiaodong)
 * @date 2015年10月14日 下午7:48:54
 */
public interface Constant {

	/**
	 * 返回码 key
	 */
	String RETURN_CODE_KEY = "returnCode";

	/**
	 * 返回消息值 key
	 */
	String RETURN_MSG_KEY = "returnMsg";

	/**
	 * 返回值 key
	 */
	String RETURN_DATA_KEY = "returnValue";

	/**
	 * 登录用户 权限key
	 */
	String SESSION_KEY_AUTH_URL = "authUrl";

	/**
	 * 数据权限标示key
	 */
	String DATA_AUTH_KEY = "dataAuth";

	// 日志级别相关==============================
	String LOG4J_LEVEL_INFO = "performance"; // 普通级

	String LOG4J_LEVEL_ERROR = "error"; // 错误级

	String LOG4J_LEVEL_DEBUG = "debug"; // 跟踪日志

	String LOG4J_LEVEL_WARN = "warn"; // 提示级

	String LOG4J_JOIN_SIGN = "."; // 包路径与日志链接符号

	/**
	 * 字符类型，值为：UTF-8。
	 */
	String CHARSET_UTF8 = "UTF-8";

	/**
	 * 签名的摘要算法，可选值为：hmac，md5。
	 */
	String SIGN_METHOD_MD5 = "md5";

	/**
	 * 签名的摘要算法，可选值为：hmac，md5。
	 */
	String SIGN_METHOD_HMAC = "hmac";

	// 文件渠道系统 文件状态编码==============================
	/**
	 * 文件渠道-文件上传状态-等待上传
	 */
	Integer FILE_CHANNEL_FILE_STATE_WAITING = 10001;

	/**
	 * 文件渠道-文件上传状态-上传成功
	 */
	Integer FILE_CHANNEL_FILE_STATE_FINISH = 10002;

	/**
	 * 文件渠道-文件类型-图片-pic
	 */
	String FILE_CHANNEL_FILE_TYPE_PIC = "pic";

	/**
	 * 文件系统-CRIC - 文件上传是否预处理-是
	 */
	String FILE_SYSTEM_CRIC_IS_HANDLE_YES = "1";

	/**
	 * 文件系统Code-克尔瑞-"CRIC"
	 */
	String FILE_SYSTEM_CRIC = "CRIC";

	/**
	 * 文件系统Code-实惠-"weiphoto"
	 */
	String FILE_SYSTEM_WEIPHOTO = "weiphoto";

	/**
	 * 文件系统Code-创研-"ESS"
	 */
	String FILE_SYSTEM_ESS = "ESS";

	// 总线FESB系统公共参数名==============================
	/**
	 * 总线FESB系统公共参数名--认证key -- appkey
	 */
	String FESB_COMMON_PARAM_APPKEY = "appkey";

	/**
	 * 总线FESB系统公共参数名--认证appsecret -- appsecret
	 */
	String FESB_COMMON_PARAM_APPSECRET = "appsecret";

	/**
	 * 总线FESB系统公共参数名--签名 sign
	 */
	String FESB_COMMON_PARAM_SIGN = "sign";

	/**
	 * 总线FESB系统公共参数名--时间戳 timestamp
	 */
	String FESB_COMMON_PARAM_TIMESTAMP = "timestamp";

	/**
	 * 总线FESB系统公共参数名--api接口名 method
	 */
	String FESB_COMMON_PARAM_METHOD = "method";

	/**
	 * 总线FESB系统公共参数名--api版本 apiversion
	 */
	String FESB_COMMON_PARAM_APIVERSION = "apiversion";

}
