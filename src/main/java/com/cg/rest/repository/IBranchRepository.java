package com.cg.rest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.rest.model.Branch;

@Repository
public interface IBranchRepository extends JpaRepository<Branch, Long>{
	
	public List<Branch> findByBranchName(String branchName);

}
