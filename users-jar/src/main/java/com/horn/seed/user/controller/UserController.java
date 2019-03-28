package com.horn.seed.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.horn.seed.user.domain.User;

@RestController(value = "/user")
public class UserController {
	
	@PostMapping(name = "/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		//Save details
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
