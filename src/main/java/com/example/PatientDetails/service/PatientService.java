package com.example.PatientDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PatientDetails.entities.Patient;
import com.example.PatientDetails.exceptions.PatientNotFoundException;
import com.example.PatientDetails.repository.PatientRepository;

@Service
public class PatientService {
  
	@Autowired
	private PatientRepository patientRepository;
	
	public Patient savePatientDetails(Patient patient) {
	    return patientRepository.save(patient);
			
	}
	
	public List<Patient> getAllPatientDetails(){
		
		return patientRepository.findAll();
	}
	
	public Patient getPatientDetails(int patientId) {
		return patientRepository.findById(patientId).orElseThrow(()->new PatientNotFoundException("Invalid patient ID"));
		
		/*
		 * if(patientId==null) {
		 * 
		 * throw new PatientNotFoundException("Patient details not Found");
		 * 
		 * }
		 */	
	}
	
	/*
	 * public Boolean deletePatient(Long patientId) {
	 * 
	 * if (patientRepository.findById(patientId).isPresent()) {
	 * patientRepository.deleteById(patientId); return true; } return false; }
	 */
	
	public void deletePatient(int patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new PatientNotFoundException("Patient not found with Id = " + patientId));
        patientRepository.delete(patient);
    }
	
	
	
	}
	

