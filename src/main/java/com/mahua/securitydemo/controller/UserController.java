package com.mahua.securitydemo.controller;


import com.mahua.securitydemo.entity.User;
import com.mahua.securitydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/list")
	public List<User> users() {
		return userRepository.findAll();
	}
}
