package com.autobot.res.adc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.autobot.res.adc.model.Catalog;
import com.autobot.res.adc.vo.CatalogQuery;

/**
 * Catalog
 * @author li_xiaodong
 * @date: 2018年2月28日 下午7:53:32 
 */
@Mapper
public interface CatalogMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Catalog record);

    /**  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @param @param record
    * @param @return    设定文件  
    * @return int    返回类型  
    * @throws  
    */ 
    int insertSelective(Catalog record);

    
    /**  
    * @Description: 详情
    * @param @param id
    * @param @return    设定文件  
    * @return Catalog    返回类型  
    * @throws  
    */ 
    Catalog selectByPrimaryKey(Integer id);

    /**  
    * @Description: updateByPrimaryKeySelective
    * @param @param record
    * @param @return    设定文件  
    * @return int    返回类型  
    * @throws  
    */ 
    int updateByPrimaryKeySelective(Catalog record);

    int updateByPrimaryKey(Catalog record);
    
	/**  
	* @Description: 逻辑删除   
	* @param @param id
	* @param @return    设定文件  
	* @return int    返回类型  
	* @throws  
	*/ 
	int deleteById(Integer id);
	
	/**  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param query
	* @return
	* List<Catalog>
	* @throws  
	*/ 
	List<Catalog> listCatalog(@Param("query") CatalogQuery query);
}