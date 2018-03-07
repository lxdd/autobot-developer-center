package com.autobot.res.adc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.autobot.base.adc.dto.AppGateQuery;
import com.autobot.res.adc.dao.AppMapper;
import com.autobot.res.adc.model.App;
import com.autobot.res.adc.vo.AppQuery;

/**
 * 
 * @author li_xiaodong
 *
 */
@Service("appService")
public class AppService {

	@Resource
	private AppMapper appMapper;

	/**
	 * 查看
	 * 
	 * @param id
	 * @return
	 */

	public App getById(int id) {
		App app = appMapper.selectByPrimaryKey(id);
		return app;
	}

	/**
	 * 创建
	 * 
	 * @param param
	 * @return
	 */

	public int insert(App app) {
		int count = appMapper.insertSelective(app);
		return count;
	}

	/**
	 * 更新
	 * 
	 * @param param
	 * @return
	 */

	public int update(App app) {
		int count = appMapper.updateByPrimaryKeySelective(app);
		return count;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */

	public int delete(int id) {
		int count = appMapper.deleteById(id);
		return count;
	}

	/**
	 * 列表查询
	 * 
	 * @param query
	 * @return
	 */
	public List<App> listApp(AppQuery query, Integer offset, Integer limit) {
		List<App> serveList = appMapper.listApp(query, offset, limit);
		return serveList;
	}

	/**
	 * @param query
	 * @return
	 */
	public int count(AppQuery query) {
		int count = appMapper.count(query);
		return count;
	}
	
	/**
	 * 查看
	 * 
	 * @param id
	 * @return
	 */

	public App query(AppGateQuery query) {
		App app = appMapper.query(query);
		return app;
	}

}
