package com.autobot.res.adc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.autobot.res.adc.dao.ServeMapper;
import com.autobot.res.adc.model.Serve;

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

}
