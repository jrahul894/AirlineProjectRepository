package com.Airline.service;

import com.Airline.Dto.BookFlightDto;
import com.Airline.Entities.Booking;

public interface BookingService {

	Booking addFlightBooking(BookFlightDto dto);

}
