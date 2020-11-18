package com.cg.rest.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "application")
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long applicationId;
	@Column(nullable = false)
	private String applicantFullName;

	@Column(nullable=false)
	private LocalDate dateOfBirth;
	@Column(nullable = false)
	private String highestQualification;
	@Column(nullable = false)
	private double finalYearPercentage;
	@Column(nullable = false)
	private String goals;
	@Column(nullable = false)
	@Email(message = "Enter Correct Email ")
	private String emailId;
	@Column(nullable = false)
	private int universityId;
	@Column(nullable = false)
	private int collegeId;
	@Column(nullable = false)
	private int programId;
	@Column(nullable = false)
	private int courseId;
	@Column(nullable = false)
	private int branchId;
	@Column(nullable = false)
	private String applicationStatus;
	
	public Application() {
		super();
	}

	public Application(Long applicationId, String applicantFullName, LocalDate dateOfBirth, String highestQualification,
			double finalYearPercentage, String goals, String emailId, int universityId, int collegeId, int programId,
			int courseId, int branchId, String applicationStatus) {
		super();
		this.applicationId = applicationId;
		this.applicantFullName = applicantFullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.finalYearPercentage = finalYearPercentage;
		this.goals = goals;
		this.emailId = emailId;
		this.universityId = universityId;
		this.collegeId = collegeId;
		this.programId = programId;
		this.courseId = courseId;
		this.branchId = branchId;
		this.applicationStatus = applicationStatus;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", applicantFullName=" + applicantFullName
				+ ", dateOfBirth=" + dateOfBirth + ", highestQualification=" + highestQualification
				+ ", finalYearPercentage=" + finalYearPercentage + ", goals=" + goals + ", emailId=" + emailId
				+ ", universityId=" + universityId + ", collegeId=" + collegeId + ", programId=" + programId
				+ ", courseId=" + courseId + ", branchId=" + branchId + ", applicationStatus=" + applicationStatus
				+ "]";
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicantFullName() {
		return applicantFullName;
	}

	public void setApplicantFullName(String applicantFullName) {
		this.applicantFullName = applicantFullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public double getFinalYearPercentage() {
		return finalYearPercentage;
	}

	public void setFinalYearPercentage(double finalYearPercentage) {
		this.finalYearPercentage = finalYearPercentage;
	}

	public String getGoals() {
		return goals;
	}

	public void setGoals(String goals) {
		this.goals = goals;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}


		
}
