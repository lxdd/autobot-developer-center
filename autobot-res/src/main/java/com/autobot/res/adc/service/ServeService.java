package com.autobot.res.adc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.autobot.res.adc.dao.ServeMapper;
import com.autobot.res.adc.model.Serve;
import com.autobot.res.adc.vo.ServeQuery;

/**
 * 
 * @author li_xiaodong
 *
 */
@Service("serveService")
public class ServeService {

	@Resource
	private ServeMapper serveMapper;

	/**
	 * 查看
	 * 
	 * @param id
	 * @return
	 */

	public Serve getById(int id) {
		Serve serve = serveMapper.selectByPrimaryKey(id);
		return serve;
	}

	/**
	 * 创建
	 * 
	 * @param param
	 * @return
	 */

	public int insert(Serve serve) {
		int count = serveMapper.insertSelective(serve);
		return count;
	}

	/**
	 * 更新
	 * 
	 * @param param
	 * @return
	 */

	public int update(Serve serve) {
		int count = serveMapper.updateByPrimaryKeySelective(serve);
		return count;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */

	public int delete(int id) {
		int count = serveMapper.deleteById(id);
		return count;
	}

	/**
	 * 列表查询
	 * 
	 * @param query
	 * @return
	 */
	public List<Serve> listServe(ServeQuery query, Integer offset, Integer limit) {
		List<Serve> serveList = serveMapper.listServe(query, offset, limit);
		return serveList;
	}

	/**
	 * @param query
	 * @return
	 */
	public int count(ServeQuery query) {
		int count = serveMapper.count(query);
		return count;
	}

	/**
	 * @Description: 获取服务list，根据文档Id @param articleId @return @throws
	 */
	public List<Serve> getServeListByArticleId(Integer articleId) {

		List<Serve> serveList = serveMapper.getServeListByArticleId(articleId);
		return serveList;
	}
	
	/**
	 * @Description: 获取服务list，根据文档Id @param articleId @return @throws
	 */
	public List<Serve> getServeListByArticleIdlist(List<Integer> articleIdList) {

		List<Serve> serveList = serveMapper.getServeListByArticleIdList(articleIdList);
		return serveList;
	}

}
