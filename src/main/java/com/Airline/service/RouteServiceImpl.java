//package com.Airline.service;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import javax.transaction.Transactional;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.Airline.Dto.AddRouteDto;
//import com.Airline.Dto.ApiResponse;
//import com.Airline.Entities.Flight;
//import com.Airline.Entities.Route;
//import com.Airline.Entities.ScheduleFlight;
//import com.Airline.Repositery.FlightRepositery;
//import com.Airline.Repositery.RouteRepository;
//import com.Airline.Repositery.ScheduleFlightRepositery;
//import com.Airline.customException.ElementNotFoundException;
//
//@Service
//@Transactional
//public class RouteServiceImpl implements RouteService {
//
//	@Autowired
//	private RouteRepository repo;
//
//	@Autowired
//	private ScheduleFlightRepositery flightRepo;
//
//	@Autowired
//	private ModelMapper mapper;
//
//	@Autowired
//	private FlightRepositery flyRepo;
//
//	@Override
//	public ApiResponse insertRoute(AddRouteDto dto) {
//		Route route = mapper.map(dto, Route.class);
//		repo.save(route);
//		return new ApiResponse("route is added");
//	}
//
//	@Override
//	public ApiResponse removeRoute(Long routeId) {
//		Optional<Route> route = repo.findById(routeId);
//		for (ScheduleFlight sf : route.get().getScheduleFlight()) {
//
//			sf.setRouteSchedule(null);
//		}
//
//		repo.delete(route.get());
//
//		return new ApiResponse("Success");
//	}
//
//	@Override
//	public List<Route> findAllRoute(Long flightId) {
//		Optional<Flight> flight = flyRepo.findById(flightId);
//		if (flight.isPresent()) {
//			List<Route> list = new ArrayList<Route>();
//			for (ScheduleFlight sf : flight.get().getScheduledFlight()) {
//				list.add(sf.getRouteSchedule());
//			}
//			return list;
//		} else {
//			return Collections.emptyList();
//		}
//	}
//
//	@Override
//	public ApiResponse modifyRoute(AddRouteDto dto, Long routeId) {
//		Route route=repo.findById(routeId).
//	    orElseThrow(()-> new ElementNotFoundException("route is invalid"));
//		route.setSource(dto.getSource());
//		route.setDestination(dto.getDestination());
//		return new ApiResponse("route updated");
//	}
//
//}
