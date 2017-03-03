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

	@Override
	public String toString() {
		return "AppUserBean [name=" + name + ", email=" + email + ", contactNumber=" + contactNumber + ", password="
				+ password + ", salt=" + salt + "]";
	}
}
