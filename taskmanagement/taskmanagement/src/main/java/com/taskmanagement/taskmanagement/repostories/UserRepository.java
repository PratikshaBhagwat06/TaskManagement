package com.taskmanagement.taskmanagement.repostories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskmanagement.taskmanagement.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	   User findByEmail(String email);
}
