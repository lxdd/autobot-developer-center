package com.autobot.res.adc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autobot.res.adc.bo.ArticleBO;
import com.autobot.res.adc.bo.ServeBO;
import com.autobot.res.adc.bo.TemplateBO;
import com.autobot.res.adc.model.Serve;
import com.autobot.res.adc.service.ServeService;
import com.autobot.res.adc.vo.ServeVO;
import com.autobot.res.base.support.PageResult;
import com.autobot.res.base.support.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * 服务方
 * 
 * 
 * @author li_xiaodong
 *
 */
@RestController
@RequestMapping("res/serve")
@Api(value = "服务方", tags = "服务方接口")
public class ServeController {

	private static final Logger logger = LoggerFactory.getLogger(ServeController.class);

	@Autowired
	private ServeService serveService;

	@ApiOperation("新增服务方")
	@PostMapping("")
	public Result<Integer> create(@Valid @ApiParam("服务方信息") @RequestBody ServeVO serveVO) {

		logger.info("ServeController.create : template={}", serveVO.toString());

		// 构建返回
		Result<Integer> result = new Result<Integer>();

		result.setData(1);

		return result;

	}

	@ApiOperation("修改服务方")
	@PutMapping("/{serveId}")
	public Result<Object> update(
			@ApiParam(value = "服务方id", required = true) @PathVariable(value = "serveId") Integer serveId,
			@ApiParam("文档信息") @RequestBody ServeVO serveVO) {
		logger.info("ServeController.update : serveVO={}", serveVO.toString());

		// 构建返回
		Result<Object> result = new Result<>();

		return result;
	}

	@ApiOperation("删除服务方")
	@DeleteMapping("/{serveId}")
	public Result<Object> delete(
			@ApiParam(value = "服务方id", required = true) @PathVariable(value = "serveId") Integer serveId) {

		logger.info("ServeController.delete : serveId={}", serveId);

		// 构建返回
		Result<Object> result = new Result<>();

		return result;

	}

	@ApiOperation("通过ID查询服务方详情")
	@GetMapping("/{serveId}")
	public Result<ServeBO> getById(
			@ApiParam(value = "serveId", required = true) @PathVariable("serveId") Integer serveId) {
		logger.info("ServeController.getById : serveId={}", serveId);

		// 构建返回
		Result<ServeBO> result = new Result<ServeBO>();

		ServeBO bo = new ServeBO();

		if (null != serveId) {
			Serve serve = serveService.getById(serveId);
			if (null != serve) {
				BeanUtils.copyProperties(serve, bo);
			}
		}

		result.setData(bo);

		return result;

	}

	@ApiOperation("服务方搜索")
	@PostMapping("/search")
	public PageResult<List<ServeBO>> getInquiryBySearch(@RequestBody ServeVO serveVo,
			@ApiParam(value = "每页显示条数", required = true) @RequestParam("current") Integer current,
			@ApiParam(value = "页号", required = true) @RequestParam("pageIndex") Integer pageIndex) {

		// 构建返回
		PageResult<List<ServeBO>> result = new PageResult<List<ServeBO>>();

		List<ServeBO> boList = new ArrayList<>();
		ServeBO bo = new ServeBO();
		boList.add(bo);

		result.setData(boList);
		result.setPageSize(10);
		result.setCurrent(current);
		result.setTotalCount(1);

		return result;
	}

}
