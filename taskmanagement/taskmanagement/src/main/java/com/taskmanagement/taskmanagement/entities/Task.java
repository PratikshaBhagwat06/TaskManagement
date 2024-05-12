package com.taskmanagement.taskmanagement.entities;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Task {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime assignedDateTime;
    private LocalDateTime expectedCompletionDateTime;

   
    private Long assigner;
    

   
    private Long assignee; 
    //getter setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getAssignedDateTime() {
		return assignedDateTime;
	}

	public void setAssignedDateTime(LocalDateTime assignedDateTime) {
		this.assignedDateTime = assignedDateTime;
	}

	public LocalDateTime getExpectedCompletionDateTime() {
		return expectedCompletionDateTime;
	}

	public void setExpectedCompletionDateTime(LocalDateTime expectedCompletionDateTime) {
		this.expectedCompletionDateTime = expectedCompletionDateTime;
	}

	public Long getAssigner() {
		return assigner;
	}

	public void setAssigner(Long assigner) {
		this.assigner = assigner;
	}

	public Long getAssignee() {
		return assignee;
	}

	public void setAssignee(Long assignee) {
		this.assignee = assignee;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", assignedDateTime=" + assignedDateTime
				+ ", expectedCompletionDateTime=" + expectedCompletionDateTime + ", assigner=" + assigner
				+ ", assignee=" + assignee + "]";
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(Long id, String description, LocalDateTime assignedDateTime, LocalDateTime expectedCompletionDateTime,
			Long assigner, Long assignee) {
		super();
		this.id = id;
		this.description = description;
		this.assignedDateTime = assignedDateTime;
		this.expectedCompletionDateTime = expectedCompletionDateTime;
		this.assigner = assigner;
		this.assignee = assignee;
	}


 
}
