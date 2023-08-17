package com.app.Repositery;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.Entities.Flight;

public interface FlightRepositery extends JpaRepository<Flight, String> {

	
//	Optional<Flight>findFlightByAirlineName(String Airline);
	
	Optional<Flight>findFlightByFlightId(String Id);

	List<Flight> findAllByAirlineName(String airline);
}
