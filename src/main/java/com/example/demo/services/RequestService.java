package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Approval;
import com.example.demo.entities.Request;
import com.example.demo.entities.Users;
import com.example.demo.repositories.ApprovalRepository;
import com.example.demo.repositories.RequestRepository;

@Service
public class RequestService {
	
	@Autowired
    JavaMailSender javaMailSender;

	@Autowired ApprovalRepository approvalRepo;

		@Autowired RequestRepository requestRepo;
		
		public void sendMessage( String setFrom, String setTo, 
				String setSubject, String setText) {
		SimpleMailMessage message = new SimpleMailMessage();
	    message.setFrom(setFrom);
	    message.setTo(setTo);
	    message.setSubject(setSubject); 
	    message.setText(setText);
	    javaMailSender.send(message);
		}

		public List<Request> listAll() {
			return requestRepo.findAll();
		}

//		public Request get(int request_user_id) {
//			return requestRepo.findRequestByUserId(request_user_id).get();
//		}


		public void saveRequest(Request request) {
			request.setTimeCreated(LocalDateTime.now());
			requestRepo.save(request);
	        String from = "afolayanayooluwa@gmail.com";
	        String to = "afolayanayooluwa@yahoo.com";
	        String branch = "Agege";
	        String subject ="PENDING REQUEST";
	        String Text = "Please login to the Hackathon project";
	        sendMessage(from,to,subject,Text);
			 
		}

		public void save(Request request) {
			requestRepo.save(request);
		}

		public void approveManager(Request request) {
			 Approval x = request.getApproval();
			 x.setBranchApprovalStatus("Approved");
			requestRepo.save(request);
			SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("afolayanayooluwa@gmail.com");
	        message.setTo("proc manager");
	        message.setSubject("REQUEST STATUS"); 
	        message.setText("You have a pending request");
		}
		
		public void rejectManager(Request request) {
			 Approval x = request.getApproval();
			 x.setBranchApprovalStatus("Rejected");
			 x.setHeadOfficeApprovalStatus(null);
			 x.setStatus("Rejected");
			requestRepo.save(request);
		}
		
		public void approveHeadOffice(Request request) {
			 Approval x = request.getApproval();
			 x.setStatus("Approved");
			requestRepo.save(request);
		}
		
		public void rejectHeadOffice(Request request) {
			 Approval x = request.getApproval();
			 x.setStatus("Rejected");
			requestRepo.save(request);
		}

		public Request getRequestById(int requestId) {
			return requestRepo.findById(requestId);
		}
		
		public List<Request> getRequestAllUser(int userId) {
			return requestRepo.findAllUser(userId);
		}
		
		public List<Request> getRequestApprovedUser(int userId) {
			return requestRepo.findApprovedUser(userId);
		}
		
		public List<Request> getRequestRejectedUser(int userId) {
			return requestRepo.findRejectedUser(userId);
		}
		
		public List<Request> getRequestPendingUser(int userId) {
			return requestRepo.findPendingUser(userId);
		}
		
		public List<Request> getRequestAllManager(String firstName) {
			return requestRepo.findAllManager(firstName);
		}
		
		public List<Request> getRequestPendingManager(String firstName) {
			return requestRepo.findPendingManager(firstName);
		}
		
		public List<Request> getRequestApprovedManager(String firstName) {
			return requestRepo.findApprovedManager(firstName);
		}
		public List<Request> getRequestRejectedManager(String firstName) {
			return requestRepo.findRejectedManager(firstName);
		}
		
		public List<Request> getRequestAllHeadOffice(String firstName) {
			return requestRepo.findAllHeadOffice(firstName);
		}
		public List<Request> getRequestRejectedHeadOffice(String firstName) {
			return requestRepo.findRejectedHeadOffice(firstName);
		}
		public List<Request> getRequestPendingHeadOffice(String firstName) {
			return requestRepo.findPendingHeadOffice(firstName);
		}
		public List<Request> getRequestApprovedHeadOffice(String firstName) {
			return requestRepo.findApprovedHeadOffice(firstName);
		}

	}
