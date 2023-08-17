package com.app.Dto;

import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

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
	private String userId;
	@NotBlank
	private String firstName;
    @NotBlank
	private String lastName;
	@NotBlank(message = "email can't be Blank")
	@Email
  //  @UniqueElements
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private String role;
	@Digits(fraction = 0,integer = 10,message="phone no must be of 10 digit")
	private String phoneNo;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
}
