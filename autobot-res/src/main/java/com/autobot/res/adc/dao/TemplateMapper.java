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

	int insert(Template record);

	int insertSelective(Template record);

	Template selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Template record);

	int updateByPrimaryKeyWithBLOBs(Template record);

	int updateByPrimaryKey(Template record);

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
	List<Template> listTemplate(@Param("query") TemplateQuery query, @Param("offset") Integer offset,
			@Param("limit") Integer limit);

	/**
	 * 
	 * @return 总条数
	 */
	int count(@Param("query") TemplateQuery query);
}