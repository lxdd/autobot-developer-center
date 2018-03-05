package com.autobot.adc.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 声明式服务调用
 * 
 * @author li_xiaodong
 *
 */

@FeignClient(name="autobot-res",fallback=ClientFallbackService.class)
public interface ClientService {
	
	@RequestMapping("/app/1")
	String helloCustomer();

}
