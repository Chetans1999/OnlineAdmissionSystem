package com.cg.rest.service;


import java.util.List;

import com.cg.rest.exception.ResourceNotFoundException;

import com.cg.rest.model.Program;




public interface IProgramService {
	
	public Program save(Program program);
	public List<Program> findAll();
	public void delete(Long programId) throws ResourceNotFoundException;
	public Program findById(Long programId) throws ResourceNotFoundException;
	public void deleteAll();

}
