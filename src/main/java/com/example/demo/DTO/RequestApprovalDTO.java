package com.example.demo.DTO;

import com.example.demo.entities.Request;
import com.example.demo.entities.Tracking;

public class RequestApprovalDTO {
	private Request request;
	private Tracking tracking;
	
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public Tracking getTracking() {
		return tracking;
	}
	public void setTracking(Tracking tracking) {
		this.tracking = tracking;
	}
	
	

}
	