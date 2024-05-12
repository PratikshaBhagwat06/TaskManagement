package com.taskmanagement.taskmanagement.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.taskmanagement.taskmanagement.entities.User;

@Service
public interface UserService {

	public User createUser(User user);

	public List<User> getAllUsers();

}
