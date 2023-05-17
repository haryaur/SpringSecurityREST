package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.BranchManager;
import com.example.demo.repositories.ManagerRepository;

@Service
public class ManagerService {

	@Autowired
	ManagerRepository managerRepo;

	public void AddManager(BranchManager branchManager) {
	managerRepo.save(branchManager);
}

}
