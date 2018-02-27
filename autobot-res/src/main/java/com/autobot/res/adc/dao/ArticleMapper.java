package com.autobot.res.adc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.autobot.res.adc.model.Article;
import com.autobot.res.adc.vo.ArticleQuery;

@Mapper
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    
    /**
	 * 逻辑删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(Integer id);

	/**
	 * 列表查询
	 * 
	 * @param query
	 * @return
	 */
	List<Article> listArticle(@Param("query") ArticleQuery query, @Param("offset") Integer offset,
			@Param("limit") Integer limit);

	/**
	 * 
	 * @return 总条数
	 */
	int count(@Param("query") ArticleQuery query);
}