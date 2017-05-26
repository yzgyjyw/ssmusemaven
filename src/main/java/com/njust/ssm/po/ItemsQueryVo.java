package com.njust.ssm.po;

import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 * 用于构建对Item进行查询的条件，因为mapper中只能有一个参数，所以需要使用包装类型
 */
public class ItemsQueryVo {
    private Items items;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }
    
    //增加一个字段用于批量的更新
    private List<Items> itemsList;

	public List<Items> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}
    
    
}
