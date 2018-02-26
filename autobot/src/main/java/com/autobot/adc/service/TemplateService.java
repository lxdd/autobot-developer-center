package com.autobot.adc.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.autobot.adc.bo.TemplateBO;
import com.autobot.adc.vo.TemplateVO;

/**
 * @author li_xiaodong
 *
 */
@FeignClient(name="autobot-res",fallback=TemplateFallbackService.class)
public interface TemplateService {
	
	@RequestMapping("/client/")
	String helloCustomer();
	
	@RequestMapping("/res/template")
	@PostMapping("")
	TemplateBO create(@RequestBody TemplateVO templateVO);

}
