package com.horn.seed.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.horn.seed.user.domain.User;
import com.horn.seed.user.repository.UserRepository;
import com.horn.seed.user.service.UserService;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User getUserDetails(String userId) {
		User userDetails = userRepository.getUserDetails(userId);
		return userDetails;
	}

}
