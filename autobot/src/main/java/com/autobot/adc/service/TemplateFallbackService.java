package com.autobot.adc.service;

import org.springframework.stereotype.Component;

import com.autobot.adc.bo.TemplateBO;
import com.autobot.adc.vo.TemplateVO;

/**
 * @author li_xiaodong
 *
 */
@Component
public class TemplateFallbackService implements TemplateService {

	@Override
	public String helloCustomer() {
		return "error";
	}

	@Override
	public TemplateBO create(TemplateVO templateVO) {
		return null;
	}

}
