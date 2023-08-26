package com.Airline.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Airline.Dto.AddScheduleFlightDto;
import com.Airline.Dto.ApiResponse;
import com.Airline.Entities.Flight;

import com.Airline.Entities.ScheduleFlight;
import com.Airline.Repositery.FlightRepositery;
import com.Airline.Repositery.ScheduleFlightRepositery;
import com.Airline.customException.ElementNotFoundException;
import com.Airline.customException.NoFlightFoundException;

@Service
@Transactional
public class ScheduleFlightServiceImpl implements ScheduleFlightService {

	@Autowired
	private ScheduleFlightRepositery scheRepo;

	@Autowired
	private FlightRepositery repo;

	@Autowired
	private ModelMapper mapper;

//	@Autowired
//	private RouteRepository routeRepo;

	@Override
	public ApiResponse insertScheduleFlight(AddScheduleFlightDto dto, Long flightId) {
		Optional<Flight> flight = repo.findById(flightId);
		if (flight.isEmpty()) {
             throw new NoFlightFoundException("no flight found for given id");			
		}
			ScheduleFlight fly = mapper.map(dto, ScheduleFlight.class);
		      flight.get().addScheduledFlight(fly);
			scheRepo.save(fly);
			return new ApiResponse("schedule flight added");

	}
//	public ApiResponse deleteScheduleFlight(Long scheduleFlightId) {
//		 scheRepo.deleteById(scheduleFlightId);
//		return new ApiResponse("schedule flight deleted");
//	}
//	@Override
//	public List<ScheduleFlight> findAllScheduleFlight(Long routeId) {
//		Optional<Route>route=routeRepo.findById(routeId);
//		List<ScheduleFlight>sfList=new ArrayList<ScheduleFlight>();
//		for(ScheduleFlight sf:route.get().getScheduleFlight()) {
//		   if(route.isPresent()) {
//		      sfList.add(sf);	   
//		   }	
//			
//		}
//		return sfList;
//	}
//	@Override
//	public ApiResponse modifyScheduleFlight(Long scheduleFlightId,AddScheduleFlightDto dto) {
//		ScheduleFlight flight=scheRepo.findById(scheduleFlightId).
//				orElseThrow(()-> new ElementNotFoundException("flight not found"));
//		flight.setAvailableSeat(dto.getAvailableSeat());
//		flight.setFare(dto.getFare());
//		flight.setLandingDate(dto.getLandingDate());
//		flight.setLandingTime(dto.getLandingTime());
//		flight.setTakeoffDate(dto.getTakeoffDate());
//		flight.setTakeoffTime(dto.getTakeoffTime());
//		
//		return new ApiResponse(" schedule flight is updated");
//	}

}
