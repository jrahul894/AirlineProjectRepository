package com.Airline;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirlineReservationSystemMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineReservationSystemMainApplication.class, args);
	}
	
	@Bean // equivalent to bean tag <bean id ..../> in xml file
	public ModelMapper mapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
		// mapping source Property type and name with dto prop and name
	}

}
