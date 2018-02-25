package com.autobot.res.adc.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.autobot.res.adc.model.Template;
import com.autobot.res.adc.service.TemplateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * 文章模板
 * 
 * 
 * @author li_xiaodong
 *
 */
@RestController
@RequestMapping("template")
@Api(value = "文章模板", tags = "文章模板接口")
public class TemplateController {

	private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

	@Autowired
	private TemplateService templateService;

	@ApiOperation("新增文章模板")
	@PostMapping("")
	public Template create(@Valid @ApiParam("客源商机") @RequestBody Template template) {
		logger.info("TemplateController.create : template={}", template.toString());
		try {
			templateService.insert(template);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return template;
	}

}
