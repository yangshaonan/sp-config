package com.eddy.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eddy.order.feign.ItemFeignService;
import com.eddy.pojo.Item;
import com.eddy.pojo.Order;
import com.eddy.service.OrderService;
import com.eddy.util.JsonResult;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ItemFeignService itemFeignService;
	
	@Override
	public Order getOrder(String orderId) {
		//TODO: 调用user-service获取用户信息
		JsonResult<List<Item>> items = itemFeignService.getItems(orderId);
		//TODO: 调用item-service获取商品信息
		Order order = new Order();
		order.setId(orderId);
		order.setItems(items.getData());
		return order;
	}

	@Override
	public void addOrder(Order order) {
		//TODO: 调用item-service减少商品库存
		//TODO: 调用user-service增加用户积分
		log.info("保存订单："+order);
	}

}
