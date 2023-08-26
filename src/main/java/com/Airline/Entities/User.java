package com.Airline.Entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@NoArgsConstructor
public class User extends BaseEntity {
	 //pk
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CustomStringIdGeneratorU")
//	@GenericGenerator(name = "CustomStringIdGeneratorU", strategy = "com.app.Entities.CustomStringIdGeneratorU")
//	private String userId;
	
	//@GeneratedValue(generator = "custom-string-id")
    //@GenericGenerator(name = "custom-string-id", strategy = "com.Airline.Entities.CustomStringIdGeneratorU")
	
	
	private String firstName;
	
	private String lastName;
	
	@Column(unique = true,nullable=false)
	private String email;
	
	private String password;
	
	@Column(unique = true,nullable=false)
	private String phoneNo;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Booking>bookingList;
	
	public void addBooking(Booking b) {
		bookingList.add(b);
		b.setUser(this);
	}
	public void removeBooking(Booking b) {
		bookingList.remove(b);
		b.setUser(null);
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ ", phoneNo=" + phoneNo + ", role=" + role + ", getId()=" + getId() + "]";
	}
	
    	
}
