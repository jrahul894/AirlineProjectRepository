package com.Airline.Entities;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.repository.query.parser.Part.IgnoreCaseType;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "scheduleflight")
public class ScheduleFlight extends BaseEntity{

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Id
//	private Integer scheduleFlightId; // pk

	@ManyToOne
	@JoinColumn(name = "flight_id")
	private Flight aircraft;

//	@ManyToOne
//	@JoinColumn(name = "route_id")
//	private Route routeSchedule;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime takeoffDateTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime landingDateTime;
	
	private String source;
	
	private String destination;

//	@Temporal(TemporalType.TIME)
//  private Date takeoffTime;
//
//	@Temporal(TemporalType.TIME)
//  private Date landingTime;

	private Integer availableSeat;

	private Double fare;
	
//	@OneToMany(mappedBy = "scheduleFlight",cascade = CascadeType.ALL,orphanRemoval = true)
//	private List<Passenger> passengerList;

	@OneToMany(mappedBy = "scheduleFlight", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Booking> bookingList;
// helper method
	public void addBooking(Booking b) {
		bookingList.add(b);
		b.setScheduleFlight(this);
	}

	public void removeBooking(Booking b) {
		bookingList.remove(b);
		b.setScheduleFlight(null);

	}

	@Override
	public String toString() {
		return "ScheduleFlight [takeoffDateTime=" + takeoffDateTime + ", landingDateTime=" + landingDateTime
				+ ", source=" + source + ", destination=" + destination + ", availableSeat=" + availableSeat + ", fare="
				+ fare + ", getId()=" + getId() + "]";
	}

	
	



	
	

}
