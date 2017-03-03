package com.hotelBooking;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hotelBooking.controller.LoginController;

public class AuthenticateUser extends OncePerRequestFilter{

	private static final Logger LOGGER = Logger.getLogger(LoginController.class);
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filter)throws ServletException, IOException {
		System.out.println("AuthenticateUser  ==============================doFilterInternal======");
		LOGGER.debug("AuthenticateUser  ====================================   "+request.getRequestURL());
	}

}
