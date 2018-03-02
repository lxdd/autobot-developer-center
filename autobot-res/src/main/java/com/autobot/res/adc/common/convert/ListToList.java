package com.autobot.res.adc.common.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.autobot.res.adc.bo.AppBO;
import com.autobot.res.adc.bo.ArticleBO;
import com.autobot.res.adc.bo.CatalogBO;
import com.autobot.res.adc.bo.ServeBO;
import com.autobot.res.adc.bo.TemplateBO;
import com.autobot.res.adc.model.App;
import com.autobot.res.adc.model.Article;
import com.autobot.res.adc.model.Catalog;
import com.autobot.res.adc.model.Serve;
import com.autobot.res.adc.model.Template;

/**
 * List 对象转换
 * 
 * @author li_xiaodong
 *
 */
public class ListToList {

	/**
	 * 对象转换DO--BO
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

	/**
	 * 对象转换DO--BO
	 * 
	 * @param moList
	 * @return
	 */
	public static List<ServeBO> convertServeList(List<Serve> moList) {
		List<ServeBO> boList = new ArrayList<ServeBO>();

		if (null != moList && !moList.isEmpty()) {
			ServeBO bo = null;
			for (Serve mo : moList) {
				bo = new ServeBO();
				BeanUtils.copyProperties(mo, bo);
				boList.add(bo);
			}
		}
		return boList;
	}

	/**
	 * 对象转换DO--BO
	 * 
	 * @param moList
	 * @return
	 */
	public static List<ArticleBO> convertArticleList(List<Article> moList) {
		List<ArticleBO> boList = new ArrayList<ArticleBO>();

		if (null != moList && !moList.isEmpty()) {
			ArticleBO bo = null;
			for (Article mo : moList) {
				bo = new ArticleBO();
				BeanUtils.copyProperties(mo, bo);
				boList.add(bo);
			}
		}
		return boList;
	}
	
	/**
	 * 对象转换DO--BO
	 * 
	 * @param moList
	 * @return
	 */
	public static List<AppBO> convertAppList(List<App> moList) {
		List<AppBO> boList = new ArrayList<AppBO>();

		if (null != moList && !moList.isEmpty()) {
			AppBO bo = null;
			for (App mo : moList) {
				bo = new AppBO();
				BeanUtils.copyProperties(mo, bo);
				boList.add(bo);
			}
		}
		return boList;
	}
	
	/**
	 * 对象转换DO--BO
	 * 
	 * @param moList
	 * @return
	 */
	public static List<CatalogBO> convertCatalogList(List<Catalog> moList) {
		List<CatalogBO> boList = new ArrayList<CatalogBO>();

		if (null != moList && !moList.isEmpty()) {
			CatalogBO bo = null;
			for (Catalog mo : moList) {
				bo = new CatalogBO();
				BeanUtils.copyProperties(mo, bo);
				boList.add(bo);
			}
		}
		return boList;
	}
}
