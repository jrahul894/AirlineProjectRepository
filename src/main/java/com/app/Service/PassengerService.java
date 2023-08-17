package com.app.Service;

import java.util.List;

import com.app.Dto.ApiResponse;
import com.app.Dto.passengerDto;
import com.app.Entities.Passenger;

public interface PassengerService {

	ApiResponse AddPassenger(passengerDto p1);
	// show all passenger or show All passenger of particular flight
	List<Passenger> showAllPassengers();
	
	//String cancelFlight(String flight,String passenger);
	//	
	//String UpdateAadharNo(String Aadhar);
}
