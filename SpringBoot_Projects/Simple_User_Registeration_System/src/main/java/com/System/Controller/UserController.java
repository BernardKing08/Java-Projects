package com.System.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.System.Config.TrackExecutionTime;
import com.System.Model.User;
import com.System.Service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	private final UserService userService;
	
	//@Autowired
	UserController(UserService userService){
		this.userService = userService;
	}
	
	//getting all user from the list

	@GetMapping(value = {"/users"})
	@TrackExecutionTime
	public List<User> allUsers(){
		return userService.getAllUsers();
	}
	
	//retrieving a particular user
	@GetMapping(value = {"/user/{id}"})
	public User getUserById(@PathVariable String id) {
		return userService.getUserById(id);
	}
	
	//adding user resource
	@PostMapping(value = "/user")
	public void addNewUser(@RequestBody User user){
		userService.addNewUser(user);
	}
	
	//updating a user resource
	@PutMapping(value = {"/user/{id}"})
	public void updateUser(@PathVariable String id, @RequestBody User updatedUser) {
		userService.updateUser(updatedUser, id);		
	}
	
	//deleting user resource 
	@DeleteMapping(value = "/user/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
}
