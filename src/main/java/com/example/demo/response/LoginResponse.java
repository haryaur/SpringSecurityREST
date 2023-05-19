package com.example.demo.response;

import java.util.List;

public class LoginResponse {
	private String successful;
	private String staffId;
	private String position;
	private Object login;
	private  List<Object> allMyRequest;
	private  List<Object> allApprovedRequest;
	private  List<Object> allPendingRequest;
	private  List<Object> allRejectedRequest;

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

	public List<Object> getAllMyRequest() {
		return allMyRequest;
	}

	public void setAllMyRequest(List<Object> allMyRequest) {
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

	public List<Object> getAllApprovedRequest() {
		return allApprovedRequest;
	}

	public void setAllApprovedRequest(List<Object> allApprovedRequest) {
		this.allApprovedRequest = allApprovedRequest;
	}

	public List<Object> getAllPendingRequest() {
		return allPendingRequest;
	}

	public void setAllPendingRequest(List<Object> allPendingRequest) {
		this.allPendingRequest = allPendingRequest;
	}

	public List<Object> getAllRejectedRequest() {
		return allRejectedRequest;
	}

	public void setAllRejectedRequest(List<Object> allRejectedRequest) {
		this.allRejectedRequest = allRejectedRequest;
	}

	public LoginResponse (String successful, Object login,
		List<Object> allMyRequest,
		List<Object> allPendingRequest,  
		List<Object> allApprovedRequest, 
		List<Object> allRejectedRequest,
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
