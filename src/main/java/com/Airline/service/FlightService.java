package com.Airline.service;

import java.util.List;

import com.Airline.Dto.AddFlightDto;
import com.Airline.Dto.ApiResponse;
import com.Airline.Entities.Flight;

public interface FlightService {

	

	ApiResponse insertFlight(AddFlightDto flight);
	
	ApiResponse removeFlight(Long flyId);
	
	List<Flight> showAllFlight(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);

    ApiResponse updateFlightDetails(Long flightId, AddFlightDto flight);

	
	
}
