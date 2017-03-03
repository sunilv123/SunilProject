package com.hotelBooking.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelBooking.models.HotelBooking;

public interface HotelBookingRepoistory extends JpaRepository<HotelBooking , Long> {

}
