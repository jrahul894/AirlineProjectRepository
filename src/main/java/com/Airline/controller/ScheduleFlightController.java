package com.Airline.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.Airline.Dto.AddScheduleFlightDto;
import com.Airline.Entities.ScheduleFlight;
import com.Airline.service.FlightService;
import com.Airline.service.ScheduleFlightService;

@RestController
@RequestMapping("/flight/schedule")
public class ScheduleFlightController {

	@Autowired
	private ScheduleFlightService flight;
	
	@Autowired
	private FlightService fly;
	
	@PostMapping("/add/{flightId}/")
	public ResponseEntity<?> addScheduleFlight(@RequestBody AddScheduleFlightDto dto,@PathVariable Long flightId 
			){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(flight.insertScheduleFlight(dto,flightId));
	}
//	@DeleteMapping("/remove/{scheduleFlightId}")
//	public ResponseEntity<?> removeScheduleFlight(@PathVariable Long scheduleFlightId){
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(flight.deleteScheduleFlight(scheduleFlightId));
//		
//	}
//	@GetMapping("/all/{routeId}")
//	public List<ScheduleFlight> getAllScheduleFlight(@PathVariable Long routeId){
//		return flight.findAllScheduleFlight(routeId);
//		
//	}
//	
//	@PutMapping("/update/{scheduleFlightId}")
//	public ResponseEntity<?> updateScheduleFlight(@PathVariable Long scheduleFlightId,@RequestBody AddScheduleFlightDto dto ) {
//		flight.modifyScheduleFlight(scheduleFlightId,dto);
//		
//		return new ResponseEntity<>("schedule Flight Updated" ,HttpStatus.CREATED);
//		
//	}
}
