package com.eddy.order.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eddy.pojo.Item;
import com.eddy.util.JsonResult;

@FeignClient(name = "item-service", fallback = ItemFeignServiceFB.class)
public interface ItemFeignService {
	
	@GetMapping("/{orderId}")
	JsonResult<List<Item>> getItems(@PathVariable String orderId);
	
	
}
