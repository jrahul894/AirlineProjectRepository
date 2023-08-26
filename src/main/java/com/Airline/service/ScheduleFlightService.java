package com.Airline.service;

import java.util.List;

import com.Airline.Dto.AddScheduleFlightDto;
import com.Airline.Dto.ApiResponse;
import com.Airline.Entities.ScheduleFlight;

public interface ScheduleFlightService {
//
	ApiResponse insertScheduleFlight(AddScheduleFlightDto dto, Long flightId);
//
//	ApiResponse deleteScheduleFlight(Long scheduleFlightId);
//
//	List<ScheduleFlight> findAllScheduleFlight(Long routeId);
//
//	ApiResponse modifyScheduleFlight(Long scheduleFlightId, AddScheduleFlightDto dto);

}
