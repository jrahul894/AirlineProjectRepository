//package com.Airline.Entities;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name="route")
//public class Route extends BaseEntity
//{
////	@GeneratedValue(strategy = GenerationType.IDENTITY)
////	@Id
////	private Integer routeId;
//	
//	private String source;
//	
//	private String destination;
//	
//	
//	@OneToMany(mappedBy="routeSchedule",cascade = CascadeType.ALL,orphanRemoval = true)
//	private List<ScheduleFlight> scheduleFlight;
//
//	
//	
//	public void addScheduleFlight(ScheduleFlight f) {
//		scheduleFlight.add(f);
//		f.setRouteSchedule(this);
//	}
//	public void removeScheduleFlight(ScheduleFlight f) {
//		scheduleFlight.remove(f);
//		f.setRouteSchedule(null);
//	}
//	@Override
//	public String toString() {
//		return "Route [source=" + source + ", destination=" + destination + ", getId()=" + getId() + "]";
//	}
//	}
