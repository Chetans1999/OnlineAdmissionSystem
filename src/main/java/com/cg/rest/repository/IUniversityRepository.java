package com.cg.rest.repository;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.University;

public interface IUniversityRepository extends JpaRepository<University, Long>{
	
	public Set<University> findByUniversityName(String universityName) throws ResourceNotFoundException;
	

}
