package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Approval;
import com.example.demo.repositories.ApprovalRepository;

@Service
public class ApprovalService {
	
	@Autowired
	ApprovalRepository approvalRepo;
	
	public void saveApproval(Approval approval) {
		approval.setBranchApprovalStatus("Pending");
		approval.setBranchManager("Emmy");
		approval.setHeadOfficeManager("Ayooluwa");
		approval.setHeadOfficeApprovalStatus("Pending");
		approval.setStatus("Pending");
		approvalRepo.save(approval);
		   
	}

}
