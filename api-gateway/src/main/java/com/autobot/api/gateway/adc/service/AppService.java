/**
 * @author: li_xiaodong  
 * @date: 2018年3月7日 上午11:21:09
 */
package com.autobot.api.gateway.adc.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.autobot.base.adc.bo.AppGateBO;
import com.autobot.base.adc.dto.AppGateQuery;
import com.autobot.base.support.Result;

/**
 * @Description: TODO
 * @author li_xiaodong
 * @date: 2018年3月7日 上午11:21:09 
 */
@FeignClient(name="autobot-res",fallback=AppFallbackService.class)
public interface AppService {
	
	@PostMapping("/app/query")
	Result<AppGateBO> query(@RequestBody AppGateQuery query);

}
