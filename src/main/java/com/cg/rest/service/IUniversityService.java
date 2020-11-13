package com.cg.rest.service;

import java.util.List;
import java.util.Set;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.University;

public interface IUniversityService {
	public University save(University university);
    public List<University> findAll();
    public University findById(long universityId) throws ResourceNotFoundException;
    public void delete(long universityId) throws ResourceNotFoundException;
    public void deleteAll();
    public Set<University> findByUniversityName(String universityName) throws ResourceNotFoundException;

}
 