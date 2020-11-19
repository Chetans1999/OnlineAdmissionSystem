package com.cg.rest.service;

import java.util.List;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Payment;



public interface IPaymentService
{
	public Payment save(Payment payment);
	public List<Payment> findAll();
	public List<Payment> findByEmailId(String emailId) throws ResourceNotFoundException;
	public Payment findById(Long paymentId) throws ResourceNotFoundException;
	public Payment findByApplicationId(Long applicationId) throws ResourceNotFoundException;
	public List<Payment> findByPaymentStatus(String paymentStatus) throws ResourceNotFoundException;
	public void delete(Long paymentId) throws ResourceNotFoundException;

}