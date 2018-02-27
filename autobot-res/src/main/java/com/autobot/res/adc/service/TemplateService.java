package com.autobot.res.adc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.autobot.res.adc.dao.TemplateMapper;
import com.autobot.res.adc.model.Template;
import com.autobot.res.adc.vo.TemplateQuery;

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

	public int update(Template template) {
		int count = templateMapper.updateByPrimaryKeySelective(template);
		return count;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */

	public int delete(int id) {
		int count = templateMapper.deleteById(id);
		return count;
	}

	/**
	 * 列表查询
	 * 
	 * @param query
	 * @return
	 */
	public List<Template> listTemplate(TemplateQuery query, Integer offset, Integer limit) {
		List<Template> templateList = templateMapper.listTemplate(query, offset, limit);
		return templateList;
	}

	/**
	 * @param query
	 * @return
	 */
	public int count(TemplateQuery query) {
		int count = templateMapper.count(query);
		return count;
	}

}
