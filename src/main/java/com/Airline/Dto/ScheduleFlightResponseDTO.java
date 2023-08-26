package com.Airline.Dto;

import java.time.LocalDateTime;

import com.Airline.Entities.Airline;

import lombok.Data;

@Data
public class ScheduleFlightResponseDTO {

	private Long flightId;
	private Airline airlineName;
	private String source;
	private String destination;
	private LocalDateTime departureDate;
	private Integer checkingBaggageCapacity;
	private Integer cabinBaggageCapacity;
	private Double price;

}
