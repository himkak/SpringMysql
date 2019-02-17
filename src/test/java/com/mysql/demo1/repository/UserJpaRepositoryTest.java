package com.mysql.demo1.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mysql.demo.SpringMysqlApplication;
import com.mysql.demo.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringMysqlApplication.class)
public class UserJpaRepositoryTest {
	
	@Autowired
	private UserJpaRepository userJpaRepo;
	
	@Test
	public void testSave() {
		userJpaRepo.deleteAll();
		User u1=User.builder().name("A1").age(10).sex(User.SEX.M).build();
		userJpaRepo.save(u1);
		Assert.assertEquals(1, userJpaRepo.count());
	}

}
