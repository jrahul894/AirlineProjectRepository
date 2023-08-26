package com.Airline.Repositery;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Airline.Dto.ApiResponse;
import com.Airline.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
//
////	Optional<String> UserRegistration(UserDto user);
//	
//	User findUserByFirstName(String firstname);
//	
//	
//	@Query("select f from Flight f where f.departureCity=:departureCity and f.arrivalCity=:arrivalCity and f.departureDate=:dateOfDeparture")
//	List<Flight> findFlights(@Param("departureCity") String from,@Param("arrivalCity") String to, @Param("dateOfDeparture") LocalDate departureDate);


	//List<Flight> findAllByOperatingAirline(String airline);
	 Optional<User> findByEmail(String email);
     User findByEmailAndPassword(String email,String password);
     
     
	
}
