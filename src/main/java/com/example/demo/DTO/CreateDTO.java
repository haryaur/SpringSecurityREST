package com.example.demo.DTO;

import com.example.demo.entities.Approval;
import com.example.demo.entities.Request;

public class CreateDTO {
	
	private Request request;
	private Approval approval;
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public Approval getApproval() {
		return approval;
	}
	public void setApproval(Approval approval) {
		this.approval = approval;
	}
	
	
	
	

}
