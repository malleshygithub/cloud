package com.demo.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdetails")
public class UserEntity {

    
    @Id
    private String username;
    private String password12;
	
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
    
    

    //getter setters
    
}
