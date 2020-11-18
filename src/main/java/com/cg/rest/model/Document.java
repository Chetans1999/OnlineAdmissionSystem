package com.cg.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "document")
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long documentId;
	@Column(nullable = false)
	private String documentName;
	@Column(nullable = false)
	@URL(message="please enter valid url")
	private String documentUrl;
	@Column(nullable = false)
	private Long applicationId;
	@Column(nullable = false)
	@Email(message = "Please enter valid emailid")
	private String emailId;
	@Column(nullable = false)
	private String documentStatus;
	
	
	public Document() {
		super();
	}


	public Document(Long documentId, String documentName, String documentUrl, Long applicationId, String emailId,
			String documentStatus) {
		super();
		this.documentId = documentId;
		this.documentName = documentName;
		this.documentUrl = documentUrl;
		this.applicationId = applicationId;
		this.emailId = emailId;
		this.documentStatus = documentStatus;
	}


	public Long getDocumentId() {
		return documentId;
	}


	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}


	public String getDocumentName() {
		return documentName;
	}


	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}


	public String getDocumentUrl() {
		return documentUrl;
	}


	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}


	public Long getApplicationId() {
		return applicationId;
	}


	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getDocumentStatus() {
		return documentStatus;
	}


	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}	
}