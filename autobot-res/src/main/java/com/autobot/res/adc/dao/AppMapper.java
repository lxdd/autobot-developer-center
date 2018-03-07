package com.autobot.res.adc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.autobot.base.adc.dto.AppGateQuery;
import com.autobot.res.adc.model.App;
import com.autobot.res.adc.vo.AppQuery;

/**
 * @Description: TODO
 * @author li_xiaodong
 * @date: 2018年3月7日 上午11:10:53 
 */
@Mapper
public interface AppMapper {
	
    int deleteByPrimaryKey(Integer appId);

    int insert(App record);

    int insertSelective(App record);

    App selectByPrimaryKey(Integer appId);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKey(App record);
    
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
	List<App> listApp(@Param("query") AppQuery query, @Param("offset") Integer offset,
			@Param("limit") Integer limit);

	/**
	 * 
	 * @return 总条数
	 */
	int count(@Param("query") AppQuery query);
	
	/**  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param query
	* @return
	* @throws  
	*/ 
	App query(@Param("query") AppGateQuery query);
}