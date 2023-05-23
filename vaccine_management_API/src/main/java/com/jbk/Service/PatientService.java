package com.jbk.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jbk.Entity.PatientDetails;

public interface PatientService {

public	Boolean savePatient(PatientDetails patientDetails);

public	Boolean updatePatient(PatientDetails patientDetails);

public boolean deletePatientById(String patientId);

public List<PatientDetails> getAllPatients();

public PatientDetails getPatientById(String patientId);

public List<PatientDetails> getPatientWithdose1();

public List<PatientDetails> getPatientWithdose2();

public List<PatientDetails> getPatientWithCity(String city);

public List<PatientDetails> getPatientWithState(String state);

public PatientDetails getPatientWithAadhar(long aadharNumber);

public List<PatientDetails> getPatientWithVaccineName(String vaccineName);

public int totalCountOfPatientWithVaccineName(String vaccineName); 

public int totalCountOfPatientVaccineted();

public int totalCountOfPatientWithdose1();

public int totalCountOfPatientWithdose2();

//public List<PatientDetails> getPatientgotVaccinatedInDate(Date startdate, Date enddate);

//public Map<String, Integer> getCountOfPatientgotVaccinatedInDate(Date startdate, Date enddate);

public Map<String, Integer> getCountOfPatientgotVaccinatedInDate(String startdate, String enddate);



public PatientDetails userLogin(String patientid, Date dateDateOfBirth);

public List<PatientDetails> getPatientgotVaccinatedInDate(String startdate, String enddate);



}
