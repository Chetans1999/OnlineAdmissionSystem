package com.cg.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Document;

@Repository
public interface IDocumentRepository extends JpaRepository<Document, Long>{
	public List<Document> findByEmailId(String emailId)throws ResourceNotFoundException;
	public List<Document >findByApplicationId(Long applicationId);

}


