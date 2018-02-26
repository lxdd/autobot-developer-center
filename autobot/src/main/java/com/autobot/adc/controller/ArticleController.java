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

import com.autobot.adc.bo.ArticleBO;
import com.autobot.adc.vo.ArticleVO;
import com.autobot.base.support.PageResult;
import com.autobot.base.support.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * 文档
 * 
 * 
 * @author li_xiaodong
 *
 */
@RestController
@RequestMapping("article")
@Api(value = "文档", tags = "文档接口")
public class ArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

	// @Autowired
	// TemplateService templateService;

	@ApiOperation("新增文档")
	@PostMapping("")
	public Result<Integer> create(@Valid @ApiParam("文档信息") @RequestBody ArticleVO articleVO) {

		logger.info("ArticleController.create : template={}", articleVO.toString());

		// 构建返回
		Result<Integer> result = new Result<Integer>();

		result.setData(1);

		return result;

	}

	@ApiOperation("修改文档")
	@PutMapping("/{articleId}")
	public Result<Object> update(
			@ApiParam(value = "文档模板id", required = true) @PathVariable(value = "articleId") Integer articleId,
			@ApiParam("文档信息") @RequestBody ArticleVO articleVO) {
		logger.info("ArticleController.update : articleVO={}", articleVO.toString());

		// 构建返回
		Result<Object> result = new Result<>();

		return result;
	}

	@ApiOperation("删除文档")
	@DeleteMapping("/{articleId}")
	public Result<Object> delete(
			@ApiParam(value = "文档模板id", required = true) @PathVariable(value = "articleId") Integer articleId) {

		logger.info("ArticleController.delete : articleId={}", articleId);

		// 构建返回
		Result<Object> result = new Result<>();

		return result;

	}

	@ApiOperation("通过ID查询文档详情")
	@GetMapping("/{articleId}")
	public Result<ArticleBO> getById(
			@ApiParam(value = "articleId", required = true) @PathVariable("articleId") Integer articleId) {
		logger.info("ArticleController.getById : articleId={}", articleId);

		// 构建返回
		Result<ArticleBO> result = new Result<ArticleBO>();

		ArticleBO bo = new ArticleBO();
		result.setData(bo);

		return result;

	}

	@ApiOperation("文档搜索")
	@PostMapping("/search")
	public PageResult<List<ArticleBO>> getInquiryBySearch(@RequestBody ArticleVO ArticleVo,
			@ApiParam(value = "每页显示条数", required = true) @RequestParam("current") Integer current,
			@ApiParam(value = "页号", required = true) @RequestParam("pageIndex") Integer pageIndex) {

		// 构建返回
		PageResult<List<ArticleBO>> result = new PageResult<List<ArticleBO>>();

		List<ArticleBO> boList = new ArrayList<>();
		ArticleBO bo = new ArticleBO();
		boList.add(bo);

		result.setData(boList);
		result.setPageSize(10);
		result.setCurrent(current);
		result.setTotalCount(1);

		return result;
	}

}
