package com.OnlineBookStore.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cart {
	
	private Book book;
	private int cartItemNo;
}

