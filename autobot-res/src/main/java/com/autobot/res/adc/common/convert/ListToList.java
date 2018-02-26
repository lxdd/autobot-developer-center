package com.autobot.res.adc.common.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.autobot.res.adc.bo.TemplateBO;
import com.autobot.res.adc.model.Template;

/**
 * List 对象转换
 * 
 * @author li_xiaodong
 *
 */
public class ListToList {

	/**
	 * 对象转换DO--DTO
	 * 
	 * @param moList
	 * @return
	 */
	public static List<TemplateBO> convertTemplateList(List<Template> moList) {
		List<TemplateBO> dtoList = new ArrayList<TemplateBO>();

		if (null != moList && !moList.isEmpty()) {
			TemplateBO dto = null;
			for (Template mo : moList) {
				dto = new TemplateBO();
				BeanUtils.copyProperties(mo, dto);
				dtoList.add(dto);
			}
		}
		return dtoList;
	}

}
