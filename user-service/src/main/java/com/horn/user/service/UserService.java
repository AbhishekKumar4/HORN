package com.horn.user.service;

import com.horn.user.domain.User;

public interface UserService {

	public User getUserDetails(Long userId);

	public void registerUser(User user);
}
