package com.Airline.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Airline.Entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
