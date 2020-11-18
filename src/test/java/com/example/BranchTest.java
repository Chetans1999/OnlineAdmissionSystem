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

import com.cg.rest.model.Branch;
import com.cg.rest.repository.IBranchRepository;
import com.cg.rest.service.IBranchServiceImpl;

@ExtendWith(MockitoExtension.class)
 class BranchTest {
	@Mock
	 private IBranchRepository brRepo;
	@InjectMocks
	 private IBranchServiceImpl brSer;

	@Test
	 void viewBranchDetailsTest() {
		Branch branch = new Branch("ME", "Mechanichal Engineering");
				new Branch("CSE", "computer science");
		List<Branch> br = new ArrayList<Branch>();
		br.add(branch);
		Mockito.when(brRepo.findAll()).thenReturn(br);
		assertEquals(brSer.viewAllBranchDetails(), br);
	}
	@Test
	void addBranchTest() {
		Branch branch = new Branch("ME", "Mechanichal Engineering");
		Mockito.when(brRepo.save(branch)).thenReturn(branch);
		assertEquals(brSer.addBranch(branch), branch);
		}

}
