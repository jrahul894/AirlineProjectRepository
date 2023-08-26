package com.Airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Airline.Entities.User;
import com.Airline.service.AdminService;
import com.Airline.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@Autowired
	private UserService user;
	
	@GetMapping("/user/all")
	public ResponseEntity<?> getAllUser(){  // not working
		return ResponseEntity.status(HttpStatus.CREATED).body(user.getAllUsers());
	}
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId){
		user.removeUser(userId);
		return new ResponseEntity<>("user deleted",HttpStatus.BAD_REQUEST);
		
	}
}
