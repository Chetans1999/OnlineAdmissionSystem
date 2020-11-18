package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.rest.OnlineAdmissionSystemApplication;
import com.cg.rest.controller.CourseController;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Branch;
import com.cg.rest.model.Course;
import com.cg.rest.repository.ICourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineAdmissionSystemApplication.class)
public class CourseControllerTests {
	
	
	@Autowired
	private CourseController courseController;
	
	@MockBean
	private ICourseRepository courseRepository;
	
	@Test
	public void getAllCoursesTest() {
		Set<Branch> branchList1 = new HashSet<>();
		branchList1.add(new Branch("CS", "Computer"));
		branchList1.add(new Branch("EE", "Electrical"));
		
		Set<Branch> branchList2 = new HashSet<>();
		branchList2.add(new Branch("Accounts", "Bank Accounts"));
		branchList2.add(new Branch("SI", "SI&CI"));
		
		Course course = new Course("B.Tech", "Engineering", "10+2", branchList1);
		Course course2 = new Course("B.Com", "Banking", "10+2", branchList2);
		
		when(courseRepository.findAll()).thenReturn(Stream.of(course, course2).collect(Collectors.toList()));
		assertEquals(2, courseController.getAllCourses().getBody().size());
	}
	
	@Test
	public void getCourseByNameTest() throws ResourceNotFoundException {
		Set<Branch> branchList = new HashSet<>();
		branchList.add(new Branch("CS", "Computer"));
		branchList.add(new Branch("EE", "Electrical"));
		
		Course course = new Course("B.Tech", "Engineering", "10+2", branchList);
		
		String courseName = "AKTU";
		when(courseRepository.findByCourseName(courseName)).thenReturn(Stream.of(course).collect(Collectors.toSet()));
		assertEquals(1, courseController.getCourseByName(courseName).getBody().size());	
	}
	
	@Test
	public void addCollegeTest() {
		Set<Branch> branchList = new HashSet<>();
		branchList.add(new Branch("CS", "Computer"));
		branchList.add(new Branch("EE", "Electrical"));
		
		Course course = new Course("B.Tech", "Engineering", "10+2", branchList);
		
		when(courseRepository.save(course)).thenReturn(course);
		assertEquals(course, courseController.addCourse(course).getBody());
	}

}
