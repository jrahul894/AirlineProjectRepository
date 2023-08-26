package com.Airline.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Airline.Dto.AddFlightDto;
import com.Airline.Dto.ApiResponse;
import com.Airline.Entities.Flight;
import com.Airline.Entities.ScheduleFlight;
import com.Airline.Repositery.FlightRepositery;
import com.Airline.Repositery.ScheduleFlightRepositery;
import com.Airline.customException.ElementNotFoundException;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightRepositery flightRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ScheduleFlightRepositery sfRepo;

	@Override
	public List<Flight> showAllFlight(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		PageRequest p = PageRequest.of(pageNumber, pageSize, sort);
		Page<Flight> pageFlight = this.flightRepo.findAll(p);
		List<Flight> allFlight = pageFlight.getContent();
		return allFlight;
	}

	@Override
	public ApiResponse insertFlight(AddFlightDto flight) {
		Flight newFlight = modelMapper.map(flight, Flight.class);
		flightRepo.save(newFlight);
		return new ApiResponse(newFlight.getId() + " added sussfully");
	}

	@Override
	public ApiResponse removeFlight(Long flightId) {
		System.out.println("remove flight " + flightId);
		Optional<Flight> fly = flightRepo.findById(flightId);
	//	Optional<ScheduleFlight>scheduleFlight=sfRepo.findById(scheduleFlightId);
		for (ScheduleFlight sf:fly.get().getScheduledFlight()) {
            sf.setAircraft(null);
            flightRepo.deleteById(flightId);
			return new ApiResponse(" Remove flight " + flightId);

		}
		return new ApiResponse("Invalid flight");

	}

	@Override
	public ApiResponse updateFlightDetails(Long flightId,AddFlightDto flight) {
		 Flight fly=flightRepo.findById(flightId).
	orElseThrow(()-> new ElementNotFoundException("flight is invalid"));
		fly.setOperatingAirline(flight.getOperatingAirline()); 
      //    fly.setBusinessClassSeat(fly.getBusinessClassSeat());
         fly.setCabinBaggageCapacity(fly.getCabinBaggageCapacity());
         fly.setCheckingBaggageCapacity(fly.getCheckingBaggageCapacity());
    //     fly.setEconomyClassSeat(fly.getEconomyClassSeat());
    //      fly.setFirstClassSeat(fly.getFirstClassSeat());
          
		return new ApiResponse("flight is updated");
	}

}
