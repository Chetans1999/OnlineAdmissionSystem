package com.cg.rest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Branch;
import com.cg.rest.repository.IBranchRepository;

@Service
public class IBranchServiceImpl implements IBranchService {

	@Autowired
	private IBranchRepository brRep;

	public Branch addBranch(Branch branch) 
	{
		return brRep.save(branch);
	}

	public List<Branch> viewAllBranchDetails() 
	{
		return brRep.findAll();
	}

	public Branch getBranchById(Long branchId)throws ResourceNotFoundException
	{
		Branch br = brRep.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("No branch Found with this id : " + branchId)) ;
		return br;
	}

	public List<Branch> findByBranchName(String branchName) throws ResourceNotFoundException 
	{
		List<Branch> brList = brRep.findByBranchName(branchName);
		if(brList.isEmpty()) {
			throw new ResourceNotFoundException("No branch Found with this name : " + branchName);
		}
		return brList;
	}

	public void deleteBranchById(Long branchId)throws ResourceNotFoundException 
	{
		Branch branch = brRep.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("No branch Found with this id : " + branchId));
		brRep.delete(branch); 
	}

	
}



