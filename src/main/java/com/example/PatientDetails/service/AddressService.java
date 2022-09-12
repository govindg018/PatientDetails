package com.example.PatientDetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PatientDetails.entities.Address;
import com.example.PatientDetails.entities.Patient;
import com.example.PatientDetails.exceptions.AddressNotFoundException;
import com.example.PatientDetails.exceptions.PatientNotFoundException;
import com.example.PatientDetails.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PatientService patientService;
	
	public Address saveAddresses(Address address) {
		return addressRepository.save(address);
	}

	
	 public Address getAddressDetails(int addressId) {
	 
		 return addressRepository.findById(addressId).orElseThrow(()->new AddressNotFoundException("Invalid address ID"));
	
	
	 }
	 
	 
	 public void deleteAddress(int addressId) {
		 Address address = addressRepository.findById(addressId).orElseThrow(
	                () -> new AddressNotFoundException("Patient not found with Id = " + addressId));
	        addressRepository.delete(address);
	    }
	 
	 
	 
	 
}




