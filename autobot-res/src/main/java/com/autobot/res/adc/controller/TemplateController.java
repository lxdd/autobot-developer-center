package com.autobot.res.adc.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@ApiOperation("新增文档模板")
	@PostMapping("")
	public Template create(@Valid @ApiParam("文档") @RequestBody Template template) {
		
		logger.info("TemplateController.create : template={}", template.toString());
		templateService.insert(template);

		return template;
	}

	@ApiOperation("通过ID查询信息")
	@GetMapping("/{id}")
	public Template getById(@ApiParam(value = "id", required = true) @PathVariable("id") Integer id) {
		logger.info("InquiryController.getById : id={}", id);

		return templateService.getById(id);
	}

}
