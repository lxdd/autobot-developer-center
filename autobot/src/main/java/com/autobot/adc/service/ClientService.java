package com.autobot.adc.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author li_xiaodong
 *
 */
@FeignClient(name="autobot-res",fallback=ClientFallbackService.class)
public interface ClientService {
	
	@RequestMapping("/customer/hello")
	String helloCustomer();

}
