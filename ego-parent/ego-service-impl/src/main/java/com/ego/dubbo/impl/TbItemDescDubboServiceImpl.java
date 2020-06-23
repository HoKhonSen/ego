package com.ego.dubbo.impl;

import javax.annotation.Resource;

import com.ego.dubbo.service.TbItemDescDubboService;
import com.ego.mapper.TbItemDescMapper;
import com.ego.pojo.TbItemDesc;

public class TbItemDescDubboServiceImpl implements TbItemDescDubboService{
	@Resource
	private TbItemDescMapper tbItemDescMapper;
	
	@Override
	public int insDesc(TbItemDesc tbItemDdesc) {
		return tbItemDescMapper.insert(tbItemDdesc);
	}

	@Override
	public TbItemDesc selByItemid(long itemid) {
		return tbItemDescMapper.selectByPrimaryKey(itemid);
	}
}
