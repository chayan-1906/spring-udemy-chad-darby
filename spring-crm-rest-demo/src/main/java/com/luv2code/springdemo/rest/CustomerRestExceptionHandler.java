package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// Add an exception handler for CustomerNotFoundHandler
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(
			CustomerNotFoundException customerNotFoundException) {
		// create CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				customerNotFoundException.getMessage(),
				System.currentTimeMillis());
		
		// return ResponseEntity

		return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	// Add another exception handler... to catch any exception (catch all)
	public ResponseEntity<CustomerErrorResponse> handleException(Exception customerNotFoundException) {
		// create CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				customerNotFoundException.getMessage(),
				System.currentTimeMillis());

		// return ResponseEntity

		return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
