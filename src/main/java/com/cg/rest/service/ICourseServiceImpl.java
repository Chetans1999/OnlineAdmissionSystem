package com.cg.rest.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Course;
import com.cg.rest.repository.ICourseRepository;

@Component
public class ICourseServiceImpl implements ICourseService {
	
	@Autowired
	private ICourseRepository iCrsRepo;

	@Override
	public Course save(Course course) {
		return iCrsRepo.save(course);
	}

	@Override
	public List<Course> findAll() {
		return iCrsRepo.findAll();
	}

	@Override
	public Course findById(long courseId) throws ResourceNotFoundException {
		return iCrsRepo.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("No Course found with this ID : " + courseId));
	}

	@Override
	public void delete(long courseId) throws ResourceNotFoundException {
		Course course = iCrsRepo.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("No College Found with this ID : " + courseId));
        iCrsRepo.delete(course);			
	}

	@Override
	public Set<Course> findByCourseName(String courseName) throws ResourceNotFoundException {
		Set<Course> crsList = iCrsRepo.findByCourseName(courseName);
		if(crsList.isEmpty()) {
			throw new ResourceNotFoundException("No Course Found with this name : " + courseName);
		}
		return crsList;
	}

	@Override
	public Set<Course> findByCollegeId(long collegeId) throws ResourceNotFoundException {
		Set<Long> crsIdList = iCrsRepo.findCourseIdListByCollegeId(collegeId);
		if(crsIdList.isEmpty()) {
			throw new ResourceNotFoundException("No College Found with this ID : " + collegeId);
		}		
		Set<Course> crsList = new HashSet<>();
		for(Long crsId :crsIdList) {
			Course c = iCrsRepo.findById(crsId).orElseThrow(() -> new ResourceNotFoundException("No Course Found with this ID : " + crsId));
			crsList.add(c);
		}
		return crsList;
	}

}