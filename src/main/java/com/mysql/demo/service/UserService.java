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
	
	public void createUser(User user) {
		userRepo.save(user);
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
}
