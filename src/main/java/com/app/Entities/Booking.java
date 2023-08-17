package com.app.Entities;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "customStringIdGeneratorB")
	@GenericGenerator(name = "customStringIdGeneratorB", strategy = "com.app.Entities.CustomStringIdGeneratorB")
	private String BookingNo;

	private String paymentStatus;

	private String bookingStatus;

	private Integer seatNo;

	private Double totalAmount;

	private LocalDate scheduledDate;
	
    @ManyToOne
    @JoinColumn(name="userId")
	private User user;//many bookings by one single user
    
    @ManyToOne
    @JoinColumn(name="passengerId")
	private Passenger passenger;
    
    @ManyToOne
    @JoinColumn(name="scheduleId")
    private ScheduleFlight scheduleFlight;
}

