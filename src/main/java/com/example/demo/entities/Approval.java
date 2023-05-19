package com.example.demo.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Approval {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int approvalId;
	private String branchManager;
	private String branchManagerEmail;
    private String branchApprovalTime;
	private String branchApprovalStatus;
	private String branchApprovalComment;
	private String headOfficeManager;
	private String headOfficeManagerEmail;
    private String headOfficeApprovalTime;
	private String headOfficeApprovalStatus;
	private String headOfficeApprovalComment;
	private String approvalTime;
	private String status;
	public int getApprovalId() {
		return approvalId;
	}
	public void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}
	public String getBranchManager() {
		return branchManager;
	}
	public void setBranchManager(String branchManager) {
		this.branchManager = branchManager;
	}
	public String getBranchApprovalTime() {
		return branchApprovalTime;
	}
	public void setBranchApprovalTime(String branchApprovalTime) {
		this.branchApprovalTime = branchApprovalTime;
	}
	public String getBranchApprovalStatus() {
		return branchApprovalStatus;
	}
	public void setBranchApprovalStatus(String branchApprovalStatus) {
		this.branchApprovalStatus = branchApprovalStatus;
	}
	public String getBranchApprovalComment() {
		return branchApprovalComment;
	}
	public void setBranchApprovalComment(String branchApprovalComment) {
		this.branchApprovalComment = branchApprovalComment;
	}
	public String getHeadOfficeManager() {
		return headOfficeManager;
	}
	public void setHeadOfficeManager(String headOfficeManager) {
		this.headOfficeManager = headOfficeManager;
	}
	public String getHeadOfficeApprovalTime() {
		return headOfficeApprovalTime;
	}
	public void setHeadOfficeApprovalTime(String headOfficeApprovalTime) {
		this.headOfficeApprovalTime = headOfficeApprovalTime;
	}
	public String getHeadOfficeApprovalStatus() {
		return headOfficeApprovalStatus;
	}
	public void setHeadOfficeApprovalStatus(String headOfficeApprovalStatus) {
		this.headOfficeApprovalStatus = headOfficeApprovalStatus;
	}
	public String getHeadOfficeApprovalComment() {
		return headOfficeApprovalComment;
	}
	public void setHeadOfficeApprovalComment(String headOfficeApprovalComment) {
		this.headOfficeApprovalComment = headOfficeApprovalComment;
	}
	public String getApprovalTime() {
		return approvalTime;
	}
	public void setApprovalTime(String approvalTime) {
		this.approvalTime = approvalTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBranchManagerEmail() {
		return branchManagerEmail;
	}
	public void setBranchManagerEmail(String branchManagerEmail) {
		this.branchManagerEmail = branchManagerEmail;
	}
	public String getHeadOfficeManagerEmail() {
		return headOfficeManagerEmail;
	}
	public void setHeadOfficeManagerEmail(String headOfficeManagerEmail) {
		this.headOfficeManagerEmail = headOfficeManagerEmail;
	}
	
	
	
	
     

}
