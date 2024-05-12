package com.taskmanagement.taskmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
	private String name;
    private String mobileNumber;
    private String gender;
    private String role;
    private String email;
    private String password;


    public Long getId() {
  		return id;
  	}
  	public void setId(Long id) {
  		this.id = id;
  	}
  	public String getName() {
  		return name;
  	}
  	public void setName(String name) {
  		this.name = name;
  	}
  	public String getMobileNumber() {
  		return mobileNumber;
  	}
  	public void setMobileNumber(String mobileNumber) {
  		this.mobileNumber = mobileNumber;
  	}
  	public String getGender() {
  		return gender;
  	}
  	public void setGender(String gender) {
  		this.gender = gender;
  	}
  	public String getRole() {
  		return role;
  	}
  	public void setRole(String role) {
  		this.role = role;
  	}
  	public String getEmail() {
  		return email;
  	}
  	public void setEmail(String email) {
  		this.email = email;
  	}
  	
  	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long id, String name, String mobileNumber, String gender, String role, String email,String password) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.role = role;
		this.email = email;
		this.password=password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", gender=" + gender + ", role="
				+ role + ", email=" + email + " ,password="+password+"]";
	}
  	
  	

}
