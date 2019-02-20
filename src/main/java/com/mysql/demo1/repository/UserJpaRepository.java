package com.mysql.demo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mysql.demo.entity.User;


@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer>{
	
	List<User> findByName(String name);
	
	List<User> findByAgeOrName(int age, String name);
	
	@Query("select u from User u where u.age > :age1 and u.age < :age2")
	List<User> queryByAgeRange(@Param("age1") int age1, @Param("age2") int age2);
	
}
