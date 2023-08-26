package com.Airline.Repositery;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Airline.Entities.ScheduleFlight;

public interface ScheduleFlightRepositery extends JpaRepository<ScheduleFlight, Long> {

//	List<ScheduleFlight> findByRouteSchedule(Route route);
	List<ScheduleFlight>findBySourceAndDestinationAndTakeoffDateTime(String from,String to,LocalDateTime takeOffTime);
}
