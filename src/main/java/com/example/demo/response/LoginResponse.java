package com.example.demo.response;

import java.util.List;

public class LoginResponse {
	private String successful;
	private String staffId;
	private String position;
	private Object login;
	private  int allMyRequest;
	private  int allApprovedRequest;
	private  int allPendingRequest;
	private  int allRejectedRequest;

	public LoginResponse() {

	}

	public String getSuccessful() {
		return successful;
	}

	public void setSuccessful(String successful) {
		this.successful = successful;
	}

	public Object getLogin() {
		return login;
	}

	public void setLogin(Object login) {
		this.login = login;
	}

	public int getAllMyRequest() {
		return allMyRequest;
	}

	public void setAllMyRequest(int allMyRequest) {
		this.allMyRequest = allMyRequest;
	}
	
	

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getAllApprovedRequest() {
		return allApprovedRequest;
	}

	public void setAllApprovedRequest(int allApprovedRequest) {
		this.allApprovedRequest = allApprovedRequest;
	}

	public int getAllPendingRequest() {
		return allPendingRequest;
	}

	public void setAllPendingRequest(int allPendingRequest) {
		this.allPendingRequest = allPendingRequest;
	}

	public int getAllRejectedRequest() {
		return allRejectedRequest;
	}

	public void setAllRejectedRequest(int allRejectedRequest) {
		this.allRejectedRequest = allRejectedRequest;
	}

	public LoginResponse (String successful, Object login,
		int allMyRequest,
		int allPendingRequest,  
		int allApprovedRequest, 
		int allRejectedRequest,
		String position, String staffId) {
		this.successful = successful;
		this.login = login;
		this.staffId = staffId;
		this.position = position;
		this.allMyRequest = allMyRequest;
		this.allPendingRequest = allPendingRequest;
		this.allApprovedRequest = allApprovedRequest;
		this.allRejectedRequest = allRejectedRequest;
	}

	
}
