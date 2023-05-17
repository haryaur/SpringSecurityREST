package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tracking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trackingId;
	private String trackingcomment;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
	private String expectedDate;
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

//	@PrePersist
//    public void prePersist() {
//        createdDate = Date.;
    //}
	public String getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(String expectedDate) {
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
