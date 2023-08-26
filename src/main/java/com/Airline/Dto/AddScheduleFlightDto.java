package com.Airline.Dto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
public class AddScheduleFlightDto {
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime takeoffDateTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime landingDateTime;
	
	private String source;
	
	private String destination;

//	@Temporal(TemporalType.TIME)
//  private Date takeoffTime;
//
//	@Temporal(TemporalType.TIME)
//  private Date landingTime;

	private Integer availableSeat;

	private Double fare;
}
