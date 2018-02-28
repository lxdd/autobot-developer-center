package com.autobot.res.adc.controller;

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

import com.autobot.res.adc.bo.CatalogBO;
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

	@ApiOperation("修改目录")
	@PutMapping("/{id}")
	public Result<Object> update(@ApiParam(value = "目录id", required = true) @PathVariable(value = "id") Integer id,
			@ApiParam("目录信息") @RequestBody CatalogVO catalogVO) {

		logger.info("CatalogController.update : catalogVO={}", catalogVO.toString());

		// 构建返回
		Result<Object> result = new Result<>();

		Catalog catalog = new Catalog();

		if (null != id && null != catalogVO) {

			catalogVO.setNameCreate(null);
			BeanUtils.copyProperties(catalogVO, catalog);
			catalog.setId(id);

			catalogService.update(catalog);
		}

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

	@ApiOperation("通过ID查询目录详情")
	@GetMapping("/{id}")
	public Result<CatalogBO> getById(@ApiParam(value = "id", required = true) @PathVariable("id") Integer id) {
		logger.info("InquiryController.getById : id={}", id);

		// 构建返回
		Result<CatalogBO> result = new Result<CatalogBO>();

		CatalogBO bo = new CatalogBO();

		if (null != id) {
			Catalog catalog = catalogService.getById(id);
			if (null != catalog) {
				BeanUtils.copyProperties(catalog, bo);
			}
		}

		result.setData(bo);

		return result;

	}

}
