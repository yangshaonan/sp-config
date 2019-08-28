package com.eddy.service;

import java.util.List;

import com.eddy.pojo.Item;

public interface ItemService {
	List<Item> getItems(String orderId);
	void decreaseNumbers(List<Item> list);
}
