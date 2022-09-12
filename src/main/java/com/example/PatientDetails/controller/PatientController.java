package com.example.PatientDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PatientDetails.entities.Patient;
import com.example.PatientDetails.exceptions.PatientNotFoundException;
import com.example.PatientDetails.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping
	public ResponseEntity<List<Patient>> getAllPatients(){
		return new ResponseEntity<>(patientService.getAllPatientDetails(),HttpStatus.OK);
	}
	
	
	  @GetMapping("/{patientId}") public ResponseEntity<Patient>
	  getPatientById(@PathVariable int patientId){ 
		  
      Patient patient = patientService.getPatientDetails(patientId);
	  
	  
	  if(patient==null) {
	  
	  throw new PatientNotFoundException("Patient details not Found");
	  
	  }
	  
	  
	  return new ResponseEntity<>(patient,HttpStatus.OK);
	  
	  
	  }
	 
	
	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
		return new ResponseEntity<>(patientService.savePatientDetails(patient),HttpStatus.OK);
		
		}
	
	@DeleteMapping("/{patientId}")
    public ResponseEntity<Object> deletePatient(@PathVariable("patientId") int patientId) {
        patientService.deletePatient(patientId);
        return new ResponseEntity<Object>(
                "Patient is deleted....patientId = " + patientId,  HttpStatus.OK);
    }
		
		
		
	}


