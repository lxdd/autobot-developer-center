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

import com.autobot.base.support.PageResult;
import com.autobot.base.support.Result;
import com.autobot.base.util.PageUtil;
import com.autobot.res.adc.bo.ServeBO;
import com.autobot.res.adc.common.convert.ListToList;
import com.autobot.res.adc.model.Serve;
import com.autobot.res.adc.service.ServeService;
import com.autobot.res.adc.vo.ServeQuery;
import com.autobot.res.adc.vo.ServeVO;

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

		Serve serve = new Serve();

		if (null != serveVO) {

			BeanUtils.copyProperties(serveVO, serve);

			serveService.insert(serve);
		}

		result.setData(serve.getServeId());

		return result;

	}

	@ApiOperation("修改服务方")
	@PutMapping("/{serveId}")
	public Result<Object> update(
			@ApiParam(value = "服务方id", required = true) @PathVariable(value = "serveId") Integer serveId,
			@ApiParam("服务方信息") @RequestBody ServeVO serveVO) {

		logger.info("ServeController.update : serveVO={}", serveVO.toString());

		// 构建返回
		Result<Object> result = new Result<>();

		Serve serve = new Serve();

		if (null != serveId && null != serveVO) {

			serveVO.setNameCreate(null);

			BeanUtils.copyProperties(serveVO, serve);

			serve.setServeId(serveId);

			serveService.update(serve);
		}

		return result;
	}

	@ApiOperation("删除服务方")
	@DeleteMapping("/{serveId}")
	public Result<Object> delete(
			@ApiParam(value = "服务方id", required = true) @PathVariable(value = "serveId") Integer serveId) {

		logger.info("ServeController.delete : serveId={}", serveId);

		// 构建返回
		Result<Object> result = new Result<>();

		if (null != serveId) {
			serveService.delete(serveId);
		}

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
	public PageResult<List<ServeBO>> search(@RequestBody ServeQuery query,
			@ApiParam(value = "每页显示条数", required = true) @RequestParam("pageSize") Integer pageSize,
			@ApiParam(value = "页号", required = true) @RequestParam("current") Integer current) {

		// 构建返回
		PageResult<List<ServeBO>> result = new PageResult<List<ServeBO>>();

		// 构建返回对象list
		List<ServeBO> boList = new ArrayList<>();

		int count = serveService.count(query);
		if (count > 0) {

			PageUtil pageUtil = new PageUtil(current, pageSize);
			List<Serve> serveList = serveService.listServe(query, pageUtil.getOffset(), pageUtil.getPageSize());

			boList = ListToList.convertServeList(serveList);
		}

		result.setData(boList);
		result.setPageSize(pageSize);
		result.setCurrent(current);
		result.setTotalCount(count);

		return result;
	}

}
