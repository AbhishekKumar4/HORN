package com.horn.seed.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.horn.seed.user.domain.User;
import com.horn.seed.user.service.UserService;

@RestController(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping(name = "/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		// Save details
		userService.registerUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(name = "/getUserDetails")
	public ResponseEntity<User> userDetails(@RequestParam Long userId) {
		User user = userService.getUserDetails(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
