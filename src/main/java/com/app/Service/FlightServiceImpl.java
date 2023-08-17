package com.app.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.Dto.FlightDto;
import com.app.Entities.Flight;
import com.app.Repositery.FlightRepositery;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightRepositery flightRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<Flight> showAllFlight(Integer pageNumber, Integer pageSize,String sortBy,String sortDir) {
		Sort sort=(sortDir.equalsIgnoreCase("asc"))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		PageRequest p=PageRequest.of(pageNumber,pageSize,sort);
	    Page<Flight> pageFlight=this.flightRepo.findAll(p);
		List<Flight>allFlight=pageFlight.getContent();
		return allFlight;
	}



	@Override
	public Flight addFlight(FlightDto flight) {
		Flight newFlight = modelMapper.map(flight, Flight.class);
		return flightRepo.save(newFlight);
	}

	@Override
	public String removeFlight(String flightId) {
          System.out.println("remove flight "+flightId);
         // Optional<Flight>  fly=flightRepo.findFlightByFlightId(flightId);
           flightRepo.deleteById(flightId);
		return " Remove flight "+flightId;
	}

	@Override
	public Flight updateFlightDetails(FlightDto flight) {
		 
		Flight fly=modelMapper.map(flight, Flight.class);
		fly.setAirlineName(flight.getAirlineName()); 
//          fly.setBusinessClassSeat(fly.getBusinessClassSeat());
//          fly.setCabinBaggageCapacity(fly.getCabinBaggageCapacity());
//          fly.setCheckingBaggageCapacity(fly.getCheckingBaggageCapacity());
//          fly.setEconomyClassSeat(fly.getEconomyClassSeat());
//          fly.setFirstClassSeat(fly.getFirstClassSeat());
          
		return fly;
	}


	@Override
	public Optional<Flight> getFlightByFlightId(String id) {
		  Optional<Flight> newFlight=flightRepo.findById(id);
		return newFlight;
	}


	@Override
	public List<Flight> getFlightsByAirlineName(String Airline) {
         List<Flight>lstfly=flightRepo.findAllByAirlineName(Airline);
		return lstfly;
	}




}
