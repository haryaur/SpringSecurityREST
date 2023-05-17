package com.example.demo.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;


@Entity
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;
	private String requestComment;
	
	@Column(columnDefinition = "Time")
    private LocalDateTime timeCreated;

	@ManyToOne ( cascade = CascadeType.MERGE)
	@JoinColumn(name = "request_user_id")
	private Users users;

	@ManyToOne ( cascade = CascadeType.MERGE)
	@JoinColumn(name = "request_item_id")
	private Items items;

	@ManyToOne ( cascade = CascadeType.MERGE)
	@JoinColumn(name = "request_contact_id")
	private Contacts contacts;

	@ManyToOne ( cascade = CascadeType.MERGE)
	@JoinColumn(name = "request_approval_id")
	private Approval approval;

	@ManyToOne ( cascade = CascadeType.MERGE)
	@JoinColumn(name = "request_tracking_id")
	private Tracking tracking;



	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	
	

	public String getRequestComment() {
		return requestComment;
	}

	public void setRequestComment(String requestComment) {
		this.requestComment = requestComment;
	}

	public LocalDateTime getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(LocalDateTime timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public Contacts getContacts() {
		return contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}

	public Approval getApproval() {
		return approval;
	}

	public void setApproval(Approval approval) {
		this.approval = approval;
	}

	public Tracking getTracking() {
		return tracking;
	}

	public void setTracking(Tracking tracking) {
		this.tracking = tracking;
	}

}
