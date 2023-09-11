package com.demo.restservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.demo.restservice.model.UserDetails;


@RestController
//@CrossOrigin("http://localhost:4200")
@CrossOrigin("*")
public class UserController {

	Logger log = LoggerFactory.getLogger(UserController.class);

	@PostMapping("/validate2/")
	String validateUserDetailsPost(@RequestBody UserDetails userDet) {
		
		System.out.println(" In User  Validate method ");
		
		System.out.println("  User = "+ userDet.getUsername()+ " Password = "+userDet.getPassword12());
		
		if("user".equalsIgnoreCase(userDet.getUsername())  
				&& "password".equalsIgnoreCase(userDet.getPassword12()))
			return "{\"message\":\"Login Success\"}";
		else
			return "{\"message\":\"Login Failed\"}";
				
	}

	@GetMapping("/loglevel")
	public void logLevelDisplay () {
    	log.error("Error message");
    	log.warn("Warning message");
     	log.info("Info message");
    	log.debug("Debug message");
    	log.trace("Trace message");
    }
	
	@GetMapping("/validate/{user}/{pass}")
	String validateUserDetails(@PathVariable String user,@PathVariable String pass) {
		
		log.info("UserName "+user+"  Pass  "+pass);
		System.out.println("  User ,  Pass"+ user + pass);
		
		return "success";
				
	}
	
	@GetMapping("/validate/")
	String validateUserDetailsPost() {
		
		//System.out.println("  User ,  Pass  "+ userDet.getUsername()+ "  "+userDet.getPassword12());
		System.out.println(" YES GET");
		return "{\"message\":\"Login Success\"}";		
		
	}
	
	@GetMapping("/user")
	String getUserDetails(@RequestBody UserDetails userDet) {
		
	System.out.println("  User ,  Pass  "+ userDet.getUsername()+ "  "+userDet.getPassword12());
	return "successPost";
			
	}
}
