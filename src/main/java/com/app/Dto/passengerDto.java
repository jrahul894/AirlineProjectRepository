package com.app.Dto;

import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

import com.app.Entities.Flight;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class passengerDto {
//@NotEmpty	
//private String passengerId;
@NotBlank
private String passengerFirstName;
@NotBlank
private String passengerLastName;
@Past(message = "Date of birth must be in the past.")
@DateTimeFormat(pattern = "yyyy-MM-dd")
private LocalDate passengerDOB;
//@Range(min=12,max=20)
private String aadharNo;
@NotNull
private Integer passengerAge;
@Email
private String email;
@Digits(fraction = 0, integer = 10,message="phone no. must be in 10 digit")
private String phoneNo;

private Flight flight;
}
