package com.cg.rest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Program;
import com.cg.rest.repository.IProgramRepository;

@Component
public class IProgramServiceImpl implements IProgramService {

	@Autowired
	private IProgramRepository iprogramRepo;
	
	
	public Program save(Program program) {
		return iprogramRepo.save(program);
	}
	
	public List<Program> findAll() {
        return iprogramRepo.findAll();
    }
	
	public void delete(Long programId) throws ResourceNotFoundException {
	    	Program program = iprogramRepo.findById(programId).orElseThrow(() -> new ResourceNotFoundException("No Program Found with this id : " + programId));
	        iprogramRepo.delete(program);
	}
	 
	public Program findById(Long programId) throws ResourceNotFoundException {
			return iprogramRepo.findById(programId).orElseThrow(() -> new ResourceNotFoundException("No Program Found with this id : " + programId));
	}
		
	public void deleteAll() {
				iprogramRepo.deleteAll();
	}


}
