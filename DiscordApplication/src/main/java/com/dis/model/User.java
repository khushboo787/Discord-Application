package com.dis.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class User {
             
	@NotNull(message ="userId is mandatory")
	private int userId;
	
	@NotBlank(message ="username is mandatory")
	private String username;
	
	
	private String tag;	
	
	
	public User() {
	
	}		
	
	
	public User(int userId, String username, String tag) {
		this.userId = userId;
		this.username = username;
		this.tag = tag;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
	  
	
	
}
