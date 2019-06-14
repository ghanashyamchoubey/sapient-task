package com.sapient.weather.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sapient.weather.exception.GenericException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler({Exception.class})
	public ResponseEntity<GenericException> genericException(){
		return new ResponseEntity<GenericException>(new GenericException(1, "server-error"), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
