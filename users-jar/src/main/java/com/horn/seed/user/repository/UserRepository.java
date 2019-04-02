package com.horn.seed.user.repository;

import com.horn.seed.user.domain.User;

public interface UserRepository {

	public User getUserDetails(String id);
}
