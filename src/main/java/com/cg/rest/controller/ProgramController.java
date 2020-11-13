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
import com.cg.rest.model.Program;
import com.cg.rest.service.IProgramServiceImpl;


@RestController
public class ProgramController {
	
	@Autowired
	private IProgramServiceImpl iprogramServiceImpl;
	
	
	@PostMapping("/program/new")
	public Program addProgram(@RequestBody Program program) {
		return iprogramServiceImpl.save(program);
	}
	
	@GetMapping("/program/all")
    public List<Program> getAllPrograms() {
        return iprogramServiceImpl.findAll();
    }
	
	@GetMapping("/program/get/{id}")
    public ResponseEntity<Program> getProgramById(@PathVariable(value = "id") Long programId) throws ResourceNotFoundException {
		Program program = iprogramServiceImpl.findById(programId);
        return ResponseEntity.ok().body(program);
    }
	
	@DeleteMapping("/program/delete/{id}")
    public Map<String, Boolean> deleteProgram(@PathVariable(value = "id") Long programId) throws ResourceNotFoundException {
        iprogramServiceImpl.delete(programId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	@DeleteMapping("/program/deleteAll")
	public Map<String, Boolean> deleteAllProgram() {
		iprogramServiceImpl.deleteAll();
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted all", Boolean.TRUE);
	    return response;
	}
	
	@PutMapping("/program/update/{id}")
	 public ResponseEntity<Program> updateProgram(@PathVariable(value = "id") Long programId, @RequestBody Program programDetails) throws ResourceNotFoundException {
		Program program = iprogramServiceImpl.findById(programId);
		program.setProgramName(programDetails.getProgramName());
		program.setEligibility(programDetails.getEligibility());
		program.setDuration(programDetails.getDuration());
		program.setDegreeOffered(programDetails.getDegreeOffered());
      
       Program updatedProgram = iprogramServiceImpl.save(program);
       return ResponseEntity.ok(updatedProgram);
   }
	
	
}
