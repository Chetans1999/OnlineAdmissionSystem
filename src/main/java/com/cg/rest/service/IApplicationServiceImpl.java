package com.cg.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Application;

import com.cg.rest.repository.ApplicationRepository;

@Component
public class IApplicationServiceImpl implements IApplicationService{

	@Autowired
	private ApplicationRepository appliRepo;

	
	public Application save(Application application) {
		
		return appliRepo.save(application);
	}
	
	public List<Application> findAll() {
		return appliRepo.findAll();
	}

	public List<Application> findByEmailId(String emailId) throws ResourceNotFoundException {
		List<Application> appliList=appliRepo.findByEmailId(emailId);
		if(appliList.isEmpty()) {
			throw new ResourceNotFoundException("No Application found with this Email :" + emailId);
		}
		return appliList;
	}
	
	public Application findById(Integer applicationId) throws ResourceNotFoundException{
		Application application = appliRepo.findById(applicationId).orElseThrow(() -> new ResourceNotFoundException("No Application Found with this id : " + applicationId));
		return application;
	}
	
	public List<Application> findByApplicationStatus(String applicationStatus) throws ResourceNotFoundException {
		List<Application> appliList=appliRepo.findByApplicationStatus(applicationStatus);
		if(appliList.isEmpty()) {
			throw new ResourceNotFoundException("No Application found with this Status :" + applicationStatus);
		}
		return appliList;
	}

	public void delete(Integer applicationId) throws ResourceNotFoundException {
    	Application appli = appliRepo.findById(applicationId).orElseThrow(() -> new ResourceNotFoundException("No Application Found with this id : " + applicationId));
    	appliRepo.delete(appli);
	}

	

	public int updateApplicationDetails(Application application) {
		return 0;
	}
	
}
