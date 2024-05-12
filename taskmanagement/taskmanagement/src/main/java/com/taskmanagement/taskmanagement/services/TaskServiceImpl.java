package com.taskmanagement.taskmanagement.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanagement.taskmanagement.entities.Task;
import com.taskmanagement.taskmanagement.repostories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	 private final TaskRepository taskRepository;

	 @Autowired
	    public TaskServiceImpl(TaskRepository taskRepository) {
	        this.taskRepository = taskRepository;
	    }
	 
//      @Override
//	    public List<Task> getAllTasks() {
//	        return taskRepository.findAll();
//	    

	 public List<Object[]> getAllTasks() {
	        return taskRepository.findAllTasks();
	    }
	 
	 
	 
	 
	
      @Override
      public Task createTask(Task task) {
          return taskRepository.save(task);
      }

      @Override
      public Task updateTask(Long id, Task task) {
          if (taskRepository.existsById(id)) {
              task.setId(id);
              return taskRepository.save(task);
          } else {
              return null; // Handle this case based on your application's requirements
          }
      }
      
      @Override
      public void deleteTask(Long id) {
          taskRepository.deleteById(id);
      }
      
      @Override
      public Task getTaskById(Long id) {
          return taskRepository.findById(id).orElse(null);
      }
}
