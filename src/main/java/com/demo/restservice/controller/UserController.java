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

import com.demo.restservice.entity.UserEntity;
import com.demo.restservice.model.UserDetails;
import com.demo.restservice.repository.UserRepository;

@RestController
//@CrossOrigin("http://localhost:4200")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
    private UserRepository userRepository;
	
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

	@GetMapping("/save/{user}/{pass}")
	String validateUserDetails(@PathVariable String user,@PathVariable String pass) {
		
		System.out.println("  User ,  Pass"+ user +" "+ pass);

		UserEntity user = new UserEntity();
		user.setUsername(user);
		user.setPassword12(pass);
        	userRepository.save(user);
        	return user;
		
		
		
	}
	
	@GetMapping("/user")
	String getUserDetails(@RequestBody UserDetails userDet) {
		
	System.out.println("  User ,  Pass  "+ userDet.getUsername()+ "  "+userDet.getPassword12());
		
		return "successPost";
		
		
	}

	@GetMapping("/saveuser")
        public UserEntity get() {
        	UserEntity user = new UserEntity();
		user.setUsername("user");
		user.setPassword12("password");
        	userRepository.save(user);
        	return user;
        }
	
	@GetMapping(path = "/user/{user}")
    public @ResponseBody UserEntity getUser(@PathVariable String user) {
        try {
        	System.out.println("here "+user);
			return userRepository.findByUsername(user);
        	//return userRepository.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new UserEntity();
    }

	@PostMapping(path = "/validateuser")
    public  String validateUser(@RequestBody UserDetails userDet) {
        try {
        	System.out.println("here "+userDet.getUsername());
        
        	
        	UserEntity ue = userRepository.findByUsername(userDet.getUsername());
        	
        	
        	System.out.println("Success Response");
        	if(null != ue)
			  return ( ue.getUsername().equals(userDet.getUsername() )  &&
					ue.getPassword12().equals(userDet.getPassword12() )  
					?  "{\"message\":\"Login Success\"}" : "{\"Login Failure\"}");
		
			
			
        	//return userRepository.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Login Failed";
    }

	

}
