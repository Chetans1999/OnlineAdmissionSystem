package com.cg.rest.service;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Program;

public interface IProgramService {
	
	public Program findById(Long programId) throws ResourceNotFoundException;	

}
