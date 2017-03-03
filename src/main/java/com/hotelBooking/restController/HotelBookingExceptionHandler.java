package com.hotelBooking.restController;

import javax.security.sasl.AuthenticationException;

import org.apache.log4j.Logger;
import org.aspectj.apache.bcel.classfile.Utility;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.hotelBooking.bean.CustomError;
import com.hotelBooking.bean.CustomResponse;

@RestController
@ControllerAdvice
public class HotelBookingExceptionHandler {

	private final static Logger LOGGER = Logger.getLogger(HotelBookingExceptionHandler.class);

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public CustomResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		return new CustomResponse(CustomResponse.FAILURE,
				new CustomError("err400", "Unable to the parse request. Please try again"));
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public CustomResponse handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
		return new CustomResponse(CustomResponse.FAILURE,
				new CustomError("err400", "Unable to the parse request. Please try again"));
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = NoHandlerFoundException.class)
	public CustomResponse handleResourceNotFoundException(NoHandlerFoundException e) {
		return new CustomResponse(CustomResponse.FAILURE, new CustomError("err404", "Request URL not found"));
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = ServletRequestBindingException.class)
	public CustomResponse handleServletRequestBindingException(ServletRequestBindingException e) {
		return new CustomResponse(CustomResponse.FAILURE,
				new CustomError("err400", "Sorry. Something unexpected is occured. Please try again"));
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public CustomResponse handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
		return new CustomResponse(CustomResponse.FAILURE,
				new CustomError("err400", "Sorry. Something unexpected is occured. Please try again"));
	}

	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public CustomResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		e.printStackTrace();
		return new CustomResponse(CustomResponse.FAILURE,
				new CustomError("err405", HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase()));
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = IllegalArgumentException.class)
	public CustomResponse handleHttpRequestMethodNotSupportedException(IllegalArgumentException iae) {
		LOGGER.error(iae);
		iae.printStackTrace();
		return new CustomResponse(CustomResponse.FAILURE,
				new CustomError("err400", iae.getMessage()));
	}

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(value = AuthenticationException.class)
	public CustomResponse handleAuthenticationException(AuthenticationException e) {
		e.printStackTrace();
		return new CustomResponse(CustomResponse.FAILURE, new CustomError("err500", e.getMessage()));
	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(value = SecurityException.class)
	public CustomResponse handleSecurityException(SecurityException e) {
		e.printStackTrace();
		return new CustomResponse(CustomResponse.FAILURE, new CustomError("err500", e.getMessage()));
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public CustomResponse handleException(Exception e) {
		e.printStackTrace();
		return new CustomResponse(CustomResponse.FAILURE, new CustomError("err500", e.getMessage()));
	}

}

