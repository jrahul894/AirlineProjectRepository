package com.Airline.Dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class BookFlightDto {
	private List<PassengerDto> passengers;
	
	private String bookingId;
	private String bookingStatus;

	private Integer seatNo;

	private Double totalAmount;
}
