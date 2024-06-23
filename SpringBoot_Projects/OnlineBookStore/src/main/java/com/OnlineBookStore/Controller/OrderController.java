package com.OnlineBookStore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
	
	@RequestMapping("/addToCart")
	public String addToCart() {
		
		return "Testing";
	}
	
	
	@RequestMapping("/order/history")
	public String getX() {
		return "order-history";
	}
	
	@RequestMapping(value = "/order")
	public String getOrders() {
		return "order"; 
	}
}
