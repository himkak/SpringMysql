package com.mysql.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.demo.entity.User;
import com.mysql.demo.service.UserService;

@RestController
@RequestMapping(path="/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/id/{userId}")
	public User getUser(@PathVariable int userId) {
		
		return userService.getUser(userId).get();
	}
	
	@PostMapping
	public int createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/name/{name}")
	public List<User> getUser(@PathVariable String name){
		return userService.getUser(name);
	}

}
