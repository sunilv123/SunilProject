package com.hotelBooking.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class CustomResponse {

	@JsonIgnore
	public static final String SUCCESS = "SUCCESS";
	@JsonIgnore
	public static final String FAILURE = "FAILURE";

	private String status = SUCCESS;

	private Object payLoad;

	private CustomError customError;

	private String customInfo;

	public CustomResponse(Object payLoad) {
		super();
		this.payLoad = payLoad;
	}

	public CustomResponse(String status, CustomError customError) {
		super();
		this.status = status;
		this.customError = customError;
	}

	public CustomResponse() {
		super();
	
	}
	}