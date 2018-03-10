package com.autobot.res.adc.common.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.autobot.base.util.JsonUtil;
import com.autobot.res.adc.bo.CatalogBO;

/**
 * @Description: 递归构造树型结构
 * @author li_xiaodong
 * @date: 2018年3月1日 下午2:32:15
 */
public class MenuTreeUtil {

	// 共享List对象
	public List<CatalogBO> doList;

	/**
	 * @Description: List 转为树形结构 @param menu @return List<Object> @throws
	 */
	public List<Object> toMenuList(List<CatalogBO> boList) {

		// 构建返回list
		List<Object> list = new ArrayList<Object>();

		this.doList = boList;

		// 临时变量
		Map<String, Object> mapArr = null;

		// 逻辑处理
		for (CatalogBO bo : boList) {

			if ("0".equals(bo.getParentId())) {
				// 临时变量
				mapArr = new LinkedHashMap<String, Object>();
				mapArr.put("id", bo.getId());
				mapArr.put("parentId", bo.getParentId());
				mapArr.put("serveId", bo.getServeId());
				mapArr.put("url", bo.getUrl());
				mapArr.put("gmtCreate", bo.getGmtCreate());
				mapArr.put("nameCreate", bo.getNameCreate());
				// 处理叶子节点
				mapArr.put("childList", menuChild(bo.getId()));
				list.add(mapArr);
			}
		}
		return list;
	}

	/**
	 * @Description: 子节点处理 @param id @return List<?> @throws
	 */
	private List<?> menuChild(String id) {

		// 构建返回 子目录List
		List<Object> childList = new ArrayList<Object>();

		// 临时变量
		Map<String, Object> childArray = null;

		// 循环逻辑
		for (CatalogBO bo : doList) {

			if (bo.getParentId().equals(id)) {

				// 临时变量
				childArray = new LinkedHashMap<String, Object>();

				childArray.put("id", bo.getId());
				childArray.put("parentId", bo.getParentId());
				childArray.put("serveId", bo.getServeId());
				childArray.put("url", bo.getUrl());
				childArray.put("gmtCreate", bo.getGmtCreate());
				childArray.put("nameCreate", bo.getNameCreate());

				childArray.put("childList", menuChild(bo.getId()));
				childList.add(childArray);
			}
		}
		return childList;
	}

	/**
	 * [{"id":1,"parentId":0,"serveId":1,"url":"http://www.baidu.com","gmtCreate":"2018-02-28
	 * 20:27:08","nameCreate":"lixiaodong","childList":[{"id":4,"parentId":1,"serveId":1,"url":"www.lxdyun.com","gmtCreate":"2018-03-01
	 * 13:07:20","nameCreate":"lixiaodong","childList":[{"id":5,"parentId":4,"serveId":1,"url":"www.lxdyun.com","gmtCreate":"2018-03-01
	 * 13:07:46","nameCreate":"lixiaodong","childList":[{"id":6,"parentId":5,"serveId":1,"url":"www.lxdyun.com","gmtCreate":"2018-03-01
	 * 13:07:51","nameCreate":"lixiaodong","childList":[]}]}]}]}]
	 * 
	 * @Description: 树形结构 转为 List @param menu @return List<Object> @throws
	 */
	public List<CatalogBO> menuToList(String jsonStr) {

		// 构建返回对象list
		List<CatalogBO> boList = new ArrayList<>();

		// 对象
		Object obj = JsonUtil.parseToObject(jsonStr, Object.class);

//		List<?> list = new ArrayList<>();
//		list = (List<?>) obj;

		// 单个服务方
		Map map = (Map) obj;

		CatalogBO bo = new CatalogBO();

		// 生成UUID
		String fistId = UUID.randomUUID().toString();
		bo.setId(fistId);
		bo.setParentId("0");
		bo.setServeId((Integer) map.get("serveId"));
		bo.setNameCreate((String) map.get("nameCreate"));
		bo.setNameModified((String) map.get("nameCreate"));
		bo.setUrl((String) map.get("url"));

		boList.add(bo);

		menuChildToList(boList, (List) map.get("childList"), fistId);

		return boList;

	}

	private void menuChildToList(List<CatalogBO> boList, List<?> list, String parentId) {

		if (null != list && !list.isEmpty()) {

			for (int i = 0; i < list.size(); i++) {
				Map map = (Map) list.get(i);

				String childId = UUID.randomUUID().toString();

				CatalogBO bo = new CatalogBO();
				bo.setId(childId);
				bo.setParentId(parentId);
				bo.setServeId((Integer) map.get("serveId"));
				bo.setNameCreate((String) map.get("nameCreate"));
				bo.setNameModified((String) map.get("nameCreate"));
				bo.setUrl((String) map.get("url"));
				boList.add(bo);

				menuChildToList(boList, (List) map.get("childList"), childId);
			}

		}

	}

}
