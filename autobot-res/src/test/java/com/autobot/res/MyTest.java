/**
 * @author: li_xiaodong  
 * @date: 2018年3月1日 上午11:17:24
 */
package com.autobot.res;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @author li_xiaodong
 * @date: 2018年3月1日 上午11:17:24
 */
public class MyTest {

	/**
	 * @Description: TODO(这里用一句话描述这个方法的作用) @param args void @throws
	 */
	public static void main(String[] args) {

		Map<String, Object> returnmap = new HashMap<>();
		
		MenuTreeUtil menuTree = new MenuTreeUtil();
		
//		PageData pd = this.getPageData();
		
		// 这里的方法是根据前台的机构类型代码来查找数据库数据的，这里不多加解释，因人而异
		
		List<Tree> list = new ArrayList<>();
		Tree tree = new Tree();
		tree.setId("1");
		tree.setpId("0");
		tree.setName("1");
		list.add(tree);
		
		tree = new Tree();
		tree.setId("2");
		tree.setpId("0");
		tree.setName("2");
		list.add(tree);
		
		tree = new Tree();
		tree.setId("3");
		tree.setpId("1");
		tree.setName("3");
		list.add(tree);
		
		tree = new Tree();
		tree.setId("4");
		tree.setpId("2");
		tree.setName("4");
		list.add(tree);
		
		tree = new Tree();
		tree.setId("5");
		tree.setpId("3");
		tree.setName("5");
		list.add(tree);
		
		
		List<Object> menuList = menuTree.menuList(list);
		
		//
		System.out.println(menuList);
		
//		returnmap.put("list", menuList);

	}

}
