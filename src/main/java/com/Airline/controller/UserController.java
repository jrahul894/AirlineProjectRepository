package com.Airline.controller;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Airline.Dto.ApiResponse;
import com.Airline.Dto.BookFlightDto;
import com.Airline.Dto.PassengerDto;
import com.Airline.Dto.UserDto;
import com.Airline.Entities.Booking;
import com.Airline.Entities.Flight;
import com.Airline.Entities.ScheduleFlight;
import com.Airline.service.BookingService;
import com.Airline.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController{
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookingService book;
	
	@PostMapping("/register")
	public ResponseEntity<?> userRegistration(@RequestBody @Valid UserDto user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> userSingIn(
			@RequestParam("email") String email,
			@RequestParam("password") String password){
		return userService.userLogin(email, password);
		
	}
	@PostMapping("/flight/book/{userId}/{scheduleFlightId}") //not working
	public ResponseEntity<?> bookFlight(@RequestBody BookFlightDto book, @PathVariable Long userId,@PathVariable Long scheduleFlightId){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.flightBooking(book,userId,scheduleFlightId));
		
	}
	@GetMapping("/searchflight") // not working
	public List<ScheduleFlight> searchFlights(
			@RequestParam String departure,
			@RequestParam String arrival,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate ){
		return userService.findFlight(departure,arrival,departureDate);
		
	}
	@GetMapping("/allBookings")
	public List<Booking>getAllBookings(){
		return null;
		
	}
	@GetMapping("/admin/signIn/{email}/{password}")
	public ResponseEntity<?> adminSingIn(@PathVariable String email,@PathVariable String password) {
		return ResponseEntity.ok(userService.adminLogin(email,password));
	}
	@PutMapping("/update/{userId}")
	public ResponseEntity<?> updateUserDetails(@PathVariable Long userId,@RequestBody UserDto dto ){
		userService.modifyUserDetails(dto,userId);
		return new ResponseEntity<>("user details modified",HttpStatus.CREATED);
		
	}
}