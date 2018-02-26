package com.autobot.res.adc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.autobot.res.adc.dao.TemplateMapper;
import com.autobot.res.adc.model.Template;

/**
 * 
 * @author li_xiaodong
 *
 */
@Service("templateService")
public class TemplateService {

	@Resource
	private TemplateMapper templateMapper;

	/**
	 * 查看
	 * 
	 * @param id
	 * @return
	 */

	public Template getById(int id) {
		Template template = templateMapper.selectByPrimaryKey(id);
		return template;
	}

	/**
	 * 创建
	 * 
	 * @param param
	 * @return
	 */

	public int insert(Template template) {
		int count = templateMapper.insertSelective(template);
		return count;
	}

	/**
	 * 更新
	 * 
	 * @param param
	 * @return
	 */

	public int update(Template template) throws Exception {
		int count = templateMapper.updateByPrimaryKeySelective(template);
		return count;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */

	public int delete(int id) throws Exception {
		int count = templateMapper.deleteById(id);
		return count;
	}

}
