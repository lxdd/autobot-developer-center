package com.autobot.res.adc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.autobot.res.adc.model.Template;
import com.autobot.res.adc.vo.TemplateQuery;

/**
 * @Description: TODO
 * @author li_xiaodong
 * @date: 2018年2月27日 下午11:14:58 
 */
@Mapper
public interface TemplateMapper {

	int deleteByPrimaryKey(Integer id);

	
	/**  
	* @Title: insert  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param record
	* @param @return    设定文件  
	* @return int    返回类型  
	* @throws  
	*/ 
	@Deprecated
	int insert(Template record);

	/**  
	* @Title: insertSelective  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param record
	* @param @return    设定文件  
	* @return int    返回类型  
	* @throws  
	*/ 
	int insertSelective(Template record);

	Template selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Template record);

	/**  
	* @Title: updateByPrimaryKeyWithBLOBs  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param record
	* @param @return    设定文件  
	* @return int    返回类型  
	* @throws  
	*/ 
	@Deprecated
	int updateByPrimaryKeyWithBLOBs(Template record);

	/**  
	* @Title: updateByPrimaryKey  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param record
	* @param @return    设定文件  
	* @return int    返回类型  
	* @throws  
	*/ 
	@Deprecated
	int updateByPrimaryKey(Template record);

	/**
	 * 逻辑删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteById(Integer id);

	/**  
	* @Title: listTemplate  
	* @Description: 列表查询 
	* @param @param query
	* @param @param offset
	* @param @param limit
	* @param @return    设定文件  
	* @return List<Template>    返回类型  
	* @throws  
	*/ 
	List<Template> listTemplate(@Param("query") TemplateQuery query, @Param("offset") Integer offset,
			@Param("limit") Integer limit);

	/**
	 * 
	 * @return 总条数
	 */
	int count(@Param("query") TemplateQuery query);
}