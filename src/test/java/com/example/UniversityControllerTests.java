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
import com.cg.rest.controller.UniversityController;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Address;
import com.cg.rest.model.Branch;
import com.cg.rest.model.College;
import com.cg.rest.model.Course;
import com.cg.rest.model.Program;
import com.cg.rest.model.University;
import com.cg.rest.repository.IUniversityRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineAdmissionSystemApplication.class)
public class UniversityControllerTests {
	
	@Autowired
	private UniversityController universityController;
	
	@MockBean
	@Autowired
	private IUniversityRepository universityRepository;
	
	@Test
	public void getAllUniversitiesTest() {
		
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

		Set<College> collegeList = new HashSet<>();
		collegeList.add(new College("BBD", new Address("Lucknow", "Lucknow", "UP", "India", 226010, "BBD Green City"), programList, courseList));

		University university = new University("AKTU",  new Address("Lucknow", "Lucknow", "UP", "India", 226002, "Silver Line"), collegeList);
		
		University university2 = new University("UPTU",  new Address("Kanpur", "Kanpur", "UP", "India", 226010, "XYZ"), collegeList);
		
		when(universityRepository.findAll()).thenReturn(Stream.of(university, university2).collect(Collectors.toList()));
		assertEquals(2, universityController.getAllUniversities().getBody().size());
	}
	
	@Test
	public void getUniversityByNameTest() throws ResourceNotFoundException {
		
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

		Set<College> collegeList = new HashSet<>();
		collegeList.add(new College("BBD", new Address("Lucknow", "Lucknow", "UP", "India", 226010, "BBD Green City"), programList, courseList));

		University university = new University("AKTU",  new Address("Lucknow", "Lucknow", "UP", "India", 226002, "Silver Line"), collegeList);
		
		String universityName = "AKTU";
		System.err.println(universityRepository.findByUniversityName(universityName));
		when(universityRepository.findByUniversityName(universityName)).thenReturn(Stream.of(university).collect(Collectors.toSet()));
		assertEquals(1, universityController.getUniversityByName(universityName).getBody().size());
	}

	
	@Test
	public void addUniversityTest() {
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

		Set<College> collegeList = new HashSet<>();
		collegeList.add(new College("BBD", new Address("Lucknow", "Lucknow", "UP", "India", 226010, "BBD Green City"), programList, courseList));
		
		University university = new University("AKTU",  new Address("Lucknow", "Lucknow", "UP", "India", 226002, "Silver Line"), collegeList);
		
		when(universityRepository.save(university)).thenReturn(university);
		assertEquals(university, universityController.addUniversity(university).getBody());
	}


}
