package com.cg.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Program {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long programId;
	@Column(nullable = false)
	private String programName;
	@Column(nullable = false)
	private String eligibility;
	@Column(nullable = false)
	private String duration;
	@Column(nullable = false)
	private String degreeOffered;
	public Program() {
		super();
	}
	public Program(Long programId, String programName, String eligibility, String duration, String degreeOffered) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.eligibility = eligibility;
		this.duration = duration;
		this.degreeOffered = degreeOffered;
	}
	public Long getProgramId() {
		return programId;
	}
	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getEligibility() {
		return eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDegreeOffered() {
		return degreeOffered;
	}
	public void setDegreeOffered(String degreeOffered) {
		this.degreeOffered = degreeOffered;
	}
	@Override
	public String toString() {
		return "Program [programId=" + programId + ", programName=" + programName + ", eligibility=" + eligibility
				+ ", duration=" + duration + ", degreeOffered=" + degreeOffered + "]";
	}
	
	

}
