package com.cg.rest.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.cg.rest.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.rest.model.Address;
import com.cg.rest.model.College;
import com.cg.rest.model.University;
import com.cg.rest.service.IAddressServiceImpl;
import com.cg.rest.service.ICollegeServiceImpl;
import com.cg.rest.service.IUniversityServiceImpl;

@RestController
public class UniversityController {

	@Autowired
	private IUniversityServiceImpl uniSer;

	@Autowired
	private IAddressServiceImpl addSer;

	@Autowired
	private ICollegeServiceImpl collSer;

	@PostMapping("/universities/new")
	public ResponseEntity<University> addUniversity(@RequestBody University newUniversity) {
		University university = uniSer.save(newUniversity);
		return ResponseEntity.ok().body(university);
	}

	@GetMapping("/universities/all")
	public ResponseEntity<List<University>> getAllUniversities() {
		return ResponseEntity.ok(uniSer.findAll());
	}

	@GetMapping("/universities/getById/{id}")
	public ResponseEntity<University> getUniversityById(@PathVariable(value = "id") long universityId) throws ResourceNotFoundException {
		University university = uniSer.findById(universityId);
		return ResponseEntity.ok().body(university);
	}

	@DeleteMapping("/universities/delete/{id}")
	public Map<String, Boolean> deleteUniversity(@PathVariable(value = "id") long universityId) throws ResourceNotFoundException {
		uniSer.delete(universityId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@DeleteMapping("/universities/deleteAll")
	public Map<String, Boolean> deleteAllUniversities() {
		uniSer.deleteAll();
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted all", Boolean.TRUE);
		return response;
	}

	@GetMapping("/universities/getByName/{name}")
	public ResponseEntity<Set<University>> getUniversityByName(@PathVariable(value = "name") String universityName) throws ResourceNotFoundException {
		return ResponseEntity.ok(uniSer.findByUniversityName(universityName));
	}

	@PutMapping("/universities/update/{id}")
	public ResponseEntity<University> updateUniversity(@PathVariable(value = "id") long universityId, @RequestBody University universityDetails) throws ResourceNotFoundException {
		University university = uniSer.findById(universityId);
		university.setUniversityName(universityDetails.getUniversityName());
		
//		Updating Mapped UniversityAddress
		Address add = addSer.findById(university.getAddress().getAddressId());
		add.setCity(universityDetails.getAddress().getCity());
		add.setCountry(universityDetails.getAddress().getCountry());
		add.setCountry(universityDetails.getAddress().getDistrict());
		add.setLandmark(universityDetails.getAddress().getLandmark());
		add.setState(universityDetails.getAddress().getState());
		add.setZipcode(universityDetails.getAddress().getZipcode());
		university.setAddress(add);
		
//		Updating Mapped College
		Iterator<College> it = university.getCollegeList().iterator();
		Iterator<College> it2 = universityDetails.getCollegeList().iterator();
		LinkedHashSet<College> collList = new LinkedHashSet<>();
		while(it.hasNext()) {
			College coll = collSer.findById(it.next().getCollegeRegId());	
			College cNew = it2.next();
			ResponseEntity<College> coll2 = collSer.updateCollegeById(coll.getCollegeRegId(), cNew, coll);      //add another argument coll to get IDs
			collList.add(coll2.getBody());
		}
		university.setCollegeList(collList);

		University updatedUniversity = uniSer.save(university);
		return ResponseEntity.ok(updatedUniversity);
	}



}
