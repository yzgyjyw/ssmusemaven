package com.njust.ssm.mapper;

import com.njust.ssm.po.Items;
import com.njust.ssm.po.ItemsCustomer;
import com.njust.ssm.po.ItemsQueryVo;
import com.njust.ssm.po.ItemsCustomer;

import java.util.List;

public interface ItemsMapper {
    List<ItemsCustomer> queryItems(ItemsQueryVo itemsQueryVo);
    
    ItemsCustomer findItemsById(int id);
    
    void updateItem(Items item);
}