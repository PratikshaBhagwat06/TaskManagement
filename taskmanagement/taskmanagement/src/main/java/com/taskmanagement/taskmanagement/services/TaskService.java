package com.taskmanagement.taskmanagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taskmanagement.taskmanagement.entities.Task;

@Service
public interface TaskService {
	public List<Object[]> getAllTasks();
	  public Task createTask(Task task);
	Task updateTask(Long id, Task task);
	public void deleteTask(Long id);
	 public Task getTaskById(Long id);

}