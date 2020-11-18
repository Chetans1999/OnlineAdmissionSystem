package com.cg.rest.service;

import java.util.List;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Application;

public interface IApplicationService {

	public Application save(Application application);
	public List<Application> findAllApplication();
	public List<Application> findByEmailId(String emailId) throws ResourceNotFoundException;
	public Application findById(Long applicationId) throws ResourceNotFoundException;
	public List<Application> findByApplicationStatus(String applicationStatus) throws ResourceNotFoundException;
	public void delete(Long applicationId) throws ResourceNotFoundException;
	public int updateApplicationDetails(Application application);
}
