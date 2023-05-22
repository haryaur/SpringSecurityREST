package com.example.demo.response;

public class RegistrationResponse {
	
	private Object position;
	private Object branch;
	
	public RegistrationResponse() {}

	public Object getPosition() {
		return position;
	}

	public void setPosition(Object position) {
		this.position = position;
	}

	public Object getBranch() {
		return branch;
	}

	public void setBranch(Object branch) {
		this.branch = branch;
	}

	public RegistrationResponse(Object position, Object branch) {
		super();
		this.position = position;
		this.branch = branch;
	}
	
	

}
