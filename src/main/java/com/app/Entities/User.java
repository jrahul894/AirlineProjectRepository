package com.app.Entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.*;

@Entity
@Table(name="user")
@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class User {
	@Id //pk
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CustomStringIdGeneratorU")
	@GenericGenerator(name = "CustomStringIdGeneratorU", strategy = "com.app.Entities.CustomStringIdGeneratorU")
	private String userId;
	
	private String firstName;
	
	private String lastName;
	@Column(unique = true,nullable=false)
	private String email;
	
	private String password;
	@Column(unique = true,nullable=false)
	private String phoneNo;
	
	private String role;
	
	private LocalDate dateOfBirth;
	@OneToMany(mappedBy = "user")
	private List<Booking>bookingList;
}
