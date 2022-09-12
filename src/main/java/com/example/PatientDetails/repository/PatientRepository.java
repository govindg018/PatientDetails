package com.example.PatientDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PatientDetails.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	
	//List<Patient> findByFirstName(String name);
	
}
