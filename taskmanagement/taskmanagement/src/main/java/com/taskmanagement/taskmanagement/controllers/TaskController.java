package com.taskmanagement.taskmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.taskmanagement.entities.Task;
import com.taskmanagement.taskmanagement.services.TaskService;

@RestController
public class TaskController {
	
	 private final TaskService taskService;
	   @Autowired
	    public TaskController(TaskService taskService) {
	        this.taskService = taskService;
	    }
	
//	@GetMapping("/tasks")
//	 public ResponseEntity<List<Task>> getAllTasks() {
//        List<Task> tasks = taskService.getAllTasks();
//        return ResponseEntity.ok(tasks);
//    }	
//	
	   @GetMapping("/tasks")
	    public ResponseEntity<List<Object[]>> getAllTasksWithAssignerAndAssigneeNames() {
	        List<Object[]> tasksWithNames = taskService.getAllTasks();
	        return ResponseEntity.ok(tasksWithNames);
	    }
	   
	 @PostMapping("/addtask")
	    public ResponseEntity<Task> createTask(@RequestBody Task task) {
	        Task createdTask = taskService.createTask(task);
	        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
	    }
	 
	   @PutMapping("updatetask/{id}")
	    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
	        Task updatedTask = taskService.updateTask(id, task);
	        return ResponseEntity.ok(updatedTask);
	    }
	   
	   @DeleteMapping("/deletetask/{id}")
	    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
	        taskService.deleteTask(id);
	        return ResponseEntity.noContent().build();
	    }
	 
	   @GetMapping("/gettask/{id}")
	    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
	        Task task = taskService.getTaskById(id);
	        return ResponseEntity.ok(task);
	    }


}
