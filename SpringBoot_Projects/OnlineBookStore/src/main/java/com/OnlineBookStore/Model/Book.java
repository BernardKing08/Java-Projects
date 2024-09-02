package com.OnlineBookStore.Model;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
	
	@NotBlank(message = "id must not be blank")
	private String id;
	
	@NotBlank(message = "name must not be blank")
	@Size(min = 3)
	private String name; 
	
	//uuid for keeping track of books in cart
	private String uuid;

	private String imageUrl;
	
	@NotBlank(message = "author must not be blank")
	@Size(min = 5)
	private String author; 
	
	@NotBlank(message = "description must not be blank")
	@Size(min = 10)
	private String description;
	
	//keeps track of the nummber of book-items in the cart
	private int qty;
	
	//price of the item
	private double price;
	
	public Book(@NotBlank(message = "id must not be blank") String id,
				@NotBlank(message = "name must not be blank") @Size(min = 3) String name, String imageUrl,
				@NotBlank(message = "author must not be blank") @Size(min = 5) String author,
				@NotBlank(message = "description must not be blank") @Size(min = 10) String description) {
		this.id = id;
		this.uuid = UUID.randomUUID().toString();
		this.name = name;
		this.imageUrl = imageUrl;
		this.author = author;
		this.description = description;
		this.qty = 0;
	}
	
}
