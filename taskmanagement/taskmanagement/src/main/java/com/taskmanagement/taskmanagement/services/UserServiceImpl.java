package com.taskmanagement.taskmanagement.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanagement.taskmanagement.entities.User;
import com.taskmanagement.taskmanagement.repostories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	 private final UserRepository userRepository;

	 @Autowired
	    public UserServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	 
	 @Override
	  public User createUser(User user) {
	        String encodedPassword = encodePassword(user.getPassword());
	        user.setPassword(encodedPassword);
	        // Save the user to the repository
	        return userRepository.save(user);
	    }
	 
	 public static String encodePassword(String password) {
		  return BCrypt.hashpw(password, BCrypt.gensalt());
	    }
//     public User createUser(User user) {
//         return userRepository.save(user);
//     }

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


}
