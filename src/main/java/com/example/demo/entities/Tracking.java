package com.example.demo.entities;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tracking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trackingId;
	private String trackingcomment;
    private LocalDateTime createdDate;
	private Date expectedDate;
	private String acknowledgement;
	private String extraComment;



	public int getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(int trackingId) {
		this.trackingId = trackingId;
	}
	public String getTrackingcomment() {
		return trackingcomment;
	}
	public void setTrackingcomment(String trackingcomment) {
		this.trackingcomment = trackingcomment;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

//	@PrePersist
//    public void prePersist() {
//        createdDate = Date.;
    //}
	public Date getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}
	public String getAcknowledgement() {
		return acknowledgement;
	}
	public void setAcknowledgement(String acknowledgement) {
		this.acknowledgement = acknowledgement;
	}
	public String getExtraComment() {
		return extraComment;
	}
	public void setExtraComment(String extraComment) {
		this.extraComment = extraComment;
	}



}
