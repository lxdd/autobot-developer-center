package com.autobot.res.adc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.autobot.res.adc.dao.ArticleMapper;
import com.autobot.res.adc.dao.ServeArticleMapper;
import com.autobot.res.adc.model.Article;
import com.autobot.res.adc.model.ServeArticle;
import com.autobot.res.adc.vo.ArticleQuery;

/**
 * 
 * @author li_xiaodong
 *
 */
@Service("articleService")
public class ArticleService {

	@Resource
	private ArticleMapper articleMapper;
	
	@Resource
	private ServeArticleMapper serveArticleMapper;

	/**
	 * 查看
	 * 
	 * @param id
	 * @return
	 */

	public Article getById(int id) {
		Article article = articleMapper.selectByPrimaryKey(id);
		return article;
	}

	/**
	 * 创建
	 * 
	 * @param param
	 * @return
	 */

	public int insert(Article article) {
		int count = articleMapper.insertSelective(article);
		return count;
	}

	/**
	 * 更新
	 * 
	 * @param param
	 * @return
	 */

	public int update(Article article) {
		int count = articleMapper.updateByPrimaryKeySelective(article);
		return count;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */

	public int delete(int id) {
		int count = articleMapper.deleteById(id);
		return count;
	}

	/**
	 * 列表查询
	 * 
	 * @param query
	 * @return
	 */
	public List<Article> listArticle(ArticleQuery query, Integer offset, Integer limit) {
		List<Article> articleList = articleMapper.listArticle(query, offset, limit);
		return articleList;
	}

	/**
	 * @param query
	 * @return
	 */
	public int count(ArticleQuery query) {
		int count = articleMapper.count(query);
		return count;
	}
	
	/**
	 * 批量创建文章服务关系
	 * 
	 * @param param
	 * @return
	 */

	public int bathInsertArticleServeMapping(List<ServeArticle> serveArticle) {
		int count = serveArticleMapper.batchInsertSelective(serveArticle);
		return count;
	}

	/**
	 * 删除文章服务关系
	 * 
	 * @param param
	 * @return
	 */

	public int deleteArticleServeMapping(Integer articleId) {
		int count = serveArticleMapper.deleteByArticleId(articleId);
		return count;
	}
	
	
}
