package com.Airline.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Airline.Dto.ApiResponse;
import com.Airline.Dto.BookFlightDto;
import com.Airline.Dto.ScheduleFlightResponseDTO;
import com.Airline.Dto.UserDto;
import com.Airline.Entities.Booking;
import com.Airline.Entities.Passenger;

import com.Airline.Entities.ScheduleFlight;
import com.Airline.Entities.User;
import com.Airline.Repositery.BookingRepository;
import com.Airline.Repositery.FlightRepositery;

import com.Airline.Repositery.ScheduleFlightRepositery;
import com.Airline.Repositery.UserRepository;
import com.Airline.customException.ElementNotFoundException;
import com.Airline.customException.UserAlreadyExistsException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private BookingRepository bookRepo;

	@Autowired
	private FlightRepositery flightRepo;

//	@Autowired
//	private RouteRepository routeRepo;

	@Autowired
	private ScheduleFlightRepositery sfRepo;

	@Override
	public ApiResponse createUser(UserDto userDto) {
		Optional<User>u=userRepo.findByEmail(userDto.getEmail());
		if(u.isPresent()) {
			throw new UserAlreadyExistsException("user is already present");
		}
		
		User user=mapper.map(userDto, User.class);
		userRepo.save(user);
		return new ApiResponse(  user.getFirstName() + " created successfully");
	}

	// List<User> list= new ArrayList<User>();

////	public UserServiceImpl() {
////          list.add(new User("U001","Rahul","Jain","rjain17609@gmail.com","1234","7023666199","user",LocalDate.parse("1997-08-13")));
////          list.add(new User("U002","pankaj","chhipa","pankajchippa1997@gmail.com","1234","8562820638","user",LocalDate.parse("1997-11-08")));

////	}
//	//get all user
////	public List getAllUsers(){
////	 return repo.findAll();
////		
////		
////	}
//	
//	
////	public User getUser(String firstName) {
////		
////		//return this.list.stream().filter((User)->User.getFirstName().equals(firstName)).findAny().get();
////	return repo.findUserByFirstName(firstName);
////	
////	}
//
//
	@Override
	public List<ScheduleFlightResponseDTO> findFlight(String from, String to, LocalDateTime departureDate) {

		List<ScheduleFlightResponseDTO> flights = new ArrayList<>();
         List<ScheduleFlight>sfList=sfRepo.findBySourceAndDestinationAndTakeoffDateTime(from, to, departureDate);
		for (ScheduleFlight sf : sfList) {
		//	if (sf.getTakeoffDate().equals(departureDate)) {
				System.out.println(sf);
				ScheduleFlightResponseDTO flightData = new ScheduleFlightResponseDTO();
//			System.out.println(sf.getAircraft().getOperatingAirline());
//				System.out.println(Airline.valueOf("INDIGO"));
				flightData.setAirlineName(sf.getAircraft().getOperatingAirline());
				flightData.setDestination(sf.getDestination());
				flightData.setSource(sf.getSource());
				flightData.setFlightId(sf.getId());
				flightData.setPrice(sf.getFare());
				flightData.s
				flightData.setCabinBaggageCapacity(sf.getAircraft().getCabinBaggageCapacity());
				flightData.setCheckingBaggageCapacity(sf.getAircraft().getCheckingBaggageCapacity());
				flights.add(flightData);
			//}
		}
		return flights;

	}

//
//
//	@Override
//	public Optional<Flight> getFlightByFlightId(String id) {
//		  Optional<Flight> newFlight=flyRepo.findById(id);
//		return newFlight;
//	}
//
//
//	@Override
//	public List<Flight> getFlightsByAirlineName(String Airline) {
//         List<Flight>lstfly=flyRepo.findAllByOperatingAirline(Airline);
//		return lstfly;
//	}
//
	@Override
	public ResponseEntity<?> userLogin(String email, String password) {

		Optional<User> user = userRepo.findByEmail(email);

		if (user.isPresent()) {
			if ((user.get().getPassword()).equals(password)) {// email.equals(admin) && password.equals(admin)

				return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Log in Successful"));
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Password is incorrect"));

			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Invalid user"));

		}

	}

//	@Override
//	public ApiResponse flightBooking(BookFlightDto booking, Long userId, Long scheduleFlightId) {
//		Booking book = mapper.map(booking, Booking.class);
//		Passenger passenger = mapper.map(booking, Passenger.class);
//
//		// List<Passenger>list=new ArrayList<Passenger>();
//		List<Passenger> list = book.getPassenger();
//		Optional<User> user = userRepo.findById(userId);
//		Optional<ScheduleFlight> scheduleFlight = sfRepo.findById(scheduleFlightId);
//		if (user.isPresent() && scheduleFlight.isPresent()) {
//			book.addPassenger(passenger);
//			user.get().addBooking(book);
//			scheduleFlight.get().addBooking(book);
//
//			return new ApiResponse("user successfully book flight");
//		}
//		bookRepo.save(book);
//
//		return new ApiResponse("Invalid booking");
//	}

	@Override
	public ResponseEntity<?> adminLogin(String email, String password) {
		User admin = userRepo.findByEmailAndPassword(email, password);
		if (admin.getPassword().equals("Admin@12") && admin.getEmail().equals("admin@gmail.com")) {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("admin Login successful"));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("admin not found "));
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> list = userRepo.findAll();
		System.out.println(list);
		return list;
	}

	@Override
	public ApiResponse modifyUserDetails(UserDto dto, Long userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ElementNotFoundException("user not found"));
		user.setEmail(dto.getEmail());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setPassword(dto.getPassword());
		user.setPhoneNo(dto.getPhoneNo());
		user.setRole(dto.getRole());

		return new ApiResponse("user detail is updated");
	}

	@Override
	public ApiResponse removeUser(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ElementNotFoundException("user not found"));
		System.out.println(user);
		user.removeBooking(null);
		userRepo.deleteById(userId);
		return new ApiResponse("user is deleted");
	}

	@Override
	public ApiResponse flightBooking(BookFlightDto book, Long userId, Long scheduleFlightId) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<ScheduleFlight> findFlight(String departure, String arrival, LocalDate departureDate) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
