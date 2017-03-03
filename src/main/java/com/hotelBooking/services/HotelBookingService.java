package com.hotelBooking.services;

import java.util.List;

import com.hotelBooking.bean.HotelBookingBean;

public interface HotelBookingService {

	public List<HotelBookingBean> getHotelBookingList();
	public Boolean bookHotel(HotelBookingBean hotelBookingBean);
	public Boolean cancelHotel(Long id); 
	public Boolean changeHotel(HotelBookingBean hotelBookingBean); 
}
