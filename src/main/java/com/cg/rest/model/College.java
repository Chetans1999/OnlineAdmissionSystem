package com.cg.rest.model;
import java.util.Set;
import javax.persistence.*;
@Entity
public class College
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long collegeRegId;
	private String collegeName;
	@OneToOne(cascade = CascadeType.ALL)
	private Address collegeAddress;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Program> programList;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Course> courseList;
//	@ManyToOne(cascade = CascadeType.ALL)
//	private University universityName;
	
	public College() {
		super();
	}

	public College(String collegeName, Address collegeAddress, Set<Program> programList,
			Set<Course> courseList) {
		super();
		this.collegeName = collegeName;
		this.collegeAddress = collegeAddress;
		this.programList = programList;
		this.courseList = courseList;
	}

	public long getCollegeRegId() {
		return collegeRegId;
	}

	public void setCollegeRegId(long collegeRegId) {
		this.collegeRegId = collegeRegId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Address getCollegeAddress() {
		return collegeAddress;
	}

	public void setCollegeAddress(Address collegeAddress) {
		this.collegeAddress = collegeAddress;
	}

	public Set<Program> getProgramList() {
		return programList;
	}

	public void setProgramList(Set<Program> programList) {
		this.programList = programList;
	}

	public Set<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(Set<Course> courseList) {
		this.courseList = courseList;
	}

//	public University getUniversityName() {
//		return universityName;
//	}
//
//	public void setUniversityName(University universityName) {
//		this.universityName = universityName;
//	}

	@Override
	public String toString() {
		return "College [collegeRegId=" + collegeRegId + ", collegeName=" + collegeName + ", collegeAddress="
				+ collegeAddress + ", programList=" + programList + ", courseList=" + courseList + "]";
	}
	
}



