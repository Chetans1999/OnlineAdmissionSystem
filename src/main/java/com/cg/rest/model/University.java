package com.cg.rest.model;

import java.util.*;

import javax.persistence.*;
@Entity
public class University 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long universityId;
	private String universityName;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<College> collegeList;
	
	public University() {
		super();
	}

	public University(String universityName, Address address, Set<College> collgeList) {
		super();
		this.universityName = universityName;
		this.address = address;
		this.collegeList = collgeList;
	}

	public long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(long universityId) {
		this.universityId = universityId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<College> getCollegeList() {
		return collegeList;
	}

	public void setCollegeList(Set<College> collegeList) {
		this.collegeList = collegeList;
	}

	@Override
	public String toString() {
		return "University [universityId=" + universityId + ", universityName=" + universityName + ", address="
				+ address + ", collegeList=" + collegeList + "]";
	}
	
}
