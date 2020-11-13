package com.cg.rest.repository;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Course;

public interface ICourseRepository extends JpaRepository<Course, Long> {
	
	public Set<Course> findByCourseName(String courseName) throws ResourceNotFoundException;
	
	@Query(value = "select cc.course_list_course_id from college_course_list cc where cc.college_college_reg_id = ?1", nativeQuery = true)
	public Set<Long> findCourseIdListByCollegeId(long collegeId) throws ResourceNotFoundException;

}
