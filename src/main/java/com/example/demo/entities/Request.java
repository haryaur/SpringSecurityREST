package com.example.demo.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;
	private String requestComment;
	private int quantity1;
	private int quantity2;
	private int quantity3;
	
	@Column(columnDefinition = "Time")
    private LocalDateTime timeCreated;

	@ManyToOne ( cascade = CascadeType.MERGE)
	@JoinColumn(name = "request_user_id")
	private Users users;

	@ManyToOne ( cascade = CascadeType.MERGE)
	@JoinColumn(name = "request_item_id")
	private Items items;
	
	@ManyToOne ( cascade = CascadeType.MERGE)
	@JoinColumn(name = "request_item_id2")
	private Items items2;
	
	@ManyToOne ( cascade = CascadeType.MERGE)
	@JoinColumn(name = "request_item_id3")
	private Items items3;
	

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

	public int getQuantity1() {
		return quantity1;
	}

	public void setQuantity1(int quantity1) {
		this.quantity1 = quantity1;
	}

	public int getQuantity2() {
		return quantity2;
	}

	public void setQuantity2(int quantity2) {
		this.quantity2 = quantity2;
	}

	public int getQuantity3() {
		return quantity3;
	}

	public void setQuantity3(int quantity3) {
		this.quantity3 = quantity3;
	}

	public Items getItems2() {
		return items2;
	}

	public void setItems2(Items items2) {
		this.items2 = items2;
	}

	public Items getItems3() {
		return items3;
	}

	public void setItems3(Items items3) {
		this.items3 = items3;
	}
	
	


}
