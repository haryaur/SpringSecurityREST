package com.example.demo.response;

public class GetUserResponse {
	public String name;
	public String position;
	public String staffId;
	public Object users;
	
	public GetUserResponse() {}
	
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
	public Object getUsers() {
		return users;
	}
	public void setUsers(Object listUsers) {
		this.users = listUsers;
	}
	
	

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public GetUserResponse(String name, String position,String staffId, Object users) {
		this.name = name;
		this.position = position;
		this.users = users;
		this.staffId = staffId;
	}
	
	

}
