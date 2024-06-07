package com.System.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@NotBlank(message = "ID cannot be blank")
	private String id;
	
	@Size(min=5)
	@NotBlank(message = "User Name cannot be blank")
	private String userName;
	
	@NotBlank(message = "Password cannot be blank")
	@Size(min=5, message="Password must be more than 5 characters long")
	private String password;
	
	@Email
	@NotBlank(message = "email cannot be blank")
	private String email; 
	
	
}
