package com.app.Controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Dto.ApiResponse;
import com.app.Dto.UserDto;
import com.app.Entities.User;
import com.app.Service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService userservice;
    
	@PostMapping("/register")
	public ApiResponse UserRegistration(@RequestBody @Valid UserDto user) {
		System.out.println("in user Registeration"+user.getFirstName());
		return userservice.AddUser(user);
		
	}
	@GetMapping("{firstName}")
	public User getUserByFirstName(@PathVariable("firstName") String firstname) {
		return userservice.getUser(firstname);
		
	}
	@GetMapping("/")
	public List<User> getAllUsers(){
		return userservice.getAllUsers();
		
	}
	
	@GetMapping("{from}/{to}/{date}")
	public ResponseEntity<?> searchFlight(@PathVariable String from, @PathVariable String to, @PathVariable LocalDate date )
       
       
	
	




}
