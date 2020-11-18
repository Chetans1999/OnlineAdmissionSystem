package com.cg.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {
	
	public List<Payment> findByEmailId(String emailId)throws ResourceNotFoundException;
	public Payment findByApplicationId(Long applicationId)throws ResourceNotFoundException;
	public List<Payment> findByPaymentStatus(String paymentStatus)throws ResourceNotFoundException;
}
