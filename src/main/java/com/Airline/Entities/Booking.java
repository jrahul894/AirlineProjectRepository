package com.Airline.Entities;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Booking extends BaseEntity {
//	@Id
////	@GeneratedValue(strategy = GenerationType.AUTO, generator = "customStringIdGeneratorB")
////	@GenericGenerator(name = "customStringIdGeneratorB", strategy = "com.app.Entities.CustomStringIdGeneratorB")
//	private String BookingId;

	private String bookingStatus;

	private Integer seatNo;

	private Double totalAmount;
	
    @ManyToOne
    @JoinColumn(name="user_id")
	private User user;//many bookings by one single user
    
//    
	//@ElementCollection
	//@CollectionTable(name = "Passenger")
    
    @OneToMany(mappedBy = "bookings", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Passenger> passenger;
    
    @ManyToOne
    @JoinColumn(name="schedule_id")
    private ScheduleFlight scheduleFlight;

	
//	public void addPassenger(Passenger p) {
//		passenger.add(p);
//	}
//	public List<Passenger>getPassenger(){
//		return passenger;
//	}
	@Override
	public String toString() {
		return "Booking [bookingStatus=" + bookingStatus + ", seatNo=" + seatNo + ", totalAmount=" + totalAmount
				+ ", getId()=" + getId() + "]";
	}

	
    
    
}

