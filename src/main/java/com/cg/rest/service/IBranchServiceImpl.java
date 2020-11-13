package com.cg.rest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Branch;
import com.cg.rest.repository.IBranchRepository;

@Component
public class IBranchServiceImpl implements IBranchService {

	@Autowired
	private IBranchRepository brRep;

	@Override
	public Branch addBranch(Branch branch) {
		return brRep.save(branch);
	}

	@Override
	public List<Branch> viewAllBranchDetails(){
		return brRep.findAll();
	}

	@Override
	public Branch getBranchById(Long branchId)throws ResourceNotFoundException{
		return brRep.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("No Branch found with this ID : " + branchId));
	}

	@Override
	public List<Branch> findByBranchName(String branchName) throws ResourceNotFoundException {
		List<Branch> brList = brRep.findByBranchName(branchName);
		if(brList.isEmpty()) {
			throw new ResourceNotFoundException("No branch Found with this name : " + branchName);
		}
		return brList;
	}

	@Override
	public void deleteBranchById(Long branchId)throws ResourceNotFoundException {
		Branch branch = brRep.findById(branchId).orElseThrow(() -> new ResourceNotFoundException("No Branch found with this ID : " + branchId));
		brRep.delete(branch); 
	}

	
}



