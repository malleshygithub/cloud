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

import com.demo.restservice.model.UserDetails;


@RestController
//@CrossOrigin("http://localhost:4200")
@CrossOrigin("*")
public class UserController {
	

	
	@GetMapping("/validate/{user}/{pass}")
	String validateUserDetails(@PathVariable String user,@PathVariable String pass) {
		
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
