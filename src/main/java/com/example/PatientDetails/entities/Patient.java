package com.example.PatientDetails.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
//@AllArgsConstructor
@Builder
@Setter
@Getter
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	
	private String firstName;
	private String lastName;
	private String gender;
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private String dateOfBirth;
	
	@OneToMany(cascade = javax.persistence.CascadeType.ALL)
    @JoinColumn(name = "patientId", referencedColumnName="patientId")
    private List<Address> addresses;
	
    public Patient(int patientId, String firstName, String lastName, String gender, String dateOfBirth, List<Address> addresses) {
    	
    }
	
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	
	
	
	
}
