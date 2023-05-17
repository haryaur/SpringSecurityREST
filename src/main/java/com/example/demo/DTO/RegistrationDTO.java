package com.example.demo.DTO;


import com.example.demo.entities.BranchManager;
import com.example.demo.entities.Users;

public class RegistrationDTO {

	private Users users;
	private BranchManager branchManager;
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public BranchManager getBranchManager() {
		return branchManager;
	}
	public void setBranchManager(BranchManager branchManager) {
		this.branchManager = branchManager;
	}
	
	
	
}
