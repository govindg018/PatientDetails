package com.example.PatientDetails.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = PatientNotFoundException.class)
	public ResponseEntity<Object> exception(PatientNotFoundException exception){
		
		return new ResponseEntity<>("PatientId not found",HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value = AddressNotFoundException.class)
	public ResponseEntity<Object> exception(AddressNotFoundException exception){
		
		return new ResponseEntity<>("addressId not found",HttpStatus.NOT_FOUND);
	}
	
	
}
