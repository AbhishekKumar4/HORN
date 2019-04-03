package com.horn.seed.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.horn.seed.user.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public User getUserDetails(String id);
}
