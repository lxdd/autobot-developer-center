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
import com.autobot.res.adc.bo.TemplateBO;
import com.autobot.res.adc.common.convert.ListToList;
import com.autobot.res.adc.model.Template;
import com.autobot.res.adc.service.TemplateService;
import com.autobot.res.adc.vo.TemplateQuery;
import com.autobot.res.adc.vo.TemplateVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * 模板
 * 
 * 
 * @author li_xiaodong
 *
 */
@RestController
@RequestMapping("res/template")
@Api(value = "模板", tags = "模板接口")
public class TemplateController {

	private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

	@Autowired
	private TemplateService templateService;

	@ApiOperation("新增文档模板")
	@PostMapping("")
	public Result<Integer> create(@Valid @ApiParam("文档模板信息") @RequestBody TemplateVO templateVO) {

		logger.info("TemplateController.create : template={}", templateVO.toString());

		// 构建返回
		Result<Integer> result = new Result<Integer>();

		Template template = new Template();

		if (null != templateVO) {

			BeanUtils.copyProperties(templateVO, template);

			templateService.insert(template);
		}

		result.setData(template.getId());

		return result;

	}

	/**
	 * @Description: update @param @param id @param @param templateVO @param @return
	 * 设定文件 @return Result<Object> 返回类型 @throws
	 */
	@ApiOperation("修改文档模板")
	@PutMapping("/{id}")
	public Result<Object> update(@ApiParam(value = "文档模板id", required = true) @PathVariable(value = "id") Integer id,
			@ApiParam("文档模板信息") @RequestBody TemplateVO templateVO) {

		logger.info("TemplateController.update : template={}", templateVO.toString());

		// 构建返回
		Result<Object> result = new Result<>();

		Template template = new Template();

		if (null != id && null != templateVO) {

			templateVO.setNameCreate(null);
			BeanUtils.copyProperties(templateVO, template);
			template.setId(id);

			templateService.update(template);
		}

		return result;

	}

	@ApiOperation("删除文档模板")
	@DeleteMapping("/{id}")
	public Result<Object> delete(@ApiParam(value = "文档模板id", required = true) @PathVariable(value = "id") Integer id) {

		logger.info("TemplateController.delete : id={}", id);

		// 构建返回
		Result<Object> result = new Result<>();

		if (null != id) {
			templateService.delete(id);
		}

		return result;

	}

	@ApiOperation("通过ID查询文档模板详情")
	@GetMapping("/{id}")
	public Result<TemplateBO> getById(@ApiParam(value = "id", required = true) @PathVariable("id") Integer id) {
		logger.info("InquiryController.getById : id={}", id);

		// 构建返回
		Result<TemplateBO> result = new Result<TemplateBO>();

		TemplateBO bo = new TemplateBO();

		if (null != id) {
			Template template = templateService.getById(id);
			if (null != template) {
				BeanUtils.copyProperties(template, bo);
			}
		}

		result.setData(bo);

		return result;

	}

	@ApiOperation("文档模板搜索")
	@PostMapping("/search")
	public PageResult<List<TemplateBO>> search(@RequestBody TemplateQuery query,
			@ApiParam(value = "每页显示条数", required = true) @RequestParam("pageSize") Integer pageSize,
			@ApiParam(value = "页号", required = true) @RequestParam("current") Integer current) {

		// 构建返回
		PageResult<List<TemplateBO>> result = new PageResult<List<TemplateBO>>();

		// 构建返回对象list
		List<TemplateBO> boList = new ArrayList<>();

		int count = templateService.count(query);
		if (count > 0) {

			PageUtil pageUtil = new PageUtil(current, pageSize);

			List<Template> templateList = templateService.listTemplate(query, pageUtil.getOffset(),
					pageUtil.getPageSize());

			boList = ListToList.convertTemplateList(templateList);
		}

		result.setData(boList);
		result.setPageSize(pageSize);
		result.setCurrent(current);
		result.setTotalCount(count);

		return result;
	}

}
