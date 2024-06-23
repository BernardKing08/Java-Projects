package com.OnlineBookStore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BController {
		
	@RequestMapping(value = "/cart")
	public String getcarts() {
		return "cart"; 
	}

}
