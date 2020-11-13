package com.cg.rest.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	private String emailId;
	private Long applicationId;
	private double paymentAmount;
	private String paymentDescription;
	private LocalDate paymentDate=LocalDate.now();
	private String paymentStatus;
	
	
	public Payment()
	{
		super();
	}
	
	
	public Payment(Long paymentId, String emailId, Long applicationId, double paymentAmount, String paymentDescription,String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.emailId =emailId;
		this.applicationId= applicationId;
		this.paymentAmount=paymentAmount ;
		this.paymentDescription= paymentDescription;
		this.paymentStatus = paymentStatus;
	}

	
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", emailId=" + emailId + ", applicationId="
				+ applicationId + ", paymentAmount=" + paymentAmount + ", paymentDescription=" + paymentDescription
				+ ", paymentDate=" + paymentDate + ", paymentStatus=" + paymentStatus + "]";
	}


	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailIdOfStudent) {
		this.emailId = emailIdOfStudent;
	}
	public Long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentDescription() {
		return paymentDescription;
	}
	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
}
