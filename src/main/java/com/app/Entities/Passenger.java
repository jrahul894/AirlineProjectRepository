package com.app.Entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Passenger	 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "customStringIdGeneratorP")
	@GenericGenerator(name = "customStringIdGeneratorP", strategy = "com.app.Entities.CustomStringIdGeneratorP")
    private String passengerId;

	private String passengerFirstName;

	private String passengerLastName;

	private Integer passengerAge;
	@Column(name = "date_of_birth")
	private LocalDate passengerDOB;
	@Column(name = "aadhar_no",unique=true,length=20)
	private String aadharNo;
	@Column(name="Email_id",unique=true,length=20)
	private String email;

	private String phoneNo;
//	@OneToOne
//	private Booking bookings;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="flight_id")
	private Flight flight;
	
//	public void AddFlight(Flight f1) {
//		
//	}
//	public void RemoveFlight(Flight f1) {
//		flight.
//	}
	
	@OneToMany(mappedBy = "passenger")
	private List<Booking>bookings;

	


}
