package com.example.PatientDetails.controllerTest;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.junit.jupiter.api.Test;

import com.example.PatientDetails.controller.PatientController;
import com.example.PatientDetails.entities.Address;
import com.example.PatientDetails.entities.Patient;
import com.example.PatientDetails.service.AddressService;
import com.example.PatientDetails.service.PatientService;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PatientService patientService;
	
	@MockBean
	private AddressService addressService;
	
	
	public void PatientSaveTest() throws Exception{
		
		Address address = new Address(1, "Manakiveetil", "Kerala", "680623");
		 Address addressone = new Address(2, "Mumbai", "Kerala", "680623");
		 
		 List<Address> addressesList = new ArrayList<>();
		 addressesList.add(addressone);
		 addressesList.add(address);
		 
		 Patient patient = new Patient(1, "Govind", "G", "Male", "2022-01-01", addressesList );
		 
		 Mockito.when(patientService.savePatientDetails(any(Patient.class))).thenReturn(patient);
		 
		 String url = "/patient";
		 String inputInJson = this.mapToJson(patient);
		 
		 
		 RequestBuilder requestBuilder = MockMvcRequestBuilders.post(url).accept(MediaType.APPLICATION_JSON).content(inputInJson).contentType(MediaType.APPLICATION_JSON);;
		 
		 MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 MockHttpServletResponse response = result.getResponse();
		 
		 String outputInJson = response.getContentAsString();
		 assertThat(outputInJson).isEqualTo(inputInJson);
		 assertEquals(HttpStatus.OK.value(), response.getStatus());
		 
		 
		
	}
	private String mapToJson(Object object) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
		
	}
	
	
	
	
}
