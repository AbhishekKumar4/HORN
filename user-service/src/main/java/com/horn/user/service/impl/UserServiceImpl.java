package com.horn.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horn.user.domain.User;
import com.horn.user.repository.UserRepository;
import com.horn.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User getUserDetails(Long userId) {
		Optional<User> userDetails = userRepository.findById(userId);
		if (userDetails.isPresent()) {
			return userDetails.get();
		} else {
			return null;
		}
	}

	@Override
	public void registerUser(User user) {
		userRepository.save(user);
	}

}
