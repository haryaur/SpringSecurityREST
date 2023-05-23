package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CreateDTO;
import com.example.demo.DTO.RequestApprovalDTO;
import com.example.demo.entities.Request;
import com.example.demo.repositories.ApprovalRepository;
import com.example.demo.repositories.RequestRepository;
import com.example.demo.repositories.TrackingRepository;

@Service
public class RequestService {
	
	@Autowired
    JavaMailSender javaMailSender;

	@Autowired ApprovalRepository approvalRepo;
	
	@Autowired TrackingRepository trackingRepo;

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


		public void saveRequest(CreateDTO createDTO) {
			//createDTO.request(setTimeCreated(LocalDateTime.now()));
			requestRepo.save(createDTO.getRequest());
			createDTO.getRequest().setTimeCreated(LocalDateTime.now());
	        String from = "afolayanayooluwa@gmail.com";
	        String to = createDTO.getApproval().getBranchManagerEmail();
	        String subject ="PENDING REQUEST";
	        String Text = "Please login to the Hackathon project";
	        sendMessage(from,to,subject,Text);
			 
		}

		public void save(Request request) {
			requestRepo.save(request);
		}
		
		public Request getOneRequest(int requestId) {
			return requestRepo.findById(requestId);
		}

		public void approveManager(Request request) {
			request.getApproval().setBranchApprovalStatus("Approved");
			request.getApproval().setHeadOfficeApprovalStatus("Pending");
			request.getApproval().setHeadOfficeManagerEmail("afolayanayooluwa@yahoo.com");
			request.getApproval().setBranchApprovalTime(LocalDateTime.now());
			requestRepo.save(request);
			 String from = "afolayanayooluwa@gmail.com";
		        String to = request.getApproval().getHeadOfficeManagerEmail();
		        String subject ="PENDING REQUEST TO HEAD OFFICE";
		        String Text = "Please login to the Hackathon project";
		        sendMessage(from,to,subject,Text);
		}
		
		public void rejectManager(Request request) {
			request.getApproval().setBranchApprovalStatus("Rejected");
			request.getApproval().setStatus("Rejected");
			request.getApproval().setBranchApprovalTime(LocalDateTime.now());
			requestRepo.save(request);
			 String from = "afolayanayooluwa@gmail.com";
//		        String to = request.getUsers().getEmail();
		        String to = "afolayanayooluwa@yahoo.com";
		        String subject ="REJECTED REQUEST BY BRANCH MANAGER";
		        String Text = "Please login to the Hackathon project";
		        sendMessage(from,to,subject,Text);
		}
		
		public void approveHeadOffice(RequestApprovalDTO requestApprovalDTO) {
			requestApprovalDTO.getRequest().getApproval().setHeadOfficeApprovalStatus("Approved");
			requestApprovalDTO.getRequest().getApproval().setStatus("Approved");
			requestApprovalDTO.getRequest().getApproval().setHeadOfficeApprovalTime(LocalDateTime.now());
			requestApprovalDTO.getRequest().getApproval().setApprovalTime(LocalDateTime.now());
			requestApprovalDTO.getRequest().setTracking(requestApprovalDTO.getTracking());
			trackingRepo.save(requestApprovalDTO.getTracking());
			requestRepo.save(requestApprovalDTO.getRequest());
			String from = "afolayanayooluwa@gmail.com";
		    String to = "afolayanayooluwa@yahoo.com";
		    String subject ="APPROVED REQUEST BY HEAD OFFICE";
		    String Text = "Please login to the Hackathon project";
		    sendMessage(from,to,subject,Text);
		}
		
		
		public void rejectHeadOffice(Request request) {
			request.getApproval().setHeadOfficeApprovalStatus("Rejected");
			request.getApproval().setStatus("Rejected");
			request.getApproval().setApprovalTime(LocalDateTime.now());
			requestRepo.save(request);
			String from = "afolayanayooluwa@gmail.com";
		    String to = "afolayanayooluwa@yahoo.com";
		    String subject ="REJECTED REQUEST BY HEAD OFFICE";
		    String Text = "Please login to the Hackathon project";
		    sendMessage(from,to,subject,Text);
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
