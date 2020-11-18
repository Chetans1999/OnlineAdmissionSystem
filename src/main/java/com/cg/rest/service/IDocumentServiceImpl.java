package com.cg.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Document;
import com.cg.rest.repository.IDocumentRepository;

@Component
public class IDocumentServiceImpl implements IDocumentService {


	@Autowired
	private IDocumentRepository docRepo;

	public Document addDocument(Document document) {
		return docRepo.save(document);
	}

	public List<Document> viewAllDocumentDetails() {
		return docRepo.findAll();
	}

	public void deleteDocumentById(Long documentId) throws ResourceNotFoundException {

		Document doc = docRepo.findById(documentId).orElseThrow(() -> new ResourceNotFoundException("No document Found with this id : " + documentId));
		docRepo.delete(doc);

	}

	public Document getDocumentById(Long documentId) throws ResourceNotFoundException {
		Document doc = docRepo.findById(documentId).orElseThrow(() -> new ResourceNotFoundException("No document Found with this id : " + documentId)) ;
		return doc;
	}

	public List<Document> getDocumentByEmailId(String emailId) throws ResourceNotFoundException{
		List<Document> doclist = docRepo.findByEmailId(emailId);
         if(doclist.isEmpty()) {
		throw new ResourceNotFoundException("No document Found with this emailid: " + emailId);
		}
		return doclist;
	}

	public List<Document> getDocumentByApplicationId(Long applicationId) throws ResourceNotFoundException {
		List<Document> doclist = docRepo.findByApplicationId(applicationId);
		if(doclist.isEmpty()) {
		throw new ResourceNotFoundException("No document found with this Application Id :"+ applicationId);
		}
		return doclist;
	}
}


