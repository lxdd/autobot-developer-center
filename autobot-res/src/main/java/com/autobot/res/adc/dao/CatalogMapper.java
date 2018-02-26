package com.autobot.res.adc.dao;

import org.apache.ibatis.annotations.Mapper;

import com.autobot.res.adc.model.Catalog;

@Mapper
public interface CatalogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Catalog record);

    int insertSelective(Catalog record);

    Catalog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Catalog record);

    int updateByPrimaryKey(Catalog record);
}