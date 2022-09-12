package com.example.PatientDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PatientDetails.entities.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
