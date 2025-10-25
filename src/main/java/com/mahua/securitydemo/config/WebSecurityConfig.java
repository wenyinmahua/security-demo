package com.mahua.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
//@EnableWebSecurity // 开启 Spring Security 自定义配置，Spring Boot 项目是可以省略此诸结，单纯的Spring 项目是需要的
public class WebSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		// 创建基于内存的用户信息管理器
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		// 创建 UserDetails 对象，用于管理用户名、密码、角色信息、用户权限等等
		manager.createUser(User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build());
		return  manager;
	}
}
