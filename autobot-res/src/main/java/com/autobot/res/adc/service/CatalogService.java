package com.autobot.res.adc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.autobot.res.adc.dao.CatalogMapper;
import com.autobot.res.adc.model.Catalog;
import com.autobot.res.adc.vo.CatalogQuery;

/**
 * @Description: 目录服务层
 * @author li_xiaodong
 * @date: 2018年2月27日 下午10:49:58
 */
@Service("catalogService")
public class CatalogService {

	@Resource
	private CatalogMapper catalogMapper;

	/**
	 * 创建
	 * 
	 * @param param
	 * @return
	 */

	public int insert(Catalog catalog) {
		int count = catalogMapper.insertSelective(catalog);
		return count;
	}

	/**
	 * 更新
	 * 
	 * @param param
	 * @return
	 */

	public int update(Catalog catalog) {
		int count = catalogMapper.updateByPrimaryKeySelective(catalog);
		return count;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */

	public int delete(int id) {
		int count = catalogMapper.deleteById(id);
		return count;
	}

	/**
	 * 查看
	 * 
	 * @param id
	 * @return
	 */

	public Catalog getById(int id) {
		Catalog catalog = catalogMapper.selectByPrimaryKey(id);
		return catalog;
	}

	/**
	 * 返回list
	 * 
	 * @param id
	 * @return
	 */

	public List<Catalog> listCatalog(CatalogQuery query) {
		List<Catalog> catalogList = catalogMapper.listCatalog(query);
		return catalogList;
	}

}
