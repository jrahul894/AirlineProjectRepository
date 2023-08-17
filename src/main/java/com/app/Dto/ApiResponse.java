package com.app.Dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ApiResponse {
private String message;
private LocalDate timeStamp;

public ApiResponse(String mesg) {
	this.message=mesg;
	this.timeStamp=LocalDate.now();
}
}
