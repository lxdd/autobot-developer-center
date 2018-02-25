package com.autobot.res.adc.dao;

import org.apache.ibatis.annotations.Mapper;

import com.autobot.res.adc.model.Template;

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
     * @param id
     * @return
     */
    int deleteById(Integer id);
}