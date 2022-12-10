package com.simplilearn.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.fooddelivery.entity.User;
import com.simplilearn.fooddelivery.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200/")
public class UserController {
	
	@Autowired
	private UserService service; 
	
	@PostMapping("/addUser")
	public boolean addUser(@RequestBody User u) {
		
		System.out.println("Name:::"+u.getName());
		System.out.println("Phone No.."+u.getPhone());
		
		return service.addUser(u);
		
	}
	
	@GetMapping("/getAllUsers")
	public List<User>getAllUsers(){
		return service.getAllUsers();
		
	}

}
