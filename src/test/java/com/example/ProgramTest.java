package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.rest.model.Program;
import com.cg.rest.model.User;
import com.cg.rest.repository.IProgramRepository;

import com.cg.rest.service.IProgramServiceImpl;



@ExtendWith(MockitoExtension.class)
public class ProgramTest {
	
	@Mock
	private IProgramRepository programRepo;
	@InjectMocks
	private IProgramServiceImpl iprogramServ;
	
	@Test
	public void viewAllProgramDetailsTest() {
		
		Program program = new Program("PostGraduation","PostGraduate","Graduation","2Years","MBA");
		List<Program> us = new ArrayList<Program>();
		us.add(program);
		Mockito.when(programRepo.findAll()).thenReturn(us);
		assertEquals(iprogramServ.findAll(),us);
	}
	
	@Test
	public void saveProgramTest() {
		Program program = new Program("PostGraduation","PostGraduate","Graduation","2Years","MBA");
        when(programRepo.save(program)).thenReturn(program);
        assertEquals(program,iprogramServ.save(program));
	}
	
	
	@Test
	public void deleteProgramTest() {
		Program program = new Program("PostGraduation","PostGraduate","Graduation","2Years","MBA");
        iprogramServ.deleteAll();
        verify(programRepo,times(1)).deleteAll();
	}

}
