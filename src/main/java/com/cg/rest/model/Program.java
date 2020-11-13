package com.cg.rest.model;

import javax.persistence.*;

@Entity
public class Program
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long programId;	
	private String programName;
	private String programDescription;
	private String programEligibility;
	private String programDuration;
	private String degreeOffered;
	
	public Program() {
		super();
	}
	
	public Program(String programName, String programDescription, String programEligibility,
			String programDuration, String degreeOffered) {
		super();
		this.programName = programName;
		this.programDescription = programDescription;
		this.programEligibility = programEligibility;
		this.programDuration = programDuration;
		this.degreeOffered = degreeOffered;
	}

	public long getProgramId() {
		return programId;
	}

	public void setProgramId(long programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramDescription() {
		return programDescription;
	}

	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}

	public String getProgramEligibility() {
		return programEligibility;
	}

	public void setProgramEligibility(String programEligibility) {
		this.programEligibility = programEligibility;
	}

	public String getProgramDuration() {
		return programDuration;
	}

	public void setProgramDuration(String programDuration) {
		this.programDuration = programDuration;
	}

	public String getDegreeOffered() {
		return degreeOffered;
	}

	public void setDegreeOffered(String degreeOffered) {
		this.degreeOffered = degreeOffered;
	}

	@Override
	public String toString() {
		return "Program [programId=" + programId + ", programName=" + programName + ", programDescription="
				+ programDescription + ", programEligibility=" + programEligibility + ", programDuration="
				+ programDuration + ", degreeOffered=" + degreeOffered + "]";
	}
	
	
	
}