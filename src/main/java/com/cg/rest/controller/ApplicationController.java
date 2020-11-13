package com.cg.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Application;
import com.cg.rest.service.IApplicationServiceImpl;


@RestController
public class ApplicationController {

	@Autowired
	private IApplicationServiceImpl iapplicationServiceImpl;
	
	@PostMapping("/application/new")
	public Application addApplication(@RequestBody Application application) {
	
		return iapplicationServiceImpl.save(application);
	
	}
	
	@GetMapping("/application/all")
	public List<Application> viewAllApplication(){
		return iapplicationServiceImpl.findAll();
	}
	
	@GetMapping("/application/getbyemail/{emailId}")
	public List<Application> viewApplicationByEmail(@PathVariable(value="emailId")String emailId)throws ResourceNotFoundException {
		return iapplicationServiceImpl.findByEmailId(emailId);
	}
	
	
	
	@GetMapping("/application/getbyapplicationid/{id}")
	public ResponseEntity<Application> viewApplicationById(@PathVariable(value="id")Integer applicationId)throws ResourceNotFoundException{
		Application application=iapplicationServiceImpl.findById(applicationId);
		return ResponseEntity.ok().body(application);
	}

	@DeleteMapping("/application/delete/{applicationId}")
		public Map<String, Boolean> deleteById(@PathVariable(value="applicationId")Integer applicationId)throws ResourceNotFoundException{
			iapplicationServiceImpl.delete(applicationId);
			Map<String, Boolean> response = new HashMap<>();
			response.put("Deleted", Boolean.TRUE);
			return response;
		}
		
	
	@GetMapping("/application/getbyapplicationstatus/{applicationStatus}")
	public List<Application> viewByApplicationStatus(@PathVariable(value="applicationStatus")String applicationStatus)throws ResourceNotFoundException{
		return iapplicationServiceImpl.findByApplicationStatus(applicationStatus);
	}
	
	
	@PutMapping("/application/update/{id}")
	public ResponseEntity<Application> updateApplication(@PathVariable(value = "id") Integer applicationId, @RequestBody Application applicationDetails) throws ResourceNotFoundException {
		Application application = iapplicationServiceImpl.findById(applicationId);
		application.setApllicantFullName(applicationDetails.getApllicantFullName());
		application.setDateOfBirth(applicationDetails.getDateOfBirth());
		application.setHighestQualification(applicationDetails.getHighestQualification());
		application.setFinalYearPercentage(applicationDetails.getFinalYearPercentage());
		application.setGoals(applicationDetails.getGoals());
		application.setEmailId(applicationDetails.getEmailId());
		application.setUniversityId(applicationDetails.getUniversityId());
		application.setCollegeId(applicationDetails.getCollegeId());
		application.setProgramId(applicationDetails.getProgramId());
		application.setCourseId(applicationDetails.getCourseId());
		application.setBranchId(applicationDetails.getBranchId());
		application.setApplicationStatus(applicationDetails.getApplicationStatus());
		Application updateApplication = iapplicationServiceImpl.save(application);
		return ResponseEntity.ok(updateApplication);
	}
	
}
