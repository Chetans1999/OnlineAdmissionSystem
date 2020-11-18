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

//import com.cg.rest.SpringbootRestJpaCrudDemoApplication;
import com.cg.rest.model.User;
import com.cg.rest.repository.UserRepository;
import com.cg.rest.service.IUserService;
import com.cg.rest.service.IUserServiceImpl;



@ExtendWith(MockitoExtension.class)
class UserTest {

	@Mock
	private UserRepository userRepo;
	@InjectMocks
	private IUserServiceImpl iUserServ;
	
	@Test
	public void viewAllUserDetailsTest() {
		
		User user = new User(1L,"Chetan","Kumar","Sharma","chetansharma@gmail.com",21212L,2121212L,"pass");
		List<User> us = new ArrayList<User>();
		us.add(user);
		Mockito.when(userRepo.findAll()).thenReturn(us);
		assertEquals(iUserServ.findAll(),us);
	}
	

	
	@Test
	public void saveUserTest() {
		User user = new User(1L,"Chetan","Kumar","Sharma","chetansharma@gmail.com",21212L,2121212L,"pass");
        when(userRepo.save(user)).thenReturn(user);
        assertEquals(user,iUserServ.save(user));
	}
	
	
	@Test
	public void deleteUserTest() {
		User user = new User(1L,"Chetan","Kumar","Sharma","chetansharma@gmail.com",21212L,2121212L,"pass");
        iUserServ.deleteAll();
        verify(userRepo,times(1)).deleteAll();
	}
	



}
