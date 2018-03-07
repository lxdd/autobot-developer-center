/**
 * @author: li_xiaodong  
 * @date: 2018年3月7日 上午11:21:09
 */
package com.autobot.api.gateway.adc.service;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @Description: TODO
 * @author li_xiaodong
 * @date: 2018年3月7日 上午11:21:09 
 */
@FeignClient(name="autobot-res",fallback=AppFallbackService.class)
public interface AppService {
	
//	@PostMapping("/app/query")
//	Result<AppBO> query(@RequestBody AppQuery query);

}
