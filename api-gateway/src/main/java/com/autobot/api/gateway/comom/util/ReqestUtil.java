/**
 * @author: li_xiaodong  
 * @date: 2018年3月2日 上午11:44:22
 */
package com.autobot.api.gateway.comom.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;

/**
 * @Description: HttpServletRequest帮助类
 * @author li_xiaodong
 * @date: 2018年3月2日 上午11:44:22
 */
public class ReqestUtil {

	/**
	 * @Description: get request headersInfo @param request @return
	 *               Map<String,String> @throws
	 */
	public static Map<String, String> getHeadersInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<?> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}

	/**
	 * @Description: get request headersInfo @param request @return
	 *               Map<String,String> @throws
	 */
	public static Map<String, Object> getParamsInfo(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		// Enumeration<?> headerNames = request.getHeaderNames();
		// while (headerNames.hasMoreElements()) {
		// String key = (String) headerNames.nextElement();
		// String value = request.getHeader(key);
		// map.put(key, value);
		// }

		Enumeration<?> pNames = request.getParameterNames();
		while (pNames.hasMoreElements()) {
			String pName = (String) pNames.nextElement();
			if ("sign".equals(pName)) {
				continue;
			}

			Object pValue = request.getParameter(pName);
			map.put(pName, pValue);
		}

		return map;
	}

	public static Map<String, Object> getBodyInfo(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();

		InputStream is = null;
		String contentStr = "";
		try {
			is = request.getInputStream();
			contentStr = IOUtils.toString(is, "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

//		map = getBodyInfo(contentStr);
		String strr = null;
		try {
			strr = URLDecoder.decode(contentStr, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map = JsonUtil.parseToObject(strr, Map.class);

		return map;
	}

	private static Map<String, Object> getBodyInfo(String bodyInfo) {
		Map<String, Object> map = new HashMap<>();
		bodyInfoProcessing(map, bodyInfo);
		return map;
	}

	private static String bodyInfoProcessing(Map<String, Object> map, String bodyInfo) {
		int length = bodyInfo.length();
		int index1 = bodyInfo.indexOf("=");
		String parm1 = bodyInfo.substring(0, index1);
		int index2 = bodyInfo.indexOf("&");
		if (index2 == -1) {
			String parm2 = bodyInfo.substring(index1 + 1);
			map.put(parm1, parm2);
			return null;
		}
		String parm2 = bodyInfo.substring(index1 + 1, index2);
		map.put(parm1, parm2);
		return bodyInfoProcessing(map, bodyInfo.substring(index2 + 1));
	}

}
