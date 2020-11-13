package com.cg.rest.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.College;

public interface ICollegeService {
	 public College save(College college);
	 public List<College> findAll();
	 public College findById(long collegeId) throws ResourceNotFoundException;
	 public void delete(long collegeId) throws ResourceNotFoundException;
	 public Set<College> findByCollegeName(String collegeName) throws ResourceNotFoundException;
	 public ResponseEntity<College> updateCollegeById(long collegeId, College collegeNew, College collegeOld) throws ResourceNotFoundException;

}
