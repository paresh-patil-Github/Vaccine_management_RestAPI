package com.jbk.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Entity.PatientDetails;
import com.jbk.Service.PatientService;
import com.jbk.exception.NoContentExceptionHandler;

@RestController
public class CovidController {
	
	
	@Autowired
	PatientService service;
	
	@PostMapping(value="/savePatient")
	public ResponseEntity<Boolean> savePatient(@RequestBody PatientDetails patientDetails){
		boolean isAdded=service.savePatient(patientDetails);
		
		if(isAdded) { 
			
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
			
		} else
			{return new ResponseEntity<Boolean>(isAdded, HttpStatus.CONFLICT);
			}
	}
	
	@PutMapping(value="/updatePatient")
	public ResponseEntity<Boolean>  updatePatient(@RequestBody PatientDetails patientDetails){
		


		boolean isUpdated = service.updatePatient(patientDetails);
		
		if(isUpdated) {
			
		return  new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK) ;
		
		} else {
			throw new NoContentExceptionHandler(" Pation doesnot exist");
			//return  new ResponseEntity<Boolean>(isUpdated, HttpStatus.NO_CONTENT) ;
		}
		
	}
	

	@GetMapping(value="/getPatientById/{patientId}")
	public ResponseEntity<PatientDetails> getPatientById(@PathVariable String patientId){
		
		PatientDetails patientDetails=service.getPatientById(patientId);
		
		if(patientDetails != null) {
			return new ResponseEntity<PatientDetails>(patientDetails, HttpStatus.OK);
		}else {
			throw new NoContentExceptionHandler(" pationt doesnot exist with patientID : "+patientId);
		//return  new ResponseEntity<PatientDetails>(patientDetails, HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping(value="/getAllPatientList")
	public ResponseEntity<List<PatientDetails>> getAllPatients(){
		
		List<PatientDetails> list =service.getAllPatients();
		
		if(list.isEmpty()) {
			//return new ResponseEntity<List<PatientDetails>>(HttpStatus.NO_CONTENT);
			throw new NoContentExceptionHandler(" Pation doesnot exist");
		} else {
		
		return new ResponseEntity<List<PatientDetails>>(list,HttpStatus.OK);
		}
	}
	
	@DeleteMapping(value="/deletePatient/{patientId}")
	public ResponseEntity<Boolean> deletePatientById (@PathVariable String patientId){
		
		boolean isDeleted=service.deletePatientById(patientId);
		
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		}else {
			throw new NoContentExceptionHandler(" Pation doesnot exist with patientID :"+patientId);
			//return new ResponseEntity<Boolean>(isDeleted, HttpStatus.NO_CONTENT);
		}
		
	}
	
	
	@GetMapping(value="/getPatientWithdose1")
	public ResponseEntity<List<PatientDetails>> getPatientWithdose1(){
		
		List<PatientDetails> list =service.getPatientWithdose1();
		
		if(list.isEmpty()) {
			//return new ResponseEntity<List<PatientDetails>>(HttpStatus.NO_CONTENT);
			throw new NoContentExceptionHandler("no Patients have received first dose yet");
		} else {
		
		return new ResponseEntity<List<PatientDetails>>(list,HttpStatus.OK);
		}
		
	}
	
	
	@GetMapping(value="/getPatientWithdose2")
	public ResponseEntity<List<PatientDetails>> getPatientWithdose2(){
		
		List<PatientDetails> list =service.getPatientWithdose2();
		
		if(list.isEmpty()) {
			//return new ResponseEntity<List<PatientDetails>>(HttpStatus.NO_CONTENT);
			throw new NoContentExceptionHandler("no Patients have received second dose yet");
		} else {
		
		return new ResponseEntity<List<PatientDetails>>(list,HttpStatus.OK);
		}
		
	}
	

	@GetMapping(value="/getPatientWithCity/{city}")
	public ResponseEntity<List<PatientDetails>> getPatientWithCity(@PathVariable String city){
	
		List<PatientDetails> list =service.getPatientWithCity(city);
		
		if(list.isEmpty()) {
			//return new ResponseEntity<List<PatientDetails>>(HttpStatus.NO_CONTENT);
			throw new NoContentExceptionHandler("no Patients have received vaccine yet");
		} else {
		
		return new ResponseEntity<List<PatientDetails>>(list,HttpStatus.OK);
		}
	
}


	@GetMapping(value="/getPatientWithState/{state}")
	public ResponseEntity<List<PatientDetails>> getPatientWithState(@PathVariable String state){
	
		List<PatientDetails> list =service.getPatientWithState(state);
		
		if(list.isEmpty()) {
			//return new ResponseEntity<List<PatientDetails>>(HttpStatus.NO_CONTENT);
			throw new NoContentExceptionHandler("no Patients have received vaccine yet");
		} else {
		
		return new ResponseEntity<List<PatientDetails>>(list,HttpStatus.OK);
		}
	
	}
	
	@GetMapping(value="/getPatientWithAadhar/{aadharNumber}")
	public ResponseEntity<PatientDetails> getPatientWithAadhar(@PathVariable long aadharNumber){
	
		PatientDetails patientDetails =service.getPatientWithAadhar(aadharNumber);
		
		if(patientDetails!= null) {
			//return new ResponseEntity<PatientDetails>(patientDetails,HttpStatus.OK);
			throw new NoContentExceptionHandler("Invalid Credentials");
		} else {
		return new ResponseEntity<PatientDetails>(HttpStatus.NO_CONTENT);
	}
	
}
	@GetMapping(value="/getPatientWithVaccineName/{vaccineName}")
	public ResponseEntity<List<PatientDetails>> getPatientWithVaccineName(@PathVariable String vaccineName){
		
		List<PatientDetails> list =service.getPatientWithVaccineName(vaccineName);
		
		if(list.isEmpty()) {
			//return new ResponseEntity<List<PatientDetails>>(HttpStatus.NO_CONTENT);
			throw new NoContentExceptionHandler("no patients have opted for vaccine :"+vaccineName);
		} else {
		
		return new ResponseEntity<List<PatientDetails>>(list,HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value="/totalCountOfPatientWithVaccineName/{vaccineName}")
	public ResponseEntity<Integer> totalCountOfPatientWithVaccineName(String vaccineName) {
		
		int totalCoun=service.totalCountOfPatientWithVaccineName(vaccineName);
		
		if(totalCoun>0) {
			return new ResponseEntity<Integer>(totalCoun, HttpStatus.OK);
		}else {
			//return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
			throw new NoContentExceptionHandler("no patients have opted for vaccine :"+vaccineName);
		}
	}
	
	@GetMapping(value="/totalCountOfPatientVaccineted")
	public ResponseEntity<Integer> totalCountOfPatientVaccineted() {
		int totalCoun=service.totalCountOfPatientVaccineted();
		
		if(totalCoun>0) {
			return new ResponseEntity<Integer>(totalCoun, HttpStatus.OK);
		}else {
			//return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
			throw new NoContentExceptionHandler("no Patients have received vaccine");
		}
	}
	
	@GetMapping(value="/totalCountOfPatientWithdose1")
	public ResponseEntity<Integer> totalCountOfPatientWithdose1() {
		int totalCoun=service.totalCountOfPatientWithdose1();
		
		if(totalCoun>0) {
			return new ResponseEntity<Integer>(totalCoun, HttpStatus.OK);
		}else {
		//	return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
			throw new NoContentExceptionHandler("no Patients have received first dose yet");
		}
}
	
	@GetMapping(value="/totalCountOfPatientWithdose2")
	public ResponseEntity<Integer> totalCountOfPatientWithdose2() {
		int totalCoun=service.totalCountOfPatientWithdose2();
		
		if(totalCoun>0) {
			return new ResponseEntity<Integer>(totalCoun, HttpStatus.OK);
		}else {
			throw new NoContentExceptionHandler("no Patients have received second dose yet");
			//return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
		}
}


	@GetMapping(value="/getPatientgotVaccinatedInDate")
	 public  ResponseEntity<List<PatientDetails>> getPatientgotVaccinatedInDate(@RequestParam String startdate ,@RequestParam String  enddate){
		
		 List<PatientDetails> list =service.getPatientgotVaccinatedInDate(startdate, enddate);
	 //public  ResponseEntity<List<PatientDetails>> getPatientgotVaccinatedInDate(@RequestParam Date startdate,@RequestParam Date enddate){
		 
		// List<PatientDetails> list =service.getPatientgotVaccinatedInDate(startdate,enddate);
			
			if(list.isEmpty()) {
				//return new ResponseEntity<List<PatientDetails>>(HttpStatus.NO_CONTENT);
				throw new NoContentExceptionHandler("no Patients have received vaccine between specific dates");
			} else {
			
			return new ResponseEntity<List<PatientDetails>>(list,HttpStatus.OK);
			}
			 
		 
	 }
	
	@GetMapping(value="/getCountOfPatientgotVaccinatedInDate")
	public ResponseEntity<Map<String, Integer>> getCountOfPatientgotVaccinatedInDate(@RequestParam String startdate ,@RequestParam String  enddate){
		 
		
		 Map<String, Integer> vaccineCountMap =service.getCountOfPatientgotVaccinatedInDate(startdate,enddate);
			
			if(vaccineCountMap.isEmpty()) {
				//return new ResponseEntity<Map<String, Integer>>(HttpStatus.NO_CONTENT);
				throw new NoContentExceptionHandler("no Patients have received vaccine between specific dates");
			} else {
			
			return new ResponseEntity<Map<String, Integer>>(vaccineCountMap,HttpStatus.OK);
			}
		 
	 }
	
	@GetMapping(value="/login")
	public ResponseEntity<PatientDetails> userLogin(@RequestParam String patientid , @RequestParam Date dateDateOfBirth){
		
		PatientDetails patientDetails=service.userLogin(patientid,dateDateOfBirth);
		
		if(patientDetails!=null) {
			return ResponseEntity.ok(patientDetails);   
		}else {
			throw new NoContentExceptionHandler("Invalid Credentials");
		}
		
	}
	
	
	
}
	

