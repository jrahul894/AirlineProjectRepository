package com.Airline.service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.Airline.Dto.ApiResponse;
import com.Airline.Dto.BookFlightDto;
import com.Airline.Dto.CredentialDto;
import com.Airline.Dto.PassengerDto;
import com.Airline.Dto.ScheduleFlightResponseDTO;
import com.Airline.Dto.UserDto;
import com.Airline.Entities.Booking;
import com.Airline.Entities.Flight;
import com.Airline.Entities.ScheduleFlight;
import com.Airline.Entities.User;


public interface UserService {

	public ApiResponse createUser(UserDto user);
	
	
//	ApiResponse AddUser(UserDto user);
//	
//	
////	User getUser(String firstName);
//	
//  //  List getAllUsers();
//
//
//	List<Flight> findFlight(String from, String to, LocalDate departureDate);
//
//
//	Optional<Flight> getFlightByFlightId(String id);
//
//
//	List<Flight> getFlightsByAirlineName(String airline);
//
//
	//User userLogin(String email, String password);
//
public ResponseEntity<?> userLogin(String email, String password);


	public ApiResponse flightBooking(BookFlightDto book, Long userId, Long scheduleFlightId);


	public List<ScheduleFlightResponseDTO> findFlight(String departure, String arrival, LocalDate departureDate);


	public ResponseEntity<?> adminLogin(String email, String password);


	public List<User> getAllUsers();


	public ApiResponse modifyUserDetails(UserDto dto, Long userId);


	public ApiResponse removeUser(Long userId);

}
