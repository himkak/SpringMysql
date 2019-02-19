package com.mysql.demo1.repository;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Before;
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
	
	@Before
	public void setup() {
		
		IntStream.range(1, 10).forEach(i->userJpaRepo.save(User.builder().name("A"+i).age(10+i).sex(i%2==0?User.SEX.M:User.SEX.F).build()));
	}
	
	@Test
	public void testSave() {
		userJpaRepo.deleteAll();
		User u1=User.builder().name("A1").age(10).sex(User.SEX.M).build();
		userJpaRepo.save(u1);
		Assert.assertEquals(1, userJpaRepo.count());
	}
	
	

}
