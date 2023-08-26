//package com.Airline.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Airline.Dto.ApiResponse;
//import com.Airline.Dto.passengerDto;
//import com.Airline.Entities.Passenger;
//import com.Airline.service.PassengerService;
//
//
//@RestController
//@RequestMapping("/passenger")
//@CrossOrigin
//public class PassengerController {
//	@Autowired
//	private PassengerService passenger;
//
//   @GetMapping("/all")
//   public List<Passenger> getAllPassenger(){
//		return passenger.showAllPassengers();
//	}
//   
//   @PostMapping("/add")
//   public ResponseEntity<?> AddNewPassenger(@RequestBody @Valid passengerDto p1) {
//	   ApiResponse obj=passenger.AddPassenger(p1);
//	   
//	   if(obj==null) {
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("illegal passenger"));   
//	   }
//	return ResponseEntity.status(HttpStatus.OK).body(obj);
//   }
//}
