package com.mysql.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.demo.entity.User;
import com.mysql.demo1.repository.UserJpaRepository;

@Service
public class UserService {

	@Autowired
	private UserJpaRepository userRepo;
	
	public Optional<User> getUser(int id) {
		return userRepo.findById(id);
	}
	
	public int createUser(User user) {
		return userRepo.save(user).getId();
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	public List<User> getUser(String name) {
		return userRepo.findByName(name);
	}
}
