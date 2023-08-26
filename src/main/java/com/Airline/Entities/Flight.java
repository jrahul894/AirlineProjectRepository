package com.Airline.Entities;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Flight extends BaseEntity{
//	@Id
////	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CustomStringIdGeneratorF")
////	@GenericGenerator(name = "CustomStringIdGeneratorF", strategy = "com.app.Entities.CustomStringIdGeneratorF")
//	private String flightId;
	
	@Enumerated(EnumType.STRING)
	private Airline operatingAirline;
    
	private Integer checkingBaggageCapacity;
    
	private Integer cabinBaggageCapacity;
    
	
	
	@OneToMany(mappedBy = "aircraft",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<ScheduleFlight>scheduledFlight;
	
    public void addScheduledFlight(ScheduleFlight f) {
    	scheduledFlight.add(f);
    	f.setAircraft(this);
    }
    public void removeScheduledFlight(ScheduleFlight f) {
    	scheduledFlight.remove(f);
    	f.setAircraft(null);
    }
	@Override
	public String toString() {
		return "Flight [operatingAirline=" + operatingAirline + ", checkingBaggageCapacity=" + checkingBaggageCapacity
				+ ", cabinBaggageCapacity=" + cabinBaggageCapacity + ", getId()=" + getId() + "]";
	}
	
	
	
    
}
