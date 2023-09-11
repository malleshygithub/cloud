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
	String className = this.getClass().getName();

	@PostMapping("/validate2/")
	String validateUserDetailsPost(@RequestBody UserDetails userDet) {
		
		System.out.println(" In User  Validate method ");
		log.info("Enter "+className+"  method validateUserDetailsPost");
		
		System.out.println("  User = "+ userDet.getUsername()+ " Password = "+userDet.getPassword12());
		
		if("user".equalsIgnoreCase(userDet.getUsername())  
				&& "password".equalsIgnoreCase(userDet.getPassword12())){
			log.info("Exit "+className+"  method validateUserDetailsPost");	
			return "{\"message\":\"Login Success\"}";
			} else {
			log.info("Exit "+className+"  method validateUserDetailsPost");
			return "{\"message\":\"Login Failed\"}";
			}
				
		//log.info("Exit "+className+"  method validateUserDetailsPost");
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
		
		log.info("Enter "+className+"  method validateUserDetails");
		
		log.error("UserName "+user+"  Pass  "+pass);
		
		
		log.info("Exit "+className+"  method validateUserDetails");
		return "success";
				
	}
	
	@GetMapping("/validate/")
	String validateUserDetailsPost() {
		
		//System.out.println("  User ,  Pass  "+ userDet.getUsername()+ "  "+userDet.getPassword12());
		log.info("Enter "+className+"  method validateUserDetailsGet");
		//System.out.println(" YES GET");
		return "{\"message\":\"Login Success\"}";		
		
	}
	
	@GetMapping("/user")
	String getUserDetails(@RequestBody UserDetails userDet) {
		log.info("Enter "+className+"  method getUserDetails");
		//System.out.println("  User ,  Pass  "+ userDet.getUsername()+ "  "+userDet.getPassword12());
		return "successPost";
			
	}
}
