package com.jbk.DaoIMPL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.jbk.Dao.PatientDAO;
import com.jbk.Entity.PatientDetails;


@Repository
public class PatientDAOIMPL implements PatientDAO{

	@Autowired
	SessionFactory sf;
	
	@Override
	public Boolean savePatient(PatientDetails patientDetails) {
		boolean isAdded= false;
		Session session = null;
		
		try {
			session=sf.openSession();
			Transaction tr =session.beginTransaction();
			session.save(patientDetails);
			tr.commit();
			isAdded=true;
			
		}catch (PersistenceException e) {
			e.printStackTrace();
			//if product not saved due to duplicate entry
			isAdded=false;
		} 
		catch (Exception e) {
			e.printStackTrace();
			//something wrong while saving data 
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return isAdded;
	}

	@Override
	public Boolean updatePatient(PatientDetails patientDetails) {
		

		boolean isUpdated=false;
		
		Session session = null;
		
		try {
			session=sf.openSession();
			Transaction tr =session.beginTransaction();
			if(patientDetails != null) {
			session.update(patientDetails);
			tr.commit();
			isUpdated=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		
		return isUpdated;
	}

	@Override
	public boolean deletePatientById(String patientId) {

		boolean isdeleted=false;
		
		Session session = null;
		
		try {
			session=sf.openSession();
			Transaction tr =session.beginTransaction();
			PatientDetails patientDetails=session.get(PatientDetails.class, patientId);
	
			if(patientDetails != null) {		
			session.delete(patientDetails);
			tr.commit();
			isdeleted=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return isdeleted;
	}
	

	@Override
	public List<PatientDetails> getAllPatients() {

		List<PatientDetails> list=null;
		
		Session session = null;
		
		try {
			session=sf.openSession();
			
			Criteria criteria=session.createCriteria(PatientDetails.class);
			
			list=criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return list;
	}
	

	@Override
	public PatientDetails getPatientById(String patientId) {
		
		PatientDetails patientDetails=null;
		
		Session session = null;
		
		try {
			session=sf.openSession();
			
			patientDetails=session.get(PatientDetails.class, patientId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		
		return patientDetails;
	}

	@Override
	public List<PatientDetails> getPatientWithdose1() {
	List<PatientDetails> list=null;
		
		Session session = null;
		
		try {
			session=sf.openSession();
			
			Criteria criteria=session.createCriteria(PatientDetails.class);
			
			criteria.add(Restrictions.eq("Dose1", true));
			
			list=criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return list;
	}
	
	@Override
	public List<PatientDetails> getPatientWithdose2() {
	List<PatientDetails> list=null;
		
		Session session = null;
		
		try {
			session=sf.openSession();
			
			Criteria criteria=session.createCriteria(PatientDetails.class);
			
			criteria.add(Restrictions.eq("Dose2", true));
			
			list=criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return list;
	}

	@Override
	public List<PatientDetails> getPatientWithCity(String city) {
	List<PatientDetails> list= new ArrayList<>();
	
		Session session = null;
		
		try {
			session=sf.openSession();
			
			Criteria criteria=session.createCriteria(PatientDetails.class);
			
			criteria.add(Restrictions.eq("city",city));
			
			list=criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return list;
	}
	

	@Override
	public List<PatientDetails> getPatientWithState(String state) {
	List<PatientDetails> list=null;
		
		Session session = null;
		
		try {
			session=sf.openSession();
			
			Criteria criteria=session.createCriteria(PatientDetails.class);
			
			criteria.add(Restrictions.eq("state", state));
			
			list=criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return list;
	}

	@Override
	public List<PatientDetails> getPatientgotVaccinatedInDate(Date startdate, Date enddate) {
		List<PatientDetails> list=null;

		Session session = null;
		
		try {
			session=sf.openSession();
			
			Criteria criteria = session.createCriteria(PatientDetails.class);
			Criterion criterion1 = Restrictions.between("Dose1Date", startdate, enddate);
			Criterion criterion2 = Restrictions.between("Dose2Date", startdate, enddate);
			criteria.add(Restrictions.or(criterion1, criterion2));
			list = criteria.list();
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return list;
	}

    
    	 
    	 
    	 
    	 
     }
     
     
     
     
     
     
     
     
     
     
     

	