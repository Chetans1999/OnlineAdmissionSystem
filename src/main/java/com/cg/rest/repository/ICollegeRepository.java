package com.cg.rest.repository;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.College;

public interface ICollegeRepository extends JpaRepository<College, Long>{

	public Set<College> findByCollegeName(String collegeName) throws ResourceNotFoundException;

}
