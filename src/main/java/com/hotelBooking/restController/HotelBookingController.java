package com.hotelBooking.restController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelBooking.bean.HotelBookingBean;
import com.hotelBooking.services.HotelBookingService;

@RestController
@RequestMapping("/hotel")
public class HotelBookingController {

	@Autowired
	private HotelBookingService hotelBookingService;
	
	private static final Logger LOGGER = Logger.getLogger(HotelBookingController.class);
	@RequestMapping(value = "/seeAllBooking", method = RequestMethod.GET)
	public List<HotelBookingBean> getAll(HttpServletRequest request) {
		LOGGER.error("gettingAll model  from url "+request.getRequestURL());
		return hotelBookingService.getHotelBookingList();
	}
	
	@RequestMapping(value = "/book" ,method = RequestMethod.POST)
	public List<HotelBookingBean> bookHotel(@RequestBody HotelBookingBean hotelBookingBean){
		
		hotelBookingService.bookHotel(hotelBookingBean);
		return hotelBookingService.getHotelBookingList();
	}
	@RequestMapping(value = "/cancelBooking" , method = RequestMethod.POST)
   public List<HotelBookingBean> deleteHotelBooking(@RequestParam Long id){
	  
		LOGGER.info("id : "+ id);
		try{
		hotelBookingService.cancelHotel(id);
		  
		int value = 10/0;
		}catch (Exception e) {
			LOGGER.info("deleteHotelBooking   :   "+e.getMessage());
		}
		
		return hotelBookingService.getHotelBookingList();
   }
	
	@RequestMapping(value = "/changeBooking" , method = RequestMethod.POST)
	   public List<HotelBookingBean> changeHotelBooking(@RequestBody HotelBookingBean hotelBookingBean){
		  
			hotelBookingService.changeHotel(hotelBookingBean);
			
			return hotelBookingService.getHotelBookingList();
	   }
}
