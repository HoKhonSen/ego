package com.ego.item.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ego.dubbo.service.TbItemCatDubboService;
import com.ego.item.pojo.ProtalMenu;
import com.ego.item.pojo.ProtalMenuNode;
import com.ego.item.service.TbItemCatService;
import com.ego.pojo.TbItemCat;

@Service
public class TbItemCatServiceImpl implements TbItemCatService{
	@Reference
	private TbItemCatDubboService tbItemCatDubboServiceImpl;
	@Override
	public ProtalMenu showCatMenu() {
		//查询所有一级菜单
		List<TbItemCat> list = tbItemCatDubboServiceImpl.show(0);
		ProtalMenu pm =new ProtalMenu();
		pm.setData(selAllMenu(list));
		return pm;
	}
	
	/**
	 * 最终返回结果所有查询到的结果.
	 * @param list
	 * @return
	 */
	public List<Object> selAllMenu(List<TbItemCat> list){
		List<Object> listNode = new ArrayList<>();
		for(TbItemCat tbItemCat : list) {
			if (tbItemCat.getIsParent() ) {
				ProtalMenuNode pmd = new ProtalMenuNode();
				pmd.setU("/products/"+tbItemCat.getId()+".html");
				pmd.setN("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");
				pmd.setI(selAllMenu(tbItemCatDubboServiceImpl.show(tbItemCat.getId())));
				listNode.add(pmd);
			}else{
				listNode.add("/products/"+tbItemCat.getId()+".html|"+tbItemCat.getName());
			}
		}
		return listNode;
	}
}
