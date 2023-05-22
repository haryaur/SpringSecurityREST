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
		
		public int getRequestCountAllUser(int userId) {
			return requestCountRepo.findCountAllUser(userId);
		}
		
		public List<Request> getRecentUser(int userId) {
			return requestCountRepo.findRecentUser(userId);
		}
		
		public int getRequestCountApprovedUser(int userId) {
			return requestCountRepo.findCountApprovedUser(userId);
		}
		
		public int getRequestCountRejectedUser(int userId) {
			return requestCountRepo.findCountRejectedUser(userId);
		}
		
		public int getRequestCountPendingUser(int userId) {
			return requestCountRepo.findCountPendingUser(userId);
		}
		
		public int getRequestCountAllManager(String firstName) {
			return requestCountRepo.findCountAllManager(firstName);
		}
		
		public List<Request> getRequestRecentManager(String firstName) {
			return requestCountRepo.findRecentManager(firstName);
		}
		
		public int getRequestCountPendingManager(String firstName) {
			return requestCountRepo.findCountPendingManager(firstName);
		}
		
		public int getRequestCountApprovedManager(String firstName) {
			return requestCountRepo.findCountApprovedManager(firstName);
		}
		public int getRequestCountRejectedManager(String firstName) {
			return requestCountRepo.findCountRejectedManager(firstName);
		}
		
		public int getRequestCountAllHeadOffice(String firstName) {
			return requestCountRepo.findCountAllHeadOffice(firstName);
		}
		
		public List<Request> getRequestRecentHeadOffice(String firstName) {
			return requestCountRepo.findRecentHeadOffice(firstName);
		}
		
		public int getRequestCountRejectedHeadOffice(String firstName) {
			return requestCountRepo.findCountRejectedHeadOffice(firstName);
		}
		public int getRequestCountPendingHeadOffice(String firstName) {
			return requestCountRepo.findCountPendingHeadOffice(firstName);
		}
		public int getRequestCountApprovedHeadOffice(String firstName) {
			return requestCountRepo.findCountApprovedHeadOffice(firstName);
		}

	}

