package com.taskmanagement.taskmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.taskmanagement.entities.User;

import com.taskmanagement.taskmanagement.services.UserService;


@RestController
public class UserController {
	

	 private final UserService userService;
	   @Autowired
	    public UserController(UserService userService) {
	        this.userService = userService;
	    }
	
	@GetMapping("/home")
	public String home() {
		return "welcome";
	}

	
	 @PostMapping("/addUser")
	    public ResponseEntity<User> createUser(@RequestBody User user) {
	        User createdUser = userService.createUser(user);
	        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	    }
	 
		@GetMapping("/users")
	 public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }	
}
