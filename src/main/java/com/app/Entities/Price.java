package com.app.Entities;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name="price")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Price 
{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int priceId  ;
	
	@ManyToOne
	@JoinColumn(name="flightId")
	private Flight flight;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="routeId")
	private Route route;
	
	private double businessClassPrice;
	private double economyClassPrice;
	private double firstClassPrice;
}
