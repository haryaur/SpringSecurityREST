package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Approval;
import com.example.demo.entities.Request;
import com.example.demo.repositories.ApprovalRepository;
import com.example.demo.repositories.RequestRepository;

@Service
public class RequestService {
	
	@Autowired
    JavaMailSender javaMailSender;

	@Autowired ApprovalRepository approvalRepo;

		@Autowired RequestRepository requestRepo;

		public List<Request> listAll() {
			return requestRepo.findAll();
		}

//		public Request get(int request_user_id) {
//			return requestRepo.findRequestByUserId(request_user_id).get();
//		}


		public void saveRequest(Request request) {
			request.setTimeCreated(LocalDateTime.now());
			requestRepo.save(request);
			SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("afolayanayooluwa@gmail.com");
	        message.setTo("afolayanayooluwa@yahoo.com");
	        message.setSubject("REQUEST TESTING"); 
	        message.setText("sent  sucessfully");

	        javaMailSender.send(message);
			   
		}

		public void save(Request request) {
			requestRepo.save(request);
			SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("afolayanayooluwa@gmail.com");
	        message.setTo("afolayanayooluwa@yahoo.com");
	        message.setSubject("REQUEST TESTING"); 
	        message.setText("sent  sucessfully");

	        javaMailSender.send(message);
			   
		}

		public void approveManager(Request request) {
			 Approval x = request.getApproval();
			 x.setBranchApprovalStatus("Approved");
			requestRepo.save(request);
		}
		
		public void rejectManager(Request request) {
			 Approval x = request.getApproval();
			 x.setBranchApprovalStatus("Rejected");
			 x.setHeadOfficeApprovalStatus(null);
			 x.setStatus("Rejected");
			requestRepo.save(request);
		}

		public Request getRequestById(int requestId) {
			return requestRepo.findById(requestId);
		}

	}
