package com.autobot.res.adc.dao;

import org.apache.ibatis.annotations.Mapper;

import com.autobot.res.adc.model.Serve;

@Mapper
public interface ServeMapper {
    int deleteByPrimaryKey(Integer serveId);

    int insert(Serve record);

    int insertSelective(Serve record);

    Serve selectByPrimaryKey(Integer serveId);

    int updateByPrimaryKeySelective(Serve record);

    int updateByPrimaryKey(Serve record);
}