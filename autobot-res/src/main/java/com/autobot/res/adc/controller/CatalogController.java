package com.autobot.res.adc.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobot.res.adc.model.Catalog;
import com.autobot.res.adc.service.CatalogService;
import com.autobot.res.adc.vo.CatalogVO;
import com.autobot.res.base.support.Result;

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
@Api(value = "目录", tags = "目录")
public class CatalogController {

	private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);

	@Autowired
	private CatalogService catalogService;

	@ApiOperation("新增目录")
	@PostMapping("")
	public Result<Integer> create(@Valid @ApiParam("目录信息") @RequestBody CatalogVO catalogVO) {

		logger.info("CatalogController.create : template={}", catalogVO.toString());

		// 构建返回
		Result<Integer> result = new Result<Integer>();

		Catalog catalog = new Catalog();

		if (null != catalogVO) {

			BeanUtils.copyProperties(catalogVO, catalog);

			// catalogService.insert(template);
		}

		result.setData(catalog.getId());

		return result;

	}

}
