package com.horn.seed.user.service;

import com.horn.seed.user.domain.User;

public interface UserService {

	public User getUserDetails(Long userId);

	public void registerUser(User user);
}