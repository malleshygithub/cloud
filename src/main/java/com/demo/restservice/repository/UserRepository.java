package com.demo.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.restservice.entity.UserEntity;
import com.demo.restservice.model.UserDetails;

	@Repository
	public interface UserRepository extends JpaRepository< UserEntity, String > {
	    public UserEntity findByUsername(String username);
	}


