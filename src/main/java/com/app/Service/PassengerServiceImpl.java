package com.app.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dto.ApiResponse;
import com.app.Dto.passengerDto;
import com.app.Entities.Passenger;
import com.app.Repositery.FlightRepositery;
import com.app.Repositery.PassengerRepositery;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
	@Autowired
	private PassengerRepositery passengerRepo;
	@Autowired
	private FlightRepositery flightRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public ApiResponse AddPassenger(passengerDto p1) {
		Passenger p=modelMapper.map(p1, Passenger.class);
   //  Passenger pass=passengerRepo.findById(p1.getPassengerId()).orElseThrow(()-> new RuntimeException("passenger not found"));
		  passengerRepo.save(p);
	   return new ApiResponse("passenger"+p.getPassengerFirstName()+p.getPassengerLastName()+"is added");
	}
	@Override
	public List<Passenger> showAllPassengers() {
          System.out.println("show All passengers");
		return passengerRepo.findAll();
	}
//	@Override
//	public String cancelFlight(String flight, String passenger) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public String UpdateAadharNo(String Aadhar) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
}
