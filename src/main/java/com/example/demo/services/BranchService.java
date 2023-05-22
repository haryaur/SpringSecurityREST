package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.BranchLocation;
import com.example.demo.repositories.BranchRepository;

@Service
public class BranchService {

	@Autowired
	BranchRepository branchRepo;

	public void AddNewBranch(BranchLocation branchLocation) {
	branchRepo.save(branchLocation);
	}
	
	public List<BranchLocation> listAll() {
		return branchRepo.findAll();
	
}
}