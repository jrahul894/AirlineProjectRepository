package com.Airline.Dto;

import org.hibernate.validator.constraints.Range;

import com.Airline.Entities.Airline;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
public class AddFlightDto {
 //   private String flightId;
	private Airline operatingAirline;
    
    @Range(min = 0,max = 8)
	private Integer checkingBaggageCapacity;
    @Range(min = 0,max = 15)
	private Integer cabinBaggageCapacity;

}
