package com.autobot.res.adc.dao;

import com.autobot.res.adc.model.Serve;

public interface ServeMapper {
    int deleteByPrimaryKey(Integer serveId);

    int insert(Serve record);

    int insertSelective(Serve record);

    Serve selectByPrimaryKey(Integer serveId);

    int updateByPrimaryKeySelective(Serve record);

    int updateByPrimaryKey(Serve record);
}