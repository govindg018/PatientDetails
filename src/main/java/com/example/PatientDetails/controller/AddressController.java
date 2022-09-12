package com.example.PatientDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PatientDetails.entities.Address;
import com.example.PatientDetails.entities.Patient;
import com.example.PatientDetails.exceptions.AddressNotFoundException;
import com.example.PatientDetails.exceptions.PatientNotFoundException;
import com.example.PatientDetails.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping("/{addressId}")
	public ResponseEntity<Address> getAddressById(@PathVariable int addressId){
		Address address = addressService.getAddressDetails(addressId);
		
		if(address==null) {
			
			throw new AddressNotFoundException("Address details not Found");
		}
		
		
		return new ResponseEntity<>(address,HttpStatus.OK);
	}
    @PostMapping
	public ResponseEntity<Address> saveAddress(@RequestBody Address address){
		return new ResponseEntity<>(addressService.saveAddresses(address),HttpStatus.OK);
		
		
		
			
			
		}
    
    @DeleteMapping("/{addressId}")
    public ResponseEntity<Object> deletePatient(@PathVariable("addressId") int addressId) {
        addressService.deleteAddress(addressId);
        return new ResponseEntity<Object>(
                "Address is deleted....addressId = " + addressId,  HttpStatus.OK);
    }
		
	
}

