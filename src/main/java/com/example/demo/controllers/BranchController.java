package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.BranchLocation;
import com.example.demo.services.BranchService;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;


	@PostMapping("/addBranch")
	public String AddBranch(@RequestBody BranchLocation branchLocation) {
	  branchService.AddNewBranch(branchLocation);
	  return ("Branch has been successfully added");
	}

}