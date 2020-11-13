package com.cg.rest.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Branch;
import com.cg.rest.model.Course;
import com.cg.rest.service.IBranchServiceImpl;
import com.cg.rest.service.ICourseServiceImpl;

@RestController
public class CourseController {
	
	@Autowired
	private ICourseServiceImpl crsSer;
	
	@Autowired
	private IBranchServiceImpl brSer;
	
	@PostMapping("/courses/new")
	public Course addCourse(@RequestBody Course course) {
        return crsSer.save(course);
    }
	
	@GetMapping("/courses/all")
    public List<Course> getAllCourses() {
        return crsSer.findAll();
    }
	
	@GetMapping("/courses/getById/{id}")
    public ResponseEntity<Course> geCourseById(@PathVariable(value = "id") long courseId) throws ResourceNotFoundException {
		Course course = crsSer.findById(courseId);
        return ResponseEntity.ok().body(course);
    }
	
	@GetMapping("/courses/getByName/{name}")
    public Set<Course> getCourseByName(@PathVariable(value = "name") String courseName) throws ResourceNotFoundException {
		return crsSer.findByCourseName(courseName);
    }
	
	@GetMapping(("/courses/getByCollegeId/{id}"))
	public Set<Course> getCourseByCollegeId(@PathVariable(value = "id") long collegeId) throws ResourceNotFoundException{
		return crsSer.findByCollegeId(collegeId);
	}
	
	@DeleteMapping("/courses/delete/{id}")
    public Map<String, Boolean> deleteCourse(@PathVariable(value = "id") long courseId) throws ResourceNotFoundException {
		crsSer.delete(courseId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	@PutMapping("/courses/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") long courseId, @RequestBody Course courseDetails) throws ResourceNotFoundException {
		Course course = crsSer.findById(courseId);
		course.setCourseName(courseDetails.getCourseName());
		course.setDescription(courseDetails.getDescription());
		course.setEligibility(courseDetails.getEligibility());
		
//		Updating Mapped BranchList
		Iterator<Branch> it = course.getBranches().iterator();
		Set<Branch> brList = new HashSet<>();
		while(it.hasNext()) {
			Branch br = brSer.getBranchById(it.next().getBranchId());
			Iterator<Branch> it2 = courseDetails.getBranches().iterator();
			while(it2.hasNext()) {	
				Branch brNew = it2.next();
				br.setBranchName(brNew.getBranchName());
				br.setBranchDescription(brNew.getBranchDescription());
				brList.add(br);
			}
		}

		course.setBranches(brList);
        return ResponseEntity.ok(crsSer.save(course));
	}
	
/*	update 1(clones of child entities)
	@PutMapping("/courses/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") int courseId, @RequestBody Course courseDetails) throws ResourceNotFoundException {
		Course course = crsSer.findById(courseId);
		course.setCourseName(courseDetails.getCourseName());
		course.setDescription(courseDetails.getDescription());
		course.setEligibility(courseDetails.getEligibility());
		course.setBranches(courseDetails.getBranches());
        return ResponseEntity.ok(crsSer.save(course));
    }*/

}