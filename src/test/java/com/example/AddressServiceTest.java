package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Address;
import com.cg.rest.repository.IAddressRepository;
import com.cg.rest.service.IAddressServiceImpl;
import com.sun.el.stream.Stream;


@ExtendWith(MockitoExtension.class)
class AddressServiceTest {
	
	@Mock
	private IAddressRepository addRepository;
	
	@InjectMocks
	private IAddressServiceImpl iaddService;
	
	@Test
	void saveTest()
	{
		Address add =new Address("Pune","Pune","Maharastra","India",265987,"Hanjiwadi");
		when(addRepository.save(add)).thenReturn(add);
		assertEquals(add, iaddService.save(add));
	}
	

}
