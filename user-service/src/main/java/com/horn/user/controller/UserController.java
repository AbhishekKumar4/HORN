package com.horn.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.horn.user.domain.User;
import com.horn.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "User", description = "Operations related to user service")
public class UserController {
	
	@Autowired
	private UserService userService;

	@ApiOperation(value = "Register new User")
	@PostMapping(value = "/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		// Save details
		userService.registerUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	
	@ApiOperation(value = "Get User Details")
	@GetMapping(value = "/getUserDetails")
	public ResponseEntity<User> userDetails(@RequestParam(value = "userid", required = true) Long userId) {
		User user = userService.getUserDetails(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
