package com.app.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.Passenger;

public interface PassengerRepositery extends JpaRepository<Passenger, String> {

	Passenger findPassengerByFlight(String flightId);
}
