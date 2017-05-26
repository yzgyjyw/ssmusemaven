package com.njust.ssm.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.njust.ssm.po.ItemsCustomer;
import com.njust.ssm.service.IItemsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/*.xml")
public class ItemsServiceTest {

	@Autowired
	private IItemsService itemsService;
	
	@Test
	public void testQueryItems() throws Exception{
		List<ItemsCustomer> items = itemsService.queryItems(null);
		System.out.println("1");
	}
	
}
