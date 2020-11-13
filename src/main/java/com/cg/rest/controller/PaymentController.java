package com.cg.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Payment;
import com.cg.rest.service.IPaymentServiceImpl;

@RestController
public class PaymentController {
	
	@Autowired
	private IPaymentServiceImpl pySer;
	
	//WORKING
	@PostMapping("/payment/new")
	public Payment addPayment(@RequestBody Payment payment) {
		return pySer.save(payment);
	}
	
	//WORKING
	@GetMapping("/payment/all")
	public List<Payment> viewAllPayments(){
		return pySer.findAll();
	}
	
	//WORKING
	@GetMapping("/payment/getbyemail/{emailId}")
	public List<Payment> viewPaymentByEmail(@PathVariable(value="emailId")String emailId)throws ResourceNotFoundException {
		return pySer.findByEmailId(emailId);
	}
	
	//WORKING
	@GetMapping("/payment/getbypaymentId/{id}")
	public ResponseEntity<Payment> viewPaymentById(@PathVariable(value="id")Long paymentId)throws ResourceNotFoundException{
		Payment py=pySer.findById(paymentId);
		return ResponseEntity.ok().body(py);
	}
	
	//WORKING
	@GetMapping("/payment/getbyapplicationId/{id}")
	public ResponseEntity<Payment> viewPaymentByApplicationId(@PathVariable(value="id")Long applicationId)throws ResourceNotFoundException{
		Payment py=pySer.findByApplicationId(applicationId);
		return ResponseEntity.ok().body(py);
	}
	
	//WORKING
	@GetMapping("/payment/getbypaymentstatus/{paymentStatus}")
	public List<Payment> viewByPaymentStatus(@PathVariable(value="paymentStatus")String paymentStatus)throws ResourceNotFoundException{
		return pySer.findByPaymentStatus(paymentStatus);
	}
	
	//WORKING
	@DeleteMapping("/payment/delete/{paymentId}")
	public Map<String, Boolean> deleteById(@PathVariable(value="paymentId")Long paymentId)throws ResourceNotFoundException{
		pySer.delete(paymentId);
		Map<String, Boolean> response=new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}
	
	//WORKING
	@PutMapping("/payment/update/{paymentId}")
	public ResponseEntity<Payment> updatePayment(@PathVariable(value="paymentId")Long paymentId, @RequestBody Payment paymentDetails)throws ResourceNotFoundException{
		Payment py=pySer.findById(paymentId);
//				.orElseThrow(()-> new ResourceNotFoundException("No Payment found with this id :"+ paymentId));
		
		py.setEmailId(paymentDetails.getEmailId());
		py.setApplicationId(paymentDetails.getApplicationId());
		py.setPaymentAmount(paymentDetails.getPaymentAmount());
		py.setPaymentDescription(paymentDetails.getPaymentDescription());
		py.setPaymentDate(LocalDate.now());
		py.setPaymentStatus(paymentDetails.getPaymentStatus());
		Payment updatedPayment =pySer.save(py);
		return ResponseEntity.ok(updatedPayment);
	}

}
