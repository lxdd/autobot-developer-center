package com.autobot.res.adc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * 应用方
 * 
 * @RefreshScope开启更新机制 需要给加载变量的类上面加载@RefreshScope，在客户端执行/refresh的时候就会更新此类下面的变量值
 * 
 * @author li_xiaodong
 *
 */
@RestController
@RequestMapping("client")
@Api(value = "应用方类", tags = "应用方接口")
@RefreshScope
public class AppClientController {

	@Value("${from}")
	private String from;

	@Value("${to}")
	private String to;

	// @ApiOperation(value = "获取helloWorld", notes = "简单SpringMVC请求")
	@ApiOperation("测试接口")
	@GetMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	String home() {
		return "HELLO WORLD" + this.from + ";to= " + this.to;
	}

	@ApiOperation(value = "获取应用方详细信息", notes = "根据appCode获取应用方详细信息")
	@ApiImplicitParam(name = "appCode", value = "应用方编号Code", required = true, dataType = "String", paramType = "path")
	@GetMapping(value = "/{appCode}")
	public String getAppInfoByAppCode(@PathVariable String appCode) {

		return "Hello World";

	}

}
