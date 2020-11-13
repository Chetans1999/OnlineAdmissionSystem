package com.cg.rest.service;

import java.util.List;
import java.util.Set;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Course;

public interface ICourseService {
	 public Course save(Course course);
	 public List<Course> findAll();
	 public Course findById(long courseId) throws ResourceNotFoundException;
	 public void delete(long courseId) throws ResourceNotFoundException;
	 public Set<Course> findByCourseName(String courseName) throws ResourceNotFoundException;
	 public Set<Course> findByCollegeId(long collegeId) throws ResourceNotFoundException;

}
