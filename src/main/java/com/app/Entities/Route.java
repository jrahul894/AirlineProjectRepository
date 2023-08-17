package com.app.Entities;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name="route")
public class Route 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int routeId;
	private String source;
	private String destination;
	
	
	@OneToMany(mappedBy ="route")
	private List<Price> priceList;
	
	//@JsonIgnore
	@OneToMany(mappedBy="routeSchedule")
	private List<ScheduleFlight> scheduleFlight;
	
	
	}
