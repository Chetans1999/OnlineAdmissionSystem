package com.cg.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import com.cg.rest.model.College;
import com.cg.rest.service.ICollegeServiceImpl;

@RestController
public class CollegeController {
	
	@Autowired
	private ICollegeServiceImpl collSer;
	
	@PostMapping("/colleges/new")
	public College addCollege(@RequestBody College college) {
        return collSer.save(college);
    }
	
	@GetMapping("/colleges/all")
    public List<College> getAllColleges() {
        return collSer.findAll();
    }
	
	@GetMapping("/colleges/getById/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable(value = "id") long collegeId) throws ResourceNotFoundException {
		College college = collSer.findById(collegeId);
        return ResponseEntity.ok().body(college);
    }
	
	@DeleteMapping("/colleges/delete/{id}")
    public Map<String, Boolean> deleteCollege(@PathVariable(value = "id") long collegeId) throws ResourceNotFoundException {
		collSer.delete(collegeId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	@GetMapping("/colleges/getByName/{name}")
    public Set<College> getCollegeByName(@PathVariable(value = "name") String collegeName) throws ResourceNotFoundException {
		return collSer.findByCollegeName(collegeName);
    }
	
	@PutMapping("/colleges/update/{id}")
	public ResponseEntity<College> updateCollege(@PathVariable(value = "id") long collegeId, @RequestBody College collegeDetails) throws ResourceNotFoundException {
		College collegeOld = collSer.findById(collegeId);
		College updatedCollege = collSer.updateCollegeById(collegeId, collegeDetails, collegeOld).getBody();
        return ResponseEntity.ok(collSer.save(updatedCollege));
	}
	
/*	update 1(clones of child entities)
	@PutMapping("/colleges/update/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable(value = "id") int collegeId, @RequestBody College collegeDetails) throws ResourceNotFoundException {
		College college = collSer.findById(collegeId);
		college.setCollegeName(collegeDetails.getCollegeName());
		
		college.setCollegeAddress(collegeDetails.getCollegeAddress());
		college.setProgramList(collegeDetails.getProgramList());
		college.setCourseList(collegeDetails.getCourseList());
        return ResponseEntity.ok(collSer.save(college));
    }*/

}
