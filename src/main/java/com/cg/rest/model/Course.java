package com.cg.rest.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long courseId;
	private String courseName;
	private String description;
	private String eligibility;
	@OneToMany(cascade = CascadeType.ALL)	 
	private Set<Branch> branches;

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public Course() {
		super();
	}

	public Course(String courseName, String description, String eligibility) {
		super();
		this.courseName = courseName;
		this.description = description;
		this.eligibility = eligibility;
	}

	public Course(String courseName, String description, String eligibility, Set<Branch> branches) {
		super();
		this.courseName = courseName;
		this.description = description;
		this.eligibility = eligibility;
		this.branches = branches;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEligibility() {
		return eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public Set<Branch> getBranches() {
		return branches;
	}

	public void setBranches(Set<Branch> branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description
				+ ", eligibility=" + eligibility + ", branches=" + branches + "]";
	}

}
