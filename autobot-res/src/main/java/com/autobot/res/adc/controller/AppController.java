package com.autobot.res.adc.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

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
@RequestMapping("app")
@Api(value = "应用方类", tags = "应用方接口")
@RefreshScope
public class AppController {

	

}
