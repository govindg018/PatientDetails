package com.example.PatientDetails.repositoryTest;

import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.PatientDetails.entities.Patient;
import com.example.PatientDetails.entities.Address;
import com.example.PatientDetails.repository.PatientRepository;
import lombok.Builder;

@RunWith(SpringRunner.class)

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

@DataJpaTest
public class PatientRepositoryTest {

	
	  @Autowired
	  private PatientRepository patientRepository; 
	  @Autowired
	  private TestEntityManager testEntityManager;
	  
	  
	  @Test 
	  public void findByIdPatientTest() {
		  
	 Address address = new Address(1, "Manakiveetil", "Kerala", "680623");
	 Address addressone = new Address(2, "Mumbai", "Kerala", "680623");
	 
	 List<Address> addressesList = new ArrayList<Address>();
	 addressesList.add(addressone);
	 addressesList.add(address);
	 
	 
	  
	  Patient patient = new Patient(1, "firstName","lastName","gender","2202-09-09", addressesList);
	  testEntityManager.persist(patient);
	  Patient returnedPatient = patientRepository.findById(1).get();
	 // Patient.builder().patientId(1).firstName("govind").lastName("govind").
	//  gender("govind").dateOfBirth("govind").addresses(addressesList).build();
			 // patientRepository.save(patient);
	  assertThat(returnedPatient).isEqualTo(patient);
	  
	  }
	 
	
	
}
