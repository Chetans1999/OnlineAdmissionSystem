package com.cg.rest.service;



import java.util.List;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Document;

public interface IDocumentService {
	public Document addDocument( Document document);
	public List<Document> viewAllDocumentDetails();
	public void deleteDocumentById(Long documentId) throws ResourceNotFoundException;
	public Document getDocumentById(Long documentId) throws ResourceNotFoundException;
	public List<Document> getDocumentByApplicationId(Long applicationId)throws ResourceNotFoundException;
	public List <Document> getDocumentByEmailId(String emailId)throws ResourceNotFoundException;
}
