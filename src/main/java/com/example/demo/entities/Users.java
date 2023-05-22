package com.example.demo.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Users{
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int userId;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String staffId;
	@Column(columnDefinition = "Time")
    private LocalDateTime userCreated;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Roles> roles = new HashSet<>();
	
	@ManyToOne( cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_position_id")
	private StaffPosition staffPosition;

	@ManyToOne ( cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_branch_id")
	private BranchLocation branchLocation;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

//	public Set<Roles> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Roles> roles) {
//		this.roles = roles;
//	}
//
//	public void addRole(Roles roles) {
//		this.roles.add(roles);
//	}
	
	

	public StaffPosition getStaffPosition() {
		return staffPosition;
	}

		public Set<Roles> getRoles() {
			return roles;
		}

		public void setRoles(Set<Roles> roles) {
			this.roles = roles;
		}

		public void addRole(Roles roles) {
			this.roles.add(roles);
		}
	
//	public void addRole(Roles roles) {
//	this.Roles.add(roles);
//}

	public void setStaffPosition(StaffPosition staffPosition) {
		this.staffPosition = staffPosition;
	}

	public BranchLocation getBranchLocation() {
		return branchLocation;
	}

	public void setBranchLocation(BranchLocation branchLocation) {
		this.branchLocation = branchLocation;
	}

	public LocalDateTime getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(LocalDateTime userCreated) {
		this.userCreated = userCreated;
	}


	

}
