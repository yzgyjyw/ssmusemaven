package com.njust.ssm.service;

import com.njust.ssm.po.Items;
import com.njust.ssm.po.ItemsCustomer;
import com.njust.ssm.po.ItemsQueryVo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
public interface IItemsService {
    List<ItemsCustomer> queryItems(ItemsQueryVo itemsQueryVo) throws Exception;
    
    ItemsCustomer findItemsById(int id) throws Exception;
    
    void updateItems(int id,Items items)throws Exception;
}
