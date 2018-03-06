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
import com.autobot.res.adc.common.convert.ListToList;
import com.autobot.res.adc.model.Article;
import com.autobot.res.adc.service.ArticleService;
import com.autobot.res.adc.vo.ArticleQuery;
import com.autobot.res.adc.vo.ArticleVO;
import com.autobot.res.base.support.PageResult;
import com.autobot.res.base.support.Result;
import com.autobot.res.base.util.PageUtil;

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
@RequestMapping("res/article")
@Api(value = "文档", tags = "文档接口")
public class ArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	private ArticleService articleService;

	@ApiOperation("新增文档")
	@PostMapping("")
	public Result<Integer> create(@Valid @ApiParam("文档信息") @RequestBody ArticleVO articleVO) {

		logger.info("ArticleController.create : article={}", articleVO.toString());

		// 构建返回
		Result<Integer> result = new Result<Integer>();

		Article article = new Article();

		if (null != articleVO) {

			BeanUtils.copyProperties(articleVO, article);

			articleService.insert(article);
			
			
			articleVO.getServeIdList();
			
		}

		result.setData(article.getArticleId());

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

		Article article = new Article();

		if (null != articleId && null != articleVO) {

			articleVO.setNameCreate(null);

			BeanUtils.copyProperties(articleVO, article);

			article.setArticleId(articleId);

			articleService.update(article);
		}

		return result;

	}

	@ApiOperation("删除文档")
	@DeleteMapping("/{articleId}")
	public Result<Object> delete(
			@ApiParam(value = "文档id", required = true) @PathVariable(value = "articleId") Integer articleId) {

		logger.info("ArticleController.delete : articleId={}", articleId);

		// 构建返回
		Result<Object> result = new Result<>();

		if (null != articleId) {
			articleService.delete(articleId);
		}

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
		
		List<ServeBO> serveList = new ArrayList<>();
		serveList.add(new ServeBO());
		bo.setServeList(serveList);

		if (null != articleId) {
			Article article = articleService.getById(articleId);
			if (null != article) {
				BeanUtils.copyProperties(article, bo);
			}
		}

		result.setData(bo);

		return result;

	}

	@ApiOperation("文档搜索")
	@PostMapping("/search")
	public PageResult<List<ArticleBO>> search(@RequestBody ArticleQuery query,
			@ApiParam(value = "每页显示条数", required = true) @RequestParam("pageSize") Integer pageSize,
			@ApiParam(value = "页号", required = true) @RequestParam("current") Integer current) {

		// 构建返回
		PageResult<List<ArticleBO>> result = new PageResult<List<ArticleBO>>();

		// 构建返回对象list
		List<ArticleBO> boList = new ArrayList<>();

		int count = articleService.count(query);
		if (count > 0) {

			PageUtil pageUtil = new PageUtil(current, pageSize);

			List<Article> articleList = articleService.listArticle(query, pageUtil.getOffset(), pageUtil.getPageSize());

			boList = ListToList.convertArticleList(articleList);
		}

		result.setData(boList);
		result.setPageSize(pageSize);
		result.setCurrent(current);
		result.setTotalCount(count);

		return result;
	}

}
