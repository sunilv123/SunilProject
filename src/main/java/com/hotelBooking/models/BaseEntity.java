package com.hotelBooking.models;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
	private  Timestamp createdDateTime;
	
	@Version
	private Timestamp updatedDateTime;
}
