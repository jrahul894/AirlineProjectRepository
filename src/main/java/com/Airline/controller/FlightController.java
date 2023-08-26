package com.Airline.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Airline.Dto.AddFlightDto;
import com.Airline.Dto.ApiResponse;
import com.Airline.Entities.Flight;
import com.Airline.service.FlightService;


@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private FlightService flight; // add service layer dependency

	
	@GetMapping("/all")
	public List<Flight> GetAllFlight( // not working
			@RequestParam(value="pageNumber", defaultValue="0", required=false)Integer pageNumber,
			@RequestParam(value="pageNumber", defaultValue="4", required=false)Integer pageSize,
			@RequestParam(value="sortBy", defaultValue="airlineName", required=false)String sortBy,
			@RequestParam(value="", defaultValue="asc", required=false)String sortDir
			) {
		return flight.showAllFlight(pageNumber,pageSize, sortBy, sortDir);
    }
	@PostMapping("/add")
	public ResponseEntity<?> addFlight(@RequestBody @Valid AddFlightDto fly) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(flight.insertFlight(fly));
		
	}
	@PutMapping("/update/{flightId}")
	public ResponseEntity<?> UpdateFlightDetails(@PathVariable Long flightId,@RequestBody AddFlightDto dto) {
		flight.updateFlightDetails(flightId,dto);
		return new ResponseEntity<>("flight updated",HttpStatus.CREATED);
	
	}
	@DeleteMapping("/remove/{flyId}")
	public ApiResponse removedFlight(@PathVariable Long flyId) {
		flight.removeFlight(flyId);
		return new ApiResponse("remove flight"+flyId);
		
	}	
}
