package com.mysql.demo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysql.demo.entity.User;


@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer>{
	
	List<User> findByName(String name);
	
	List<User> findByAgeOrName(int age, String name);
	
}
