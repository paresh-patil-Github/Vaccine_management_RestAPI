package com.jbk.Dao;

import java.util.Date;
import java.util.List;

import com.jbk.Entity.PatientDetails;

public interface PatientDAO {

public	Boolean savePatient(PatientDetails patientDetails);

public	Boolean updatePatient(PatientDetails patientDetails);

public boolean deletePatientById(String patientId);

public List<PatientDetails> getAllPatients();

public PatientDetails getPatientById(String patientId);

public List<PatientDetails> getPatientWithdose1();

List<PatientDetails> getPatientWithdose2();

List<PatientDetails> getPatientWithCity(String city);

List<PatientDetails> getPatientWithState(String state);

public List<PatientDetails> getPatientgotVaccinatedInDate(Date startdate, Date enddate);
	
}
