package com.mahua.securitydemo.config;

import com.mahua.securitydemo.entity.User;
import com.mahua.securitydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class DBUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService {

	@Autowired
	private UserRepository userRepository;


	@Override
	public UserDetails updatePassword(UserDetails user, String newPassword) {
		return null;
	}

	@Override
	public void createUser(UserDetails user) {

	}

	@Override
	public void updateUser(UserDetails user) {

	}

	@Override
	public void deleteUser(String username) {

	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {

	}

	@Override
	public boolean userExists(String username) {
		return false;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User byUsername = userRepository.findByUsername(username);
		if (byUsername != null) {
			return new org.springframework.security.core.userdetails.User(
				byUsername.getUsername(),
				byUsername.getPassword(),
				byUsername.getEnable(),
				true, // 账号是否未过期
				true, // 密码是否未过期
				true, // 账号是否未锁定
				AuthorityUtils.createAuthorityList("ROLE_USER")
			);
		}else {
			throw new UsernameNotFoundException("用户不存在");
		}
	}
}
