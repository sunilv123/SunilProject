package com.hotelBooking.bean;

import lombok.Data;

@Data
public class AppUserBean {

	public AppUserBean() {
	}

	private String name;
	
	private String email;
	
	private String contactNumber;
	
	private String password;
	
	private String salt;
}
