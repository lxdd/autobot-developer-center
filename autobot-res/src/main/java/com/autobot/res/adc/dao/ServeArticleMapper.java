package com.autobot.res.adc.dao;

import java.util.List;

import com.autobot.res.adc.model.ServeArticle;

public interface ServeArticleMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(ServeArticle record);

    int insertSelective(ServeArticle record);

    ServeArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServeArticle record);

    int updateByPrimaryKey(ServeArticle record);
    
    /**  
    * @Description: 批量创建文章服务关系
    * @param serveArticleList
    * @return
    * @throws  
    */ 
    int batchInsertSelective(List<ServeArticle> serveArticleList);
    
    /**  
    * @Description: 删除文章服务关系
    * @param articleId
    * @return
    * @throws  
    */ 
    int deleteByArticleId(Integer articleId);
}