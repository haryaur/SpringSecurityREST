package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BranchLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;
	private String branchName;
	private String branchLG;
	private String branchState;

	public BranchLocation() {

	}
	public BranchLocation(String branchName, String branchLG, String branchState) {
		this.branchName = branchName;
		this.branchLG = branchLG;
		this.branchState = branchState;
	}



	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchLG() {
		return branchLG;
	}
	public void setBranchLG(String branchLG) {
		this.branchLG = branchLG;
	}
	public String getBranchState() {
		return branchState;
	}
	public void setBranchState(String branchState) {
		this.branchState = branchState;
	}




}
