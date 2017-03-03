package com.hotelBooking.bean;

import lombok.Data;

@Data
public class CustomError {

	private String errorCode;

	private String errorMessage;

	public CustomError(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}
