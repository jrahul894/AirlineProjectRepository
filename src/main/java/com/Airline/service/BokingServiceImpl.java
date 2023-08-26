package com.Airline.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.Airline.Dto.BookFlightDto;
import com.Airline.Entities.Booking;
@Service
@Transactional
public class BokingServiceImpl implements BookingService {

	@Override
	public Booking addFlightBooking(BookFlightDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
