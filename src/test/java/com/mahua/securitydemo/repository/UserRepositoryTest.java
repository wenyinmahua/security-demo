package com.mahua.securitydemo.repository;

import com.mahua.securitydemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;


	@Test
	void getUserByUsername() {
		User user = userRepository.findByUsername("admin");
		System.out.println(user);
	}

}