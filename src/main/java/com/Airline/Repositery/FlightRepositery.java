package com.Airline.Repositery;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Airline.Entities.Flight;

public interface FlightRepositery extends JpaRepository<Flight, Long> {



	List<Flight> findAllByOperatingAirline(String Airline);
	
	
}
