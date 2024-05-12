package com.taskmanagement.taskmanagement.repostories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taskmanagement.taskmanagement.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	 @Query("SELECT t, u1.name, u2.name " +
	           "FROM Task t " +
	           "JOIN User u1 ON t.assigner = u1.id " +
	           "JOIN User u2 ON t.assignee = u2.id")
	    List<Object[]> findAllTasks();

}
