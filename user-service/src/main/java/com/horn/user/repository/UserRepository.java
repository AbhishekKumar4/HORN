package com.horn.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.horn.user.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
