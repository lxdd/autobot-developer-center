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

import com.autobot.base.adc.bo.AppGateBO;
import com.autobot.base.adc.dto.AppGateQuery;
import com.autobot.base.support.PageResult;
import com.autobot.base.support.Result;
import com.autobot.base.util.PageUtil;
import com.autobot.res.adc.bo.AppBO;
import com.autobot.res.adc.common.convert.ListToList;
import com.autobot.res.adc.model.App;
import com.autobot.res.adc.service.AppService;
import com.autobot.res.adc.vo.AppQuery;
import com.autobot.res.adc.vo.AppVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
public class AppController {

	private static final Logger logger = LoggerFactory.getLogger(AppController.class);

	@Autowired
	private AppService appService;

	@ApiOperation("新增应用方")
	@PostMapping("")
	public Result<Integer> create(@Valid @ApiParam("应用方信息") @RequestBody AppVO appVO) {

		logger.info("AppController.create : appVO={}", appVO.toString());

		// 构建返回
		Result<Integer> result = new Result<Integer>();

		App app = new App();

		if (null != appVO) {

			BeanUtils.copyProperties(appVO, app);

			appService.insert(app);
		}

		result.setData(app.getAppId());

		return result;

	}

	@ApiOperation("修改应用方")
	@PutMapping("/{appId}")
	public Result<Object> update(
			@ApiParam(value = "应用方id", required = true) @PathVariable(value = "appId") Integer appId,
			@ApiParam("应用方信息") @RequestBody AppVO appVO) {

		logger.info("AppController.update : appVO={}", appVO.toString());

		// 构建返回
		Result<Object> result = new Result<>();

		App app = new App();

		if (null != appId && null != appVO) {

			appVO.setNameCreate(null);

			BeanUtils.copyProperties(appVO, app);

			app.setAppId(appId);

			appService.update(app);
		}

		return result;
	}

	@ApiOperation("删除应用方")
	@DeleteMapping("/{appId}")
	public Result<Object> delete(
			@ApiParam(value = "应用方id", required = true) @PathVariable(value = "appId") Integer appId) {

		logger.info("AppController.delete : appId={}", appId);

		// 构建返回
		Result<Object> result = new Result<>();

		if (null != appId) {
			appService.delete(appId);
		}

		return result;

	}

	@ApiOperation("通过ID查询应用方详情")
	@GetMapping("/{appId}")
	public Result<AppBO> getById(@ApiParam(value = "appId", required = true) @PathVariable("appId") Integer appId) {
		logger.info("AppController.getById : appId={}", appId);

		// 构建返回
		Result<AppBO> result = new Result<AppBO>();

		AppBO bo = new AppBO();

		if (null != appId) {
			App app = appService.getById(appId);
			if (null != app) {
				BeanUtils.copyProperties(app, bo);
			}
		}

		result.setData(bo);

		return result;

	}

	@ApiOperation("应用方搜索")
	@PostMapping("/search")
	public PageResult<List<AppBO>> search(@RequestBody AppQuery query,
			@ApiParam(value = "每页显示条数", required = true) @RequestParam("pageSize") Integer pageSize,
			@ApiParam(value = "页号", required = true) @RequestParam("current") Integer current) {

		// 构建返回
		PageResult<List<AppBO>> result = new PageResult<List<AppBO>>();

		// 构建返回对象list
		List<AppBO> boList = new ArrayList<>();

		int count = appService.count(query);
		if (count > 0) {

			PageUtil pageUtil = new PageUtil(current, pageSize);

			List<App> serveList = appService.listApp(query, pageUtil.getOffset(), pageUtil.getPageSize());

			boList = ListToList.convertAppList(serveList);
		}

		result.setData(boList);
		result.setPageSize(pageSize);
		result.setCurrent(current);
		result.setTotalCount(count);

		return result;
	}
	
	@ApiOperation("查询使用方详情")
	@PostMapping("/query")
	public Result<AppGateBO> query(@RequestBody AppGateQuery query) {
		logger.info("AppController.query : query={}", query);

		// 构建返回
		Result<AppGateBO> result = new Result<>();

		AppGateBO bo = new AppGateBO();

		if (null != query) {
			App app = appService.query(query);
			if (null != app) {
				BeanUtils.copyProperties(app, bo);
			}
		}

		result.setData(bo);

		return result;

	}

}
