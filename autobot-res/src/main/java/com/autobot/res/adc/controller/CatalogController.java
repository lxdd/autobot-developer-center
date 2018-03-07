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
import org.springframework.web.bind.annotation.RestController;

import com.autobot.base.support.Result;
import com.autobot.res.adc.bo.CatalogBO;
import com.autobot.res.adc.common.convert.ListToList;
import com.autobot.res.adc.common.util.MenuTreeUtil;
import com.autobot.res.adc.model.Catalog;
import com.autobot.res.adc.service.CatalogService;
import com.autobot.res.adc.vo.CatalogQuery;
import com.autobot.res.adc.vo.CatalogVO;

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
@RequestMapping("res/catalog")
@Api(value = "目录", tags = "目录接口")
public class CatalogController {

	private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);

	@Autowired
	private CatalogService catalogService;

	@ApiOperation("新增目录")
	@PostMapping("")
	public Result<Integer> create(@Valid @ApiParam("目录信息") @RequestBody CatalogVO catalogVO) {

		logger.info("CatalogController.create : catalogVO={}", catalogVO.toString());

		// 构建返回
		Result<Integer> result = new Result<Integer>();

		Catalog catalog = new Catalog();

		if (null != catalogVO) {

			BeanUtils.copyProperties(catalogVO, catalog);

			catalogService.insert(catalog);
		}

		result.setData(catalog.getId());

		return result;

	}

	@ApiOperation("删除目录")
	@DeleteMapping("/{id}")
	public Result<Object> delete(@ApiParam(value = "目录id", required = true) @PathVariable(value = "id") Integer id) {

		logger.info("CatalogController.delete : id={}", id);

		// 构建返回
		Result<Object> result = new Result<>();

		if (null != id) {
			catalogService.delete(id);
		}

		return result;

	}

	@ApiOperation("目录列表")
	@GetMapping("/list")
	public Result<List<Object>> listCatalog() {

		logger.info("InquiryController.listCatalog");

		// 构建返回
		Result<List<Object>> result = new Result<>();

		// 构建返回对象list
		List<CatalogBO> boList = new ArrayList<>();

		// 获取目录list
		List<Catalog> listCatalog = catalogService.listCatalog(new CatalogQuery());
		if (null != listCatalog && !listCatalog.isEmpty()) {

			boList = ListToList.convertCatalogList(listCatalog);

			MenuTreeUtil menuTree = new MenuTreeUtil();
			
			result.setData(menuTree.toMenuList(boList));

		}

		return result;

	}

	@ApiOperation("修改服务方目录")
	@PutMapping("/{serveId}")
	public Result<Object> updateByServeId(
			@ApiParam(value = "服务方id", required = true) @PathVariable(value = "serveId") Integer serveId,
			@ApiParam("目录信息") @RequestBody String jsonStr) {

		logger.info("CatalogController.updateByServeId : jsonStr={}", jsonStr);

		// 构建返回
		Result<Object> result = new Result<>();

		Catalog catalog = new Catalog();

		// TODO 1.删除该服务方的所有目录； 2、新建该服务方目录（反向解析Tree型数据结构，转为list；批量创建目录）
		
		//1.删除该服务方的所有目录
		
		//2、反向解析Tree型数据结构，转为list
		MenuTreeUtil menuTree = new MenuTreeUtil();
		List<CatalogBO> boList = menuTree.menuToList(jsonStr);
		
		//3、批量创建改服务方目录
		

		return result;

	}

}
