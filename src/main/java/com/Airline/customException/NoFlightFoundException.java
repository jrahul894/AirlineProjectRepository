package com.Airline.customException;

@SuppressWarnings("serial")
public class NoFlightFoundException extends RuntimeException {

	public NoFlightFoundException(String mesg) {
	super(mesg);
	}
}
