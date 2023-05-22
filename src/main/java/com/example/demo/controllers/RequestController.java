package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.CreateDTO;
import com.example.demo.DTO.RequestApprovalDTO;
import com.example.demo.entities.Approval;
import com.example.demo.entities.Request;
import com.example.demo.entities.Users;
import com.example.demo.repositories.RequestRepository;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.security.CustomUserDetails;
import com.example.demo.services.ApprovalService;
import com.example.demo.services.RequestService;
import com.example.demo.services.UsersService;

@RestController
public class RequestController {
	
	@Autowired
	JavaMailSender javaMailSender;

	
	@Autowired UsersRepository usersRepo;
	@Autowired RequestRepository requestRepo;
	
	@Autowired RequestService requestService;
	
	@Autowired ApprovalService approvalService;
	
	@Autowired UsersService usersService;
	
	
	public void sendMessage( String setFrom, String setTo, 
			String setSubject, String setText) {
	SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("afolayanayooluwa@gmail.com");
    message.setTo("proc manager");
    message.setSubject("REQUEST STATUS"); 
    message.setText("You have a pending request");
    javaMailSender.send(message);
	}
	
//	@PostMapping("/addRequest")
//	public String AddRequest(@RequestBody RequestDTO requestDTO, Request request) {
//		request.getContacts();
//				
//		Tracking tracking= new Tracking(
//				requestDTO.getTrackingcomment(),requestDTO.getExpectedDate(),
//				requestDTO.getAcknowledgement(),requestDTO.getExtraComment()
//				);
//
//	  requestRepo.save(request);
//	  trackingRepo.save(tracking);
//	  return ("Role has been Added");
//	}
	
	
	@PostMapping("/addRequest")
	public String AddRequest(@RequestBody CreateDTO createDTO,Users users) {
		Request request = createDTO.getRequest();
		Approval approval = createDTO.getApproval();
		approvalService.saveApproval(approval);
		request.setApproval(createDTO.getApproval());
		requestService.saveRequest(createDTO);
		return "submitted";
	}
	
	
	@GetMapping("/myRequests/filter/{branchManager}")
	public List<Request> listRequest(@PathVariable String branchManager, 
			CustomUserDetails customUserDetails) {
		List<Request> list = requestRepo.findByBranchManager(branchManager);
		return list;
	}
		@GetMapping("/myRequests/{headOfficeManager}")
		public List<Request> listMyRequest(@PathVariable String headOfficeManager, 
				CustomUserDetails customUserDetails) {
			List<Request> list2 = requestRepo.findByHeadOfficeManager(headOfficeManager);
			return list2;

	}
	
	@GetMapping("/request/view/{requestId}")
	public Object viewUser(@PathVariable("requestId") int requestId) {
		Request request = requestService.getRequestById(requestId);
		return request;
	}
	
	@PutMapping(value="/request/approveManager/{requestId}")
	public String branchApprove(@PathVariable("requestId") int requestId,
		@RequestBody Request request) {
		requestService.approveManager(request);
		return "details successfully updated";
	}
	
	@PutMapping(value="/request/rejectManager/{requestId}")
	public String branchReject(@PathVariable("requestId") int requestId,
		@RequestBody Request request) {
		requestService.rejectManager(request);
		return "details successfully updated";
	}
	
	@PutMapping(value="/request/approveHeadOffice/{requestId}")
	public String headOfficeApprove(@PathVariable("requestId") int requestId,
		@RequestBody RequestApprovalDTO requestApprovalDTO) {
		requestService.approveHeadOffice(requestApprovalDTO);
		return "details successfully updated";
	}
	
	@PutMapping(value="/request/rejectHeadOffice/{requestId}")
	public String headOfficeReject(@PathVariable("requestId") int requestId,
		@RequestBody Request request) {
		requestService.rejectHeadOffice(request);
		return "details successfully updated";
	}


}
