package com.hotelBooking.models;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class AppUser extends BaseEntity{

	private String name;
	
	private String email;
	
	private String contactNumber;
	
	private String password;
	
	private String salt;
	
}
