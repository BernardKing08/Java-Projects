package com.OnlineBookStore.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	@NotBlank(message = "id must not be blank")
	private String id;
	
	@NotBlank(message = "name must not be blank")
	@Size(min = 3)
	private String name; 
	
	private String imageUrl;
	
	@NotBlank(message = "author must not be blank")
	@Size(min = 5)
	private String author; 
	
	@NotBlank(message = "description must not be blank")
	@Size(min = 10)
	private String description;
	
}
