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

import com.autobot.adc.bo.CatalogBO;
import com.autobot.adc.vo.CatalogVO;
import com.autobot.base.support.PageResult;
import com.autobot.base.support.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * 目录
 * 
 * 
 * @author li_xiaodong
 *
 */
@RestController
@RequestMapping("catalog")
@Api(value = "目录", tags = "目录接口")
public class CatalogController {

	private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);

	// @Autowired
	// TemplateService templateService;

	@ApiOperation("新增目录")
	@PostMapping("")
	public Result<Integer> create(@Valid @ApiParam("目录信息") @RequestBody CatalogVO catalogVO) {

		logger.info("CatalogController.create : catalogVO={}", catalogVO.toString());

		// 构建返回
		Result<Integer> result = new Result<Integer>();

		result.setData(1);

		return result;

	}

	@ApiOperation("修改目录")
	@PutMapping("/{id}")
	public Result<Object> update(
			@ApiParam(value = "目录id", required = true) @PathVariable(value = "id") Integer id,
			@ApiParam("目录信息") @RequestBody CatalogVO catalogVO) {
		logger.info("CatalogController.update : catalogVO={}", catalogVO.toString());

		// 构建返回
		Result<Object> result = new Result<>();

		return result;
	}

	@ApiOperation("删除目录")
	@DeleteMapping("/{id}")
	public Result<Object> delete(@ApiParam(value = "目录id", required = true) @PathVariable(value = "id") Integer id) {

		logger.info("CatalogController.delete : id={}", id);

		// 构建返回
		Result<Object> result = new Result<>();

		return result;

	}

	@ApiOperation("通过ID查询目录详情")
	@GetMapping("/{id}")
	public Result<CatalogBO> getById(@ApiParam(value = "id", required = true) @PathVariable("id") Integer id) {
		logger.info("CatalogController.getById : id={}", id);

		// 构建返回
		Result<CatalogBO> result = new Result<CatalogBO>();

		CatalogBO bo = new CatalogBO();
		result.setData(bo);

		return result;

	}

	@ApiOperation("目录搜索")
	@PostMapping("/search")
	public PageResult<List<CatalogBO>> getInquiryBySearch(@RequestBody CatalogVO catalogVo,
			@ApiParam(value = "每页显示条数", required = true) @RequestParam("current") Integer current,
			@ApiParam(value = "页号", required = true) @RequestParam("pageIndex") Integer pageIndex) {

		// 构建返回
		PageResult<List<CatalogBO>> result = new PageResult<List<CatalogBO>>();

		List<CatalogBO> boList = new ArrayList<>();
		CatalogBO bo = new CatalogBO();
		boList.add(bo);

		result.setData(boList);
		result.setPageSize(10);
		result.setCurrent(current);
		result.setTotalCount(1);

		return result;
	}

}
