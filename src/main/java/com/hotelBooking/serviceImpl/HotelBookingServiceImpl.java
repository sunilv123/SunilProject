package com.hotelBooking.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelBooking.bean.HotelBookingBean;
import com.hotelBooking.models.HotelBooking;
import com.hotelBooking.repositry.HotelBookingRepoistory;
import com.hotelBooking.restController.HotelBookingController;
import com.hotelBooking.services.HotelBookingService;

@Service
public class HotelBookingServiceImpl implements HotelBookingService {

	@Autowired
	private HotelBookingRepoistory hotelBookingRepoistory;
	private static final Logger LOGGER = Logger.getLogger(HotelBookingServiceImpl.class);
	@Override
	public List<HotelBookingBean> getHotelBookingList() {
		
		LOGGER.info("Coming HotelBookingServiceImpl calling getHotelBookingList");
		List<HotelBookingBean> hotelBookingBeans = hotelBookingRepoistory.findAll().stream().map(hotelBooking -> 
		new HotelBookingBean(hotelBooking)).collect(Collectors.toList()); 
		return hotelBookingBeans;
	}

	@Override
	public Boolean bookHotel(HotelBookingBean hotelBookingBean) {
	 try{
		HotelBooking hotelBooking = new HotelBooking();
		BeanUtils.copyProperties(hotelBookingBean, hotelBooking);
		
		hotelBookingRepoistory.save(hotelBooking);
		
		return true;
	 }catch (Exception e) {
		e.printStackTrace();
	}
	 return false;
	}

	@Override
	public Boolean cancelHotel(Long id) {
		 try{
				HotelBooking hotelBooking = hotelBookingRepoistory.findOne(id);
				hotelBookingRepoistory.delete(hotelBooking);
				return true;
			 }catch (Exception e) {
				e.printStackTrace();
			}
			 return false;
	}
	
	@Override
	public Boolean changeHotel(HotelBookingBean hotelBookingBean) {
		 try{
				HotelBooking hotelBooking = hotelBookingRepoistory.findOne(hotelBookingBean.getId());
				hotelBooking.setHotelName(hotelBookingBean.getHotelName());
				hotelBooking.setPricePerNight(hotelBookingBean.getPricePerNight());
				hotelBookingRepoistory.save(hotelBooking);
				return true;
			 }catch (Exception e) {
				e.printStackTrace();
			}
			 return false;
	}
}
