package com.njust.ssm.service.impl;

import com.njust.ssm.mapper.ItemsMapper;
import com.njust.ssm.po.Items;
import com.njust.ssm.po.ItemsCustomer;
import com.njust.ssm.po.ItemsQueryVo;
import com.njust.ssm.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
public class ItemsServiceImpl implements IItemsService{

    @Autowired
    private ItemsMapper itemsMapper;

	@Override
	public List<ItemsCustomer> queryItems(ItemsQueryVo itemsQueryVo)
			throws Exception {
		return itemsMapper.queryItems(itemsQueryVo);
	}

	@Override
	public ItemsCustomer findItemsById(int id) throws Exception {
		return itemsMapper.findItemsById(id);
	}

	@Override
	public void updateItems(int id, Items items) throws Exception {
		
		if(itemsMapper.findItemsById(id)!=null){
			itemsMapper.updateItem(items);
		}else{
			throw new RuntimeException("id不对");
		}
		
	}
	
}
