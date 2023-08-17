package com.app.Service;

import java.util.List;
import java.util.Optional;

import com.app.Dto.FlightDto;
import com.app.Entities.Flight;

public interface FlightService {

	

	Flight addFlight(FlightDto flight);

	
	
	Flight updateFlightDetails(FlightDto flight);
	
	String removeFlight(String flightId);
	
     Optional<Flight> getFlightByFlightId(String id);
	
//	List<Flight>getFlightsByAirlineName(String Airline);

	List<Flight> getFlightsByAirlineName(String airline);

	List<Flight> showAllFlight(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);
	
	
}
