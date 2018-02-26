package com.autobot.adc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autobot.adc.bo.TemplateBO;
import com.autobot.adc.vo.TemplateVO;
import com.autobot.base.support.PageResult;
import com.autobot.base.support.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * 文档模板
 * 
 * 
 * @author li_xiaodong
 *
 */
@RestController
@RequestMapping("template")
@Api(value = "文档模板", tags = "文档模板接口")
public class TemplateController {

	private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

	// @Autowired
	// TemplateService templateService;

	@ApiOperation("新增文档模板")
	@PostMapping("")
	public Result<Integer> create(@Valid @ApiParam("文档模板信息") @RequestBody TemplateVO template) {

		logger.info("TemplateController.create : template={}", template.toString());

		// 构建返回
		Result<Integer> result = new Result<Integer>();

		result.setData(1);

		return result;

	}

	@ApiOperation("修改文档模板")
	@PutMapping("/{id}")
	public Result<Object> update(@ApiParam(value = "文档模板id", required = true) @PathVariable(value = "id") Integer id,
			@ApiParam("文档模板信息") @RequestBody TemplateVO template) {
		logger.info("TemplateController.update : template={}", template.toString());

		// 构建返回
		Result<Object> result = new Result<>();

		return result;
	}

	@ApiOperation("删除文档模板")
	@DeleteMapping("/{id}")
	public Result<Object> delete(@ApiParam(value = "文档模板id", required = true) @PathVariable(value = "id") Long id) {

		logger.info("TemplateController.delete : id={}", id);

		// 构建返回
		Result<Object> result = new Result<>();

		return result;

	}

	@ApiOperation("通过ID查询文档模板详情")
	@GetMapping("/{id}")
	public Result<TemplateBO> getById(@ApiParam(value = "id", required = true) @PathVariable("id") Integer id) {
		logger.info("InquiryController.getById : id={}", id);

		// 构建返回
		Result<TemplateBO> result = new Result<TemplateBO>();

		TemplateBO bo = new TemplateBO();
		result.setData(bo);

		return result;

	}

	@ApiOperation("文档模板搜索")
	@PostMapping("/search")
	public PageResult<List<TemplateBO>> getInquiryBySearch(@RequestBody TemplateVO TemplateVo,
			@ApiParam(value = "每页显示条数", required = true) @RequestParam("current") Integer current,
			@ApiParam(value = "页号", required = true) @RequestParam("pageIndex") Integer pageIndex) {

		// 构建返回
		PageResult<List<TemplateBO>> result = new PageResult<List<TemplateBO>>();

		List<TemplateBO> boList = new ArrayList<>();
		TemplateBO bo = new TemplateBO();
		boList.add(bo);

		result.setData(boList);
		result.setPageSize(10);
		result.setCurrent(current);
		result.setTotalCount(1);

		return result;
	}

}
