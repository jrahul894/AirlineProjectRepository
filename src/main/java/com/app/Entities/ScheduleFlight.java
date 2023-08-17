package com.app.Entities;
import java.time.LocalDate;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "scheduleflight")
public class ScheduleFlight {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int scheduleId; //pk
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "flightId")
	private Flight flightschedule;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="routeId")
	private Route routeSchedule;
	
	@Temporal(TemporalType.DATE)
	private Date takeoffDate;
	@Temporal(TemporalType.DATE)
	private Date landingDate;

	@Temporal(TemporalType.TIME)
	private Date takeoffTime;
	@Temporal(TemporalType.TIME)
	private Date landingTime;
	
	@Column(name ="availableEconomyClassSeat")
	private int available_economyClass_seat ;
	
	@Column(name ="availableBusinessClassSeat")
	private int available_businessClass_seat ;
	
	@Column(name ="availableFirstClassSeat")
	private int available_firstClass_seat;
	
	@OneToMany(mappedBy ="scheduleFlight")
	private List<Booking> bookingList;
	}
