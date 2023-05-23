package com.jbk.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PatientDetails {

	@Id
	private String patientId;
	
	//@NotEmpty(message="patient name is required")
	//@Size(min=2 , message ="please enter minimum 2 character")
	private String patientName;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date DateOfBirth;
	
	//@NotEmpty(message="patient address is required")
	private String address;
	//@NotEmpty(message="patient city is required")
	private String city;
	//@NotEmpty(message="patient state is required")
	private String state;
	//@NotEmpty(message="patient country is required")
	private String country;
	//@NotEmpty(message="please enter valid phone number ")
	private String phoneNo;
	//@NotEmpty(message="please enteraadhar number ")
	private long aadharNumber;
	
	private String vaccineName;
	private boolean Dose1;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date Dose1Date;
	
	private boolean Dose2;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date Dose2Date;
	
	
	public PatientDetails() {
		super();
	}


	public PatientDetails(String patientId, String patientName, Date dateOfBirth, String address, String city,
			String state, String country, String phoneNo, long aadharNumber, String vaccineName, boolean dose1,
			Date dose1Date, boolean dose2, Date dose2Date) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		DateOfBirth = dateOfBirth;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneNo = phoneNo;
		this.aadharNumber = aadharNumber;
		this.vaccineName = vaccineName;
		Dose1 = dose1;
		Dose1Date = dose1Date;
		Dose2 = dose2;
		Dose2Date = dose2Date;
	}


	public String getPatientId() {
		return patientId;
	}


	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public Date getDateOfBirth() {
		return DateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public long getAadharNumber() {
		return aadharNumber;
	}


	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}


	public String getVaccineName() {
		return vaccineName;
	}


	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}


	public boolean isDose1() {
		return Dose1;
	}


	public void setDose1(boolean dose1) {
		Dose1 = dose1;
	}


	public Date getDose1Date() {
		return Dose1Date;
	}


	public void setDose1Date(Date dose1Date) {
		Dose1Date = dose1Date;
	}


	public boolean isDose2() {
		return Dose2;
	}


	public void setDose2(boolean dose2) {
		Dose2 = dose2;
	}


	public Date getDose2Date() {
		return Dose2Date;
	}


	public void setDose2Date(Date dose2Date) {
		Dose2Date = dose2Date;
	}


	@Override
	public String toString() {
		return "PatientDetails [patientId=" + patientId + ", patientName=" + patientName + ", DateOfBirth="
				+ DateOfBirth + ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", phoneNo=" + phoneNo + ", aadharNumber=" + aadharNumber + ", vaccineName=" + vaccineName
				+ ", Dose1=" + Dose1 + ", Dose1Date=" + Dose1Date + ", Dose2=" + Dose2 + ", Dose2Date=" + Dose2Date
				+ "]";
	}
		
	
	
}
	
	
	