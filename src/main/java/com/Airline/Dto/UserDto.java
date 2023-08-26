package com.Airline.Dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.Airline.Entities.Booking;
import com.Airline.Entities.Role;

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
public class UserDto {
//	private String userId;
	@NotBlank(message = "first name can't be Blank")
	private String firstName;
    @NotBlank(message = "last name can't be Blank")
	private String lastName;
	@NotBlank(message = "email can't be Blank")
	@Email
	private String email;
	@Pattern(message = "password must be in valid format",regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$")
	private String password;
	
	private Role role;
	@Digits(fraction = 0,integer = 10,message="phone no must be of 10 digit")
	private String phoneNo;
   
}
