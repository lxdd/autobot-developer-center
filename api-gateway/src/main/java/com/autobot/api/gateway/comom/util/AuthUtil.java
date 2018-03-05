/**
 * @author: li_xiaodong  
 * @date: 2018年3月4日 下午3:18:31
 */
package com.autobot.api.gateway.comom.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 认证签名加密工具类
 * 
 * @author (li_xiaodong)
 * @date 2015年10月21日 下午1:58:28
 */
public class AuthUtil {

	/**
	 * 签名算法
	 * 
	 * @param jsonStr
	 * @param secret
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public static String sign(String jsonStr, String secret) throws Exception {
		// 待加密
		StringBuilder query = new StringBuilder();

		// 前置secret
		query.append(secret);

		// 待加密参数
		query.append(jsonStr);

		// 后置secret
		query.append(secret);

		// 使用MD5
		byte[] bytes = encryptMD5(query.toString());

		// 第四步：把二进制转化为大写的十六进制
		return byte2hex(bytes);
	}

	/**
	 * 签名生成算法
	 * 
	 * @param String
	 *            secret 签名密钥
	 * @param HashMap<String,String>
	 *            params 请求参数集，所有参数必须已转换为字符串类型 (HTTP GET)
	 * @return 签名
	 * @throws Exception
	 */
	@Deprecated
	public static String getSignature(String secret, Map<String, Object> reqMap) throws Exception {
		return getSignature(secret, reqMap, null);
	}

	/**
	 * 签名生成算法
	 * 
	 * @param String
	 *            secret 签名密钥
	 * @param dto
	 *            (HTTP POST)
	 * @return 签名
	 * @throws Exception
	 */
	@Deprecated
	public static String getSignature(String secret, String dto) throws Exception {
		return getSignature(secret, null, dto);
	}

	/**
	 * 签名生成算法
	 * 
	 * @param String
	 *            secret 签名密钥
	 * @param HashMap<String,String>
	 *            params 请求参数集，所有参数必须已转换为字符串类型 (HTTP GET)
	 * @param dto
	 *            (HTTP POST)
	 * @return 签名
	 * @throws Exception
	 */
	@Deprecated
	@SuppressWarnings("unchecked")
	public static String getSignature(String secret, Map<String, Object> reqMap, String dto) throws Exception {

		// 签名
		String sign = null;

		// 需要加密的map
		Map<String, Object> rqMap = new HashMap<String, Object>();

		if (null != reqMap) {
			rqMap = reqMap;

		} else {
			rqMap = JsonUtil.parseToObject(dto, Map.class);
		}

		// sign = createSign(secret, rqMap);

		//
		sign = signTopRequest(rqMap, secret);

		return sign;
	}

	/**
	 * 签名的摘要算法
	 * 
	 * @param secret
	 * @param reqMap
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@Deprecated
	public static String createSign(String secret, Map<String, Object> reqMap)
			throws UnsupportedEncodingException, IOException {
		// 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
		StringBuilder basestring = new StringBuilder();

		// 构建生成签名的参数Map
		Map<String, String> params = new HashMap<String, String>();

		// 待转换的参数Map
		HashMap<String, Object> rqMap = (HashMap<String, Object>) reqMap;
		for (Map.Entry<String, Object> entry : rqMap.entrySet()) {
			params.put(entry.getKey(), entry.getValue().toString());
		}

		// 先将参数以其参数名的字典序升序进行排序
		Map<String, String> sortedParams = new TreeMap<String, String>(params);

		Set<Entry<String, String>> entrys = sortedParams.entrySet();

		for (Entry<String, String> param : entrys) {
			basestring.append(param.getKey()).append("=").append(param.getValue());
		}

		basestring.append(secret);

		// 使用MD5对待签名串求签
		byte[] bytes = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			bytes = md5.digest(basestring.toString().getBytes("UTF-8"));
		} catch (GeneralSecurityException ex) {
			throw new IOException(ex);
		}

		// 将MD5输出的二进制结果转换为小写的十六进制
		StringBuilder sign = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				sign.append("0");
			}
			sign.append(hex);
		}
		return sign.toString();
	}

	/**
	 * 签名算法（取自淘宝开放平台api 签名摘要方法）
	 * 
	 * @param params
	 * @param secret
	 * @return
	 * @throws Exception
	 */
	public static String signTopRequest(Map<String, Object> params, String secret) throws Exception {
		return signTopRequest(params, secret, Constant.SIGN_METHOD_MD5);
	}

	/**
	 * 签名算法（取自淘宝开放平台api 签名摘要方法）
	 * 
	 * @param params
	 * @param secret
	 * @param signMethod
	 * @return
	 * @throws Exception
	 */
	private static String signTopRequest(Map<String, Object> params, String secret, String signMethod)
			throws Exception {
		
		// 第一步：检查参数是否已经排序
		String[] keys = params.keySet().toArray(new String[0]);
		Arrays.sort(keys);

		// 第二步：把所有参数名和参数值串在一起
		StringBuilder query = new StringBuilder();
		if (Constant.SIGN_METHOD_MD5.equals(signMethod)) {
			query.append(secret);
		}
		for (String key : keys) {
			String value = String.valueOf(params.get(key));
			if (StringUtil.isNotEmptyKeyVal(key, value)) {
				query.append(key).append(value);
			}
		}

		// 第三步：使用MD5/HMAC加密
		byte[] bytes;
		if (Constant.SIGN_METHOD_HMAC.equals(signMethod)) {
			bytes = encryptHMAC(query.toString(), secret);
		} else {
			query.append(secret);
			bytes = encryptMD5(query.toString());
		}

		// 第四步：把二进制转化为大写的十六进制
		return byte2hex(bytes);
	}

	/**
	 * HMAC加密
	 * 
	 * @param data
	 * @param secret
	 * @return
	 * @throws IOException
	 */
	private static byte[] encryptHMAC(String data, String secret) throws IOException {
		byte[] bytes = null;
		try {
			SecretKey secretKey = new SecretKeySpec(secret.getBytes(Constant.CHARSET_UTF8), "HmacMD5");
			Mac mac = Mac.getInstance(secretKey.getAlgorithm());
			mac.init(secretKey);
			bytes = mac.doFinal(data.getBytes(Constant.CHARSET_UTF8));
		} catch (GeneralSecurityException gse) {
			throw new IOException(gse.toString());
		}
		return bytes;
	}

	/**
	 * MD5加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private static byte[] encryptMD5(String data) throws Exception {
		// return encryptMD5(data.getBytes(Constant.CHARSET_UTF8));
		byte[] bytes = null;
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		bytes = md5.digest(data.getBytes("UTF-8"));
		return bytes;
	}

	/**
	 * 二进制转化为大写的十六进制
	 * 
	 * @param bytes
	 * @return
	 */
	private static String byte2hex(byte[] bytes) {
		StringBuilder sign = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				sign.append("0");
			}
			sign.append(hex.toUpperCase());
		}
		return sign.toString();
	}

}