package com.app.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Dto.FlightDto;
import com.app.Entities.Flight;
import com.app.Service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private FlightService flight; // add service layer dependency

	
	@GetMapping("/all")
	public List<Flight> GetAllFlight(
			@RequestParam(value="pageNumber", defaultValue="0", required=false)Integer pageNumber,
			@RequestParam(value="pageNumber", defaultValue="4", required=false)Integer pageSize,
			@RequestParam(value="sortBy", defaultValue="airlineName", required=false)String sortBy,
			@RequestParam(value="", defaultValue="asc", required=false)String sortDir
			) {
		return flight.showAllFlight(pageNumber,pageSize, sortBy, sortDir);
    }
	@PostMapping("/addflight")
	public Flight AddFlight(@RequestBody @Valid FlightDto fly) {
		return flight.addFlight(fly);
		
	}
	@PutMapping("/{id}/Airline/{airlineName}")
	public Flight UpdateFlightDetails(@PathVariable String id,@PathVariable String airlineName,FlightDto fly) {
		Flight fly1=flight.updateFlightDetails(fly);
		return fly1;
	
	}
	@DeleteMapping("{flyId}")
	public String removedFlight(@PathVariable String flyId) {
		flight.removeFlight(flyId);
		return "remove flight"+flyId;
		
	}
	@GetMapping("Id/{id}")
	public Optional<Flight> findFlightById(@PathVariable String id) {
		return flight.getFlightByFlightId(id);
		
	}
	@GetMapping("Airline/{Airline}")
	public List<Flight> findFlightByAirlineName(@PathVariable String Airline){
		return flight.getFlightsByAirlineName(Airline);
		
	}
}
