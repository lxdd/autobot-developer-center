package com.autobot.res.adc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.autobot.res.adc.model.Serve;
import com.autobot.res.adc.vo.ServeQuery;

@Mapper
public interface ServeMapper {
    int deleteByPrimaryKey(Integer serveId);

    int insert(Serve record);

    int insertSelective(Serve record);

    Serve selectByPrimaryKey(Integer serveId);

    int updateByPrimaryKeySelective(Serve record);

    int updateByPrimaryKey(Serve record);
    
    /**
	 * 逻辑删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(Integer serveId);

	/**
	 * 列表查询
	 * 
	 * @param query
	 * @return
	 */
	List<Serve> listServe(@Param("query") ServeQuery query, @Param("offset") Integer offset,
			@Param("limit") Integer limit);

	/**
	 * 
	 * @return 总条数
	 */
	int count(@Param("query") ServeQuery query);
	
	
	/**  
	* @Description: 获取服务list，根据文档Id 
	* @param articleId
	* @return
	* @throws  
	*/ 
	List<Serve> getServeListByArticleId(Integer articleId);
	
	/**  
	* @Description: 获取服务list，根据文档Id 
	* @param articleId
	* @return
	* @throws  
	*/ 
	List<Serve> getServeListByArticleIdList(List<Integer> articleIdList);
	
}