package com.autobot.adc.service;

import org.springframework.stereotype.Component;

/**
 * @author li_xiaodong
 *
 */
@Component
public class ClientFallbackService implements ClientService {

	@Override
	public String helloCustomer() {
		return "error";
	}

}
