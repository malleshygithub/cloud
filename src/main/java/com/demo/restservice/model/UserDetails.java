package com.demo.restservice.model;

import org.springframework.stereotype.Component;

@Component
public class UserDetails {
	
	String username;
	String password12;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword12() {
		return password12;
	}
	public void setPassword12(String password12) {
		this.password12 = password12;
	}
	
	
	
	

}
