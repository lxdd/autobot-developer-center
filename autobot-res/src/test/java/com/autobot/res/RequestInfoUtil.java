/**
 * @author: li_xiaodong  
 * @date: 2018年3月2日 下午5:34:10
 */
package com.autobot.res;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @author li_xiaodong
 * @date: 2018年3月2日 下午5:34:10 
 */
public class RequestInfoUtil {
	
	 public static Map<String, String> getBodyInfo(String request)
	    {
	        Map<String, String> map = new HashMap<String, String>();
	        bodyInfoProcessing(map, request);
	        return map;
	    }

	    private static String bodyInfoProcessing(Map<String, String> map, String s)
	    {
	        int length = s.length();
	        int index1 = s.indexOf("=");
	        String parm1 = s.substring(0, index1);
	        int index2 = s.indexOf("&");
	        if (index2 == -1)
	        {
	            String parm2 = s.substring(index1 + 1);
	            map.put(parm1, parm2);
	            return null;
	        }
	        String parm2 = s.substring(index1 + 1, index2);
	        map.put(parm1, parm2);
	        return bodyInfoProcessing(map, s.substring(index2 + 1));
	    }

}
