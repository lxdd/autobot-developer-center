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
import com.autobot.res.adc.bo.ArticleBO;
import com.autobot.res.adc.bo.ServeBO;
import com.autobot.res.adc.common.convert.ListToList;
import com.autobot.res.adc.model.Article;
import com.autobot.res.adc.model.Serve;
import com.autobot.res.adc.model.ServeArticle;
import com.autobot.res.adc.service.ArticleService;
import com.autobot.res.adc.service.ServeService;
import com.autobot.res.adc.vo.ArticleQuery;
import com.autobot.res.adc.vo.ArticleVO;

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

	@Autowired
	private ServeService serveService;

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

			// 批量插入服务文章关系表
			bathInsertArticleServe(articleVO, article.getArticleId());

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

			// 变更文章服务关系表
			// 1、先删除文章服务关系表
			articleService.deleteArticleServeMapping(articleId);
			// 2、重建文章服务关系
			// 批量插入服务文章关系表
			bathInsertArticleServe(articleVO, article.getArticleId());

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

		if (null != articleId) {
			Article article = articleService.getById(articleId);
			if (null != article) {
				BeanUtils.copyProperties(article, bo);

				// 根据文章ID获取所属服务信息
				List<Serve> moList = serveService.getServeListByArticleId(articleId);
				List<ServeBO> serveList = ListToList.convertServeList(moList);
				bo.setServeList(serveList);
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

			// TODO 此处待优化  处理文章所属服务
			for (ArticleBO articleBO : boList) {

				List<Serve> serveList = serveService.getServeListByArticleId(articleBO.getArticleId());
				List<ServeBO> serveBOList = ListToList.convertServeList(serveList);
				articleBO.setServeList(serveBOList);
			}

		}

		result.setData(boList);
		result.setPageSize(pageSize);
		result.setCurrent(current);
		result.setTotalCount(count);

		return result;
	}

	/**
	 * @Description: 批量新增文档服务关系 @param articleVO @param articleId @throws
	 */
	private void bathInsertArticleServe(ArticleVO articleVO, Integer articleId) {
		List<Integer> serveIdList = articleVO.getServeIdList();
		if (null != serveIdList && !serveIdList.isEmpty()) {
			List<ServeArticle> serveArticleList = new ArrayList<>();
			ServeArticle serveArticle = null;
			for (Integer serveId : serveIdList) {

				serveArticle = new ServeArticle();
				serveArticle.setArticleId(articleId);
				serveArticle.setServeId(serveId);
				serveArticleList.add(serveArticle);
			}

			articleService.bathInsertArticleServeMapping(serveArticleList);
		}
	}

}
