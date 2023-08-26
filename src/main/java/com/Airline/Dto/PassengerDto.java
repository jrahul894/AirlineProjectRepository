package com.Airline.Dto;

import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.Airline.Entities.Flight;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PassengerDto {
//@NotEmpty	
//private String passengerId;
	private String passengerName;
	private Integer passengerAge;
	private String aadharNo;
	private String email;
	private String phoneNo;
	
}
