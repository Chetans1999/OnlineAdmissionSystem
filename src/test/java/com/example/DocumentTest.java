package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.rest.model.Document;
import com.cg.rest.repository.IDocumentRepository;
import com.cg.rest.service.IDocumentServiceImpl;


@ExtendWith(MockitoExtension.class)
  class DocumentTest {
@Mock
 private IDocumentRepository docRepo;
@InjectMocks
 private IDocumentServiceImpl docSer;

@Test
 void viewAllDocumentDetailsTest() {
	Document document = new Document(1L, "Marksheet", "abc",2L, "pqr","uploaded");
			new Document(2L, "aadharcard", "abc",3L, "pqr","uploaded");
	List<Document> doc = new ArrayList<Document>();
	doc.add(document);
	Mockito.when(docRepo.findAll()).thenReturn(doc);
	assertEquals(docSer.viewAllDocumentDetails(),doc);
}
@Test
void addDocumentTest() {
	Document document = new Document(1L, "Marksheet", "abc",2L, "pqr","uploaded");
	Mockito.when(docRepo.save(document)).thenReturn(document);
	assertEquals(docSer.addDocument(document),document);
	}
/*@Test
void deleteDocumentByIdTest() {
	Document document = new Document(1L, "Marksheet", "abc",2L, "pqr","uploaded");
	Mockito.when(docRepo.findById(document.getDocumentId()).thenReturn(document);
	assertEquals(docSer.deleteDocumentById(document.getDocumentId()),document);
}*/


}



