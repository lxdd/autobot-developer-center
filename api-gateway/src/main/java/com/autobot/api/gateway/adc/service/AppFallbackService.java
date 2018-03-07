/**
 * @author: li_xiaodong  
 * @date: 2018年3月7日 上午11:21:43
 */
package com.autobot.api.gateway.adc.service;

import com.autobot.base.adc.bo.AppGateBO;
import com.autobot.base.adc.dto.AppGateQuery;
import com.autobot.base.support.Result;

/**
 * @Description: TODO
 * @author li_xiaodong
 * @date: 2018年3月7日 上午11:21:43 
 */
public class AppFallbackService implements AppService {

	/* (non Javadoc) 
	 * @Description: TODO
	 * @param query
	 * @return 
	 * @see com.autobot.api.gateway.adc.service.AppService#query(com.autobot.api.gateway.adc.vo.AppQuery) 
	 */ 
	@Override
	public Result<AppGateBO> query(AppGateQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

}
