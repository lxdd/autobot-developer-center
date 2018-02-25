package com.autobot.res.adc.dao;

import com.autobot.res.adc.model.AppArticle;

public interface AppArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppArticle record);

    int insertSelective(AppArticle record);

    AppArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppArticle record);

    int updateByPrimaryKey(AppArticle record);
}