
package com.cg.rest.service;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.University;
import com.cg.rest.repository.IUniversityRepository;

@Component
public class IUniversityServiceImpl implements IUniversityService{
	
	@Autowired
	private IUniversityRepository iUniRepo;

	@Override
	public University save(University university) {
		return iUniRepo.save(university);
	}

	@Override
	public List<University> findAll() {
		return iUniRepo.findAll();
	}

	@Override
	public University findById(long universityId) throws ResourceNotFoundException {
		return iUniRepo.findById(universityId).orElseThrow(() -> new ResourceNotFoundException("No University Found with this id : " + universityId));
	}

	@Override
	public void delete(long universityId) throws ResourceNotFoundException {
    	University university = iUniRepo.findById(universityId).orElseThrow(() -> new ResourceNotFoundException("No University Found with this id : " + universityId));
        iUniRepo.delete(university);	
    }

	@Override
	public void deleteAll() {
		iUniRepo.deleteAll();
	}

	@Override
	public Set<University> findByUniversityName(String universityName) throws ResourceNotFoundException {
		Set<University> university = iUniRepo.findByUniversityName(universityName);
		if(university.isEmpty()) {
			throw new ResourceNotFoundException("No University Found with this name : " + universityName);
		}
		return university;
	}

	
}
