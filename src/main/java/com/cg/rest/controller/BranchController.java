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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Branch;
import com.cg.rest.service.IBranchServiceImpl;



@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private IBranchServiceImpl brSer;

	@PostMapping("/new")
	public Branch addBranch(@RequestBody Branch branch) {
		return brSer.addBranch(branch);
	}
	@GetMapping("/all")
	public List<Branch> viewAllBranchDetails(){
		return brSer.viewAllBranchDetails();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Branch> getBranchById(@PathVariable(value = "id") Long branchId) throws ResourceNotFoundException  {
		Branch branch = brSer.getBranchById(branchId);
		return ResponseEntity.ok().body(branch);
	}

	@GetMapping("/getBranchByName/{name}")
	public List<Branch> findByBranchName(@PathVariable(value = "name") String branchName) throws ResourceNotFoundException {
		return brSer.findByBranchName(branchName);
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteBranchById(@PathVariable(value = "id") Long branchId) throws ResourceNotFoundException {
		brSer.deleteBranchById(branchId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Branch> updateBranch(@PathVariable(value = "id") Long branchId, @RequestBody Branch branchdetails) throws ResourceNotFoundException  {
		Branch branch = brSer.getBranchById(branchId);	
		branch.setBranchName(branchdetails.getBranchName());
		branch.setBranchDescription(branchdetails.getBranchDescription());
		Branch updateBranch = brSer.addBranch(branch);
		return ResponseEntity.ok().body(updateBranch);
	}
}