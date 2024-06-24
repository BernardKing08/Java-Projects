package com.OnlineBookStore.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cart {
	private String id; 
	private Book book;
}
