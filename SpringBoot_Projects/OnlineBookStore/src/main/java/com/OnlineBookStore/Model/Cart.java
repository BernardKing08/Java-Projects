package com.OnlineBookStore.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Component
public class Cart {
	
	//create an arrayList of books
	private List<Book> booksInCart = new ArrayList<>();
	private double totalPrice;
	
	
}

