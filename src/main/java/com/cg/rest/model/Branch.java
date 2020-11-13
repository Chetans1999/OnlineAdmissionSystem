package com.cg.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Branch
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long branchId;
	private String branchName;
	private String branchDescription;
	
	public Branch() {
		super();
	}

	public Branch(String branchName, String branchDescription) {
		this.branchName = branchName;
		this.branchDescription = branchDescription;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchDescription() {
		return branchDescription;
	}

	public void setBranchDescription(String branchDescription) {
		this.branchDescription = branchDescription;
	}

	public long getBranchId() {
		return branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", branchDescription="
				+ branchDescription + "]";
	}

}

	