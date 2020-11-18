package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.given;


import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Payment;
import com.cg.rest.repository.IPaymentRepository;
import com.cg.rest.service.IPaymentServiceImpl;


@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {
	
	@Mock
	private IPaymentRepository payRepository;
	
	@InjectMocks
	private IPaymentServiceImpl ipayService;
	
	@Test
	void saveTest()
	{
		Payment pay=new Payment(1L,"vini@gmail.com",100L,5200,"Mobile Banking","Partial");
		when(payRepository.save(pay)).thenReturn(pay);
		assertEquals(pay,ipayService.save(pay));
	}
	
	@Test
	void findAllTest()
	{
	     
	     List<Payment> datas = new ArrayList();
	     datas.add(new Payment(1L, "vini@gmail.com",100L,5200,"Mobile Banking","Partial"));
	     datas.add(new Payment(2L, "bunny@gmail.com",101L,52000,"Mobile Banking","Completed"));
	     given(payRepository.findAll()).willReturn(datas);
	     
	     List<Payment> expected=ipayService.findAll();
	     
	     assertEquals(expected,datas);
	
	}
	
	@Test
	void findByEmailIdTest() throws ResourceNotFoundException
	{
		String emailId="vini@gmail.com";
		when(payRepository.findByEmailId(emailId)).thenReturn(Stream.of(new Payment(1L, "vini@gmail.com",100L,5200,"Mobile Banking","Partial")).collect(Collectors.toList()));
		assertEquals(1, ipayService.findByEmailId(emailId).size());
	}
		
	@Test
	void findByPaymentStatus() throws ResourceNotFoundException
	{
		String paymentStatus="Partial";
		when(payRepository.findByPaymentStatus(paymentStatus)).thenReturn(Stream.of(new Payment(1L, "vini@gmail.com",100L,5200,"Mobile Banking","Partial")).collect(Collectors.toList()));
		assertEquals(1, ipayService.findByPaymentStatus(paymentStatus).size());
	}
	
	
}
