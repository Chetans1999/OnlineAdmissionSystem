package com.cg.rest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Payment;
import com.cg.rest.repository.IPaymentRepository;

@Component
public class IPaymentServiceImpl implements IPaymentService 
{
	@Autowired
	private IPaymentRepository pyRepo;

	public Payment save(Payment payment) {
		return pyRepo.save(payment);
	}

	public List<Payment> findAll() {
		return pyRepo.findAll();
	}

	public List<Payment> findByEmailId(String emailId) throws ResourceNotFoundException {
		List<Payment> pyList=pyRepo.findByEmailId(emailId);
		if(pyList.isEmpty()) {
			throw new ResourceNotFoundException("No Payment found with this Email :" + emailId);
		}
		return pyList;
	}

	public Payment findById(Long paymentId) throws ResourceNotFoundException {
		return (pyRepo.findById(paymentId).orElseThrow(()-> new ResourceNotFoundException("No Payment found with this Payment Id :"+ paymentId)));
	}

	public Payment findByApplicationId(Long applicationId)throws ResourceNotFoundException {
		return (pyRepo.findByApplicationId(applicationId));
	}

	public List<Payment> findByPaymentStatus(String paymentStatus) throws ResourceNotFoundException {
		List<Payment> pyList=pyRepo.findByPaymentStatus(paymentStatus);
		if(pyList.isEmpty()) {
			throw new ResourceNotFoundException("No Payment found with this Status :" + paymentStatus);
		}
		return pyList;
	}

	public void delete(Long paymentId) throws ResourceNotFoundException {
    	Payment py = pyRepo.findById(paymentId).orElseThrow(() -> new ResourceNotFoundException("No Payment Found with this id : " + paymentId));
    	pyRepo.delete(py);
	}

	
}
