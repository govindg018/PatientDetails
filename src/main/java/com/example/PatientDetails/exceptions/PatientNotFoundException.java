package com.example.PatientDetails.exceptions;

public class PatientNotFoundException extends RuntimeException{
	
	public PatientNotFoundException() {
		super();
	}
	
		public PatientNotFoundException(String message) {
			super(message);
		
	}

}
