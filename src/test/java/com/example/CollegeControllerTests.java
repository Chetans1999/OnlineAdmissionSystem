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
import com.cg.rest.controller.CollegeController;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Address;
import com.cg.rest.model.Branch;
import com.cg.rest.model.College;
import com.cg.rest.model.Course;
import com.cg.rest.model.Program;
import com.cg.rest.repository.ICollegeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineAdmissionSystemApplication.class)
public class CollegeControllerTests {
	
	@Autowired
	private CollegeController collegeController;
	
	@MockBean
	private ICollegeRepository collegeRepository;
	
	@Test
	public void getAllCollegesTest() {
		Set<Branch> branchList1 = new HashSet<>();
		branchList1.add(new Branch("CS", "Computer"));
		branchList1.add(new Branch("EE", "Electrical"));
		
		Set<Branch> branchList2 = new HashSet<>();
		branchList2.add(new Branch("Accounts", "Bank Accounts"));
		branchList2.add(new Branch("SI", "SI&CI"));
		
		Set<Course> courseList = new HashSet<>();
		courseList.add(new Course("B.Tech", "Engineering", "10+2", branchList1));
		courseList.add(new Course("B.Com", "Banking", "10+2", branchList2));
		
		Set<Program> programList = new HashSet<>();
		programList.add(new Program("Graduation", "After 12", "10+2", "4 years", "Graduate Degree"));
		programList.add(new Program("Diploma", "After 10", "10", "4 years", "Diploma Certificate"));
		
		College college = new College("BBD NITM", new Address("Lucknow", "Lucknow", "UP", "India", 226002, "Silver Line"), programList, courseList);
		College college2 = new College("BBD NIIT", new Address("Lucknow", "Lucknow", "UP", "India", 226002, "XYZ"), programList, courseList);

		when(collegeRepository.findAll()).thenReturn(Stream.of(college, college2).collect(Collectors.toList()));
		assertEquals(2, collegeController.getAllColleges().getBody().size());
	}
	
	@Test
	public void getCollegeByNameTest() throws ResourceNotFoundException {
		Set<Branch> branchList1 = new HashSet<>();
		branchList1.add(new Branch("CS", "Computer"));
		branchList1.add(new Branch("EE", "Electrical"));
		
		Set<Branch> branchList2 = new HashSet<>();
		branchList2.add(new Branch("Accounts", "Bank Accounts"));
		branchList2.add(new Branch("SI", "SI&CI"));
		
		Set<Course> courseList = new HashSet<>();
		courseList.add(new Course("B.Tech", "Engineering", "10+2", branchList1));
		courseList.add(new Course("B.Com", "Banking", "10+2", branchList2));
		
		Set<Program> programList = new HashSet<>();
		programList.add(new Program("Graduation", "After 12", "10+2", "4 years", "Graduate Degree"));
		programList.add(new Program("Diploma", "After 10", "10", "4 years", "Diploma Certificate"));
		
		College college = new College("BBD NITM", new Address("Lucknow", "Lucknow", "UP", "India", 226002, "Silver Line"), programList, courseList);
		
		String collegeName = "AKTU";
		when(collegeRepository.findByCollegeName(collegeName)).thenReturn(Stream.of(college).collect(Collectors.toSet()));
		assertEquals(1, collegeController.getCollegeByName(collegeName).getBody().size());
	}
	
	@Test
	public void addCollegeTest() {
		Set<Branch> branchList1 = new HashSet<>();
		branchList1.add(new Branch("CS", "Computer"));
		branchList1.add(new Branch("EE", "Electrical"));
		
		Set<Branch> branchList2 = new HashSet<>();
		branchList2.add(new Branch("Accounts", "Bank Accounts"));
		branchList2.add(new Branch("SI", "SI&CI"));
		
		Set<Course> courseList = new HashSet<>();
		courseList.add(new Course("B.Tech", "Engineering", "10+2", branchList1));
		courseList.add(new Course("B.Com", "Banking", "10+2", branchList2));
		
		Set<Program> programList = new HashSet<>();
		programList.add(new Program("Graduation", "After 12", "10+2", "4 years", "Graduate Degree"));
		programList.add(new Program("Diploma", "After 10", "10", "4 years", "Diploma Certificate"));

		College college = new College("BBD NITM", new Address("Lucknow", "Lucknow", "UP", "India", 226002, "Silver Line"), programList, courseList);
		
		when(collegeRepository.save(college)).thenReturn(college);
		assertEquals(college, collegeController.addCollege(college).getBody());
	}

}
