package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Request;
import com.example.demo.repositories.ApprovalRepository;
import com.example.demo.repositories.RequestCountRepository;
import com.example.demo.repositories.TrackingRepository;

@Service
public class RequestCountService {
	
	@Autowired
    JavaMailSender javaMailSender;

	@Autowired ApprovalRepository approvalRepo;
	
	@Autowired TrackingRepository trackingRepo;

		@Autowired RequestCountRepository requestCountRepo;
		
		public int getRequestAllUser(int userId) {
			return requestCountRepo.findCountAllUser(userId);
		}
		
		public int getRequestApprovedUser(int userId) {
			return requestCountRepo.findCountApprovedUser(userId);
		}
		
		public int getRequestRejectedUser(int userId) {
			return requestCountRepo.findCountRejectedUser(userId);
		}
		
		public int getRequestPendingUser(int userId) {
			return requestCountRepo.findCountPendingUser(userId);
		}
		
		public int getRequestAllManager(String firstName) {
			return requestCountRepo.findCountAllManager(firstName);
		}
		
		public int getRequestPendingManager(String firstName) {
			return requestCountRepo.findCountPendingManager(firstName);
		}
		
		public int getRequestApprovedManager(String firstName) {
			return requestCountRepo.findCountApprovedManager(firstName);
		}
		public int getRequestRejectedManager(String firstName) {
			return requestCountRepo.findCountRejectedManager(firstName);
		}
		
		public int getRequestAllHeadOffice(String firstName) {
			return requestCountRepo.findCountAllHeadOffice(firstName);
		}
		public int getRequestRejectedHeadOffice(String firstName) {
			return requestCountRepo.findCountRejectedHeadOffice(firstName);
		}
		public int getRequestPendingHeadOffice(String firstName) {
			return requestCountRepo.findCountPendingHeadOffice(firstName);
		}
		public int getRequestApprovedHeadOffice(String firstName) {
			return requestCountRepo.findCountApprovedHeadOffice(firstName);
		}

	}

