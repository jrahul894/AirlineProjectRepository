package com.Airline.Entities;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Passenger extends BaseEntity {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "customStringIdGeneratorP")
//	@GenericGenerator(name = "customStringIdGeneratorP", strategy = "com.app.Entities.CustomStringIdGeneratorP")
//    private String passengerId;

	private String passengerName;

	private Integer passengerAge;
	
    @Column(name = "aadhar_no",length=20)
	private String aadharNo;
	
	@Column(name="email_id",length=20)
	private String email;
	
    private String phoneNo;

	
    
//	public String getPassengerId() {
//		return passengerId;
//	}

//	public void setPassengerId(String passengerId) {
//		this.passengerId = passengerId;
//	}

	


//	@ManyToOne
//	@JoinColumn(name="schedule_id")
//	private ScheduleFlight scheduleFlight;
 
	@Override
	public String toString() {
		return "Passenger [passengerName=" + passengerName + ", passengerAge=" + passengerAge + ", aadharNo=" + aadharNo
				+ ", email=" + email + ", phoneNo=" + phoneNo + ", getId()=" + getId() + "]";
	}



	@ManyToOne
	@JoinColumn(name="booking_id")
	private Booking bookings;

	
    
    
}
