package com.app.Dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {
	@NotBlank(message = "flight id can't be null")
	private String flightId;

	@NotBlank(message = "AirlineName can't be null")
	private String airlineName;

	@Min(value = 50)
	private Integer economyClassSeat;

	@Max(value = 40)
	private Integer businessClassSeat;

	@Min(value = 75)
	private Integer firstClassSeat;

	@Range(min = 15, max = 25)
	private Integer checkingBaggageCapacity;

	@Range(min = 15, max = 25)
	private Integer cabinBaggageCapacity;

	@Range(min = 4000, max = 8000)
	private Double price;

	@NotBlank
	private String scheduledFlight;

}
