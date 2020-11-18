package com.cg.rest.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.*;
import com.cg.rest.repository.ICollegeRepository;

@Component
public class ICollegeServiceImpl implements ICollegeService {

	@Autowired
	private ICollegeRepository iCollRepo;
	
	@Autowired
	private IAddressServiceImpl addSer;

	@Autowired
	private ICourseServiceImpl crsSer;

	@Autowired
	private IBranchServiceImpl brSer;

	@Autowired
	private IProgramServiceImpl prSer;

	@Override
	public College save(College college) {
		return iCollRepo.save(college);
	}

	@Override
	public List<College> findAll() {
		return iCollRepo.findAll();
	}

	@Override
	public College findById(long collegeId) throws ResourceNotFoundException {
		return iCollRepo.findById(collegeId).orElseThrow(() -> new ResourceNotFoundException("No College Found with this ID : " + collegeId));
	}

	@Override
	public void delete(long collegeId) throws ResourceNotFoundException {
		College college = iCollRepo.findById(collegeId).orElseThrow(() -> new ResourceNotFoundException("No College Found with this ID : " + collegeId));
		iCollRepo.delete(college);	
	}

	@Override
	public Set<College> findByCollegeName(String collegeName) throws ResourceNotFoundException {
		Set<College> collList = iCollRepo.findByCollegeName(collegeName);
		if(collList.isEmpty()) {
			throw new ResourceNotFoundException("No College Found with this name : " + collegeName);
		}
		return collList;
	}
	
	@Override
	public ResponseEntity<College> updateCollegeById(long collegeId, College collegeNew, College collegeOld) throws ResourceNotFoundException {
		College coll = findById(collegeId);
		coll.setCollegeName(collegeNew.getCollegeName());

//		Updating Mapped CollegeAddress
		Address add = addSer.findById(collegeOld.getCollegeAddress().getAddressId());
		add.setCity(collegeNew.getCollegeAddress().getCity());
		add.setCountry(collegeNew.getCollegeAddress().getCountry());
		add.setCountry(collegeNew.getCollegeAddress().getDistrict());
		add.setLandmark(collegeNew.getCollegeAddress().getLandmark());
		add.setState(collegeNew.getCollegeAddress().getState());
		add.setZipcode(collegeNew.getCollegeAddress().getZipcode());
		coll.setCollegeAddress(add);

//		Updating Mapped CourseList
		Iterator<Course> itC1 = collegeOld.getCourseList().iterator();
		Iterator<Course> itC2 = collegeNew.getCourseList().iterator();
		Set<Course> crsList = new HashSet<>();
		while(itC1.hasNext()) {
			Course crs = crsSer.findById(itC1.next().getCourseId());
			Course crsNew = itC2.next();
			crs.setCourseName(crsNew.getCourseName());
			crs.setDescription(crsNew.getDescription());
			crs.setEligibility(crsNew.getEligibility());

//			Updating Mapped BranchList(Mapped to Course)
			Iterator<Branch> itB1 = crs.getBranches().iterator();
			Iterator<Branch> itB2 = crsNew.getBranches().iterator();
			Set<Branch> brList = new HashSet<>();
			while(itB1.hasNext()) {
				Branch br = brSer.getBranchById(itB1.next().getBranchId());
				Branch brNew = itB2.next();
				br.setBranchName(brNew.getBranchName());
				br.setBranchDescription(brNew.getBranchDescription());
				brList.add(br);
			}

			crs.setBranches(brList);
			crsList.add(crs);
		}

		coll.setCourseList(crsList);

//		Updating Mapped ProgramList
		Iterator<Program> itP1 = collegeOld.getProgramList().iterator();
		Iterator<Program> itP2 = collegeNew.getProgramList().iterator();
		Set<Program> prList = new HashSet<>();
		while(itP1.hasNext()) {
			Program pr = prSer.findById(itP1.next().getProgramId());
			Program prNew = itP2.next();
			pr.setProgramName(prNew.getProgramName());
			pr.setProgramDescription(prNew.getProgramDescription());
			pr.setProgramEligibility(prNew.getProgramEligibility());
			pr.setProgramDuration(prNew.getProgramDescription());
			pr.setDegreeOffered(prNew.getDegreeOffered());
			prList.add(pr);
		}

		coll.setProgramList(prList);
		return ResponseEntity.ok(coll);
	}


}



