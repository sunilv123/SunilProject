package com.hotelBooking.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hotelBooking.models.HotelBooking;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class HotelBookingBean {

    private Long id;
    private String hotelName;
    private double pricePerNight;
    private int noOfNights;

    public HotelBookingBean(){}

    public HotelBookingBean(HotelBooking hotelBooking){
    	this.id = hotelBooking.getId();
        this.hotelName = hotelBooking.getHotelName();
        this.pricePerNight = hotelBooking.getPricePerNight();
        this.noOfNights = hotelBooking.getNoOfNights();
    }
}