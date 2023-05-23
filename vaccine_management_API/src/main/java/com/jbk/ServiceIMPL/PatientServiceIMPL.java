package com.jbk.ServiceIMPL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Dao.PatientDAO;
import com.jbk.Entity.PatientDetails;
import com.jbk.Service.PatientService;

@Service
public class PatientServiceIMPL implements PatientService{

	Date stdate1;
	Date endate1 ;
	//int countWithoutDose2=0;
	
//	List<PatientDetails> patientleftforDose2=null;
	
	@Autowired
	PatientDAO dao;
	
	@Override
	public Boolean savePatient(PatientDetails patientDetails) {
		String patientId =DateTimeFormatter.ofPattern("yyMMddHHmmssSSS").format(LocalDateTime.now());
		
		patientDetails.setPatientId(patientId);
		
		return dao.savePatient(patientDetails);
	}

	@Override
	public Boolean updatePatient(PatientDetails patientDetails) {
		
		
		return dao.updatePatient(patientDetails);
	}

	@Override
	public boolean deletePatientById(String patientId) {
		
		return dao.deletePatientById(patientId);
	}

	@Override
	public List<PatientDetails> getAllPatients() {
		
		return dao.getAllPatients();
	}

	@Override
	public PatientDetails getPatientById(String patientId) {
		
		return dao.getPatientById(patientId);
	}

	@Override
	public List<PatientDetails> getPatientWithdose1() {
		return dao.getPatientWithdose1();
		
	}

	@Override
	public List<PatientDetails> getPatientWithdose2() {
		return dao.getPatientWithdose2();
	}

	@Override
	public List<PatientDetails> getPatientWithCity(String city) {
		return dao.getPatientWithCity(city);
	}

	@Override
	public List<PatientDetails> getPatientWithState(String state) {
		return dao.getPatientWithState(state);
	}

	@Override
	public PatientDetails getPatientWithAadhar(long aadharNumber) {
		List<PatientDetails> list= getAllPatients();
		
		PatientDetails patientDetails=null;
		
		for (PatientDetails patientDetail : list) {
			
			if(patientDetail.getAadharNumber()==aadharNumber) {
				
				patientDetails=patientDetail;
			}
		}
		return patientDetails;
	}

	@Override
	public List<PatientDetails> getPatientWithVaccineName(String vaccineName) {
		List<PatientDetails> list= getAllPatients();
		
		List<PatientDetails> list1= new ArrayList<>();
		
		PatientDetails patientDetails=null;
		
		for (PatientDetails patientDetail : list) {
			
			if(patientDetail.getVaccineName().equals(vaccineName)) {
				
				list1.add(patientDetail);
			}
		}
		return list1;
	}
	
	@Override
	public int totalCountOfPatientVaccineted() {
		List<PatientDetails> list= getAllPatients();
		return (list.size());
	}
	
	@Override
	public int totalCountOfPatientWithVaccineName(String vaccineName) {
		List<PatientDetails> list=getPatientWithVaccineName(vaccineName);
		return list.size();
	}
	/*
	@Override
	public List<PatientDetails> totalPatientWithdose1() {
		
		List<PatientDetails> list= getAllPatients();
		
		List<PatientDetails> patientwithDose1=null;
		
		for (PatientDetails patientDetail : list) {
			if(patientDetail.isDose2()==false) {
				
				patientwithDose1.add(patientDetail);
			}
			else {
				patientleftforDose2.add(patientDetail);
				countWithoutDose2++;
			}
		}
		return patientwithDose1;
	}
	
	*/
	
	@Override
	public int totalCountOfPatientWithdose1() {
		return (getPatientWithdose1().size());
	}
	
	@Override
	public int totalCountOfPatientWithdose2() {
		return getPatientWithdose2().size();
	}

	@Override
	public List<PatientDetails> getPatientgotVaccinatedInDate(String startdate , String  enddate) {
		//Date startdate=dates.get(0);
		//Date enddate=dates.get(1);

		String stdate = startdate;
		String endate = enddate;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			stdate1 = dateFormat.parse(stdate);
			endate1= dateFormat.parse(endate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		return dao.getPatientgotVaccinatedInDate(stdate1, endate1);
	}
	
	@Override
	public Map<String, Integer> getCountOfPatientgotVaccinatedInDate(String startdate, String enddate) {
		
		int pfizer=0, moderna=0 ,covishield=0;
		
		
		List<PatientDetails> list =getPatientgotVaccinatedInDate(startdate,enddate);
		
		for (PatientDetails patientDetails : list) {
			
			if(patientDetails.getVaccineName().equals("pfizer")) {
				pfizer++;
			}else if (patientDetails.getVaccineName().equals("moderna")) {
				moderna++;
			}else if (patientDetails.getVaccineName().equals("covishield")) {
				covishield++;
			}
			
			
		}
	
		Map<String, Integer> vaccineCountMap = new HashMap<>();

		// Add vaccine counts to the map
		vaccineCountMap.put("Total vaccinated", list.size());
		vaccineCountMap.put("pfizer", pfizer);
		vaccineCountMap.put("moderna", moderna);
		vaccineCountMap.put("covishield", covishield);

		
		return vaccineCountMap;
}

	@Override
	public PatientDetails userLogin(String patientid, Date dateDateOfBirth) {
		 List<PatientDetails> allPatients = getAllPatients();
		 
		 PatientDetails qualifiedPatient=null;
		 
		 for (PatientDetails patientDetails : allPatients) {
			if((patientDetails.getPatientId().equals(patientid)) && (patientDetails.getDateOfBirth().compareTo(dateDateOfBirth)==0)){
				qualifiedPatient=patientDetails;
			}
		}
	
		
		return qualifiedPatient;
	}
	
	
}
