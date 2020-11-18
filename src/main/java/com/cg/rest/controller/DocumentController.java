package com.cg.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import com.cg.rest.model.Document;
import com.cg.rest.service.IDocumentServiceImpl;


@RestController
public class DocumentController {

	@Autowired
	private IDocumentServiceImpl docSer;

	@PostMapping("/document/new")
	public Document addDocument(@ Valid @RequestBody Document document) {
		return docSer.addDocument(document);
	}
	
	@GetMapping("/document/all")
	public List<Document>viewAllDocumentDetails(){
		return docSer.viewAllDocumentDetails();
	}

	@DeleteMapping("/document/delete/{id}")
	public Map<String, Boolean> deleteDocumentById(@PathVariable(value = "id") Long documentId) throws ResourceNotFoundException {
		docSer.deleteDocumentById(documentId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	// working
	@GetMapping("/document/get/{id}")
	public ResponseEntity<Document> getBranchById(@PathVariable(value = "id") Long documentId) throws ResourceNotFoundException  {
		Document document = docSer.getDocumentById(documentId);
		return ResponseEntity.ok().body(document);
	}
	// working
	@GetMapping("/document/getbyemailid/{emailId}")
	public List<Document>  getDocumentByEmailId(@PathVariable(value="emailId") String emailId)throws ResourceNotFoundException {
		return docSer. getDocumentByEmailId(emailId);
	}
	// working
	@GetMapping("/document/getbyaplicationid/{ ApplicationId}")
	public List<Document>  getDocumentByApplicationId(@PathVariable(value=" ApplicationId") Long ApplicationId)throws ResourceNotFoundException {
		return docSer. getDocumentByApplicationId(ApplicationId);
	}

	// working
	@PutMapping("/document/update/{id}")
	public ResponseEntity<Document> updateDocument(@PathVariable(value = "id") Long documentId, @RequestBody Document documentdetails) throws ResourceNotFoundException  {
		Document document = docSer.getDocumentById(documentId);	
		document.setDocumentName(documentdetails.getDocumentName());
		document.setApplicationId(documentdetails.getApplicationId());
		document.setEmailId(documentdetails.getDocumentUrl());
		document.setDocumentUrl(documentdetails.getDocumentUrl());
		document.setDocumentStatus(documentdetails.getDocumentStatus());
		Document updateDocument = docSer.addDocument(document);
		return ResponseEntity.ok().body(updateDocument);

	}	
}