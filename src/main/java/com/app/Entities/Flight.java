package com.app.Entities;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CustomStringIdGeneratorF")
	@GenericGenerator(name = "CustomStringIdGeneratorF", strategy = "com.app.Entities.CustomStringIdGeneratorF")
	private String flightId;
	private Integer economyClassSeat;
	private Integer businessClassSeat;
	private Integer firstClassSeat;
	private Integer checkingBaggageCapacity;
	private Integer cabinBaggageCapacity;

	@Column(length = 30)
	private String operatingAirlines;
	
	@Column(length = 30)
	private String departureCity;
	
	@Column(length = 30)
	private String arrivalCity;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate departureDate;
	
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime departureTime;
	
	private double fare;

	//private String scheduledFlight;
//    @OneToMany(mappedBy = "flight",  cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
//    private List<Passenger> passengers;

	
//	// helper method
//	public void AddPassenger(Passenger p1) {
//        passengers.add(p1);
//        p1.setFlight(this);
//        
//	}
//
//	public void RemovePassenger(Passenger p1) {
//		   passengers.remove(p1);
//		   p1.setFlight(null);
//	}
	@OneToMany(mappedBy = "flight")
	private List<Price>priceList;
	
	@OneToMany(mappedBy = "flightschedule")
	private List<ScheduleFlight>scheduledFlight;
}
