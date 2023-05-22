package com.example.demo.response;

public class ViewUserResponse {
	public String name;
	public String position;
	public String staffId;
	public Object users;
	
	public ViewUserResponse() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Object getUsers() {
		return users;
	}

	public void setUsers(Object users) {
		this.users = users;
	}

	public ViewUserResponse(String name, String position, String staffId, Object users) {
		super();
		this.name = name;
		this.position = position;
		this.staffId = staffId;
		this.users = users;
	}
	
	

}
