package com.cg.rest.service;

import java.util.List;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Branch;

public interface IBranchService {
	public Branch addBranch(Branch branch);
	public List<Branch> viewAllBranchDetails();
	public List<Branch>findByBranchName (String branchName)throws ResourceNotFoundException;
	public void deleteBranchById(Long branchId)throws ResourceNotFoundException ;
	public Branch getBranchById(Long branchId) throws ResourceNotFoundException ;
	
}
