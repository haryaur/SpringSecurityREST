package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Roles;
import com.example.demo.repositories.BranchRepository;
import com.example.demo.repositories.RolesRepository;
import com.example.demo.services.BranchService;
import com.example.demo.services.RolesService;


@RestController
public class RolesController {

	@Autowired
	RolesService roleService;

	@Autowired
	RolesRepository roleRepo;

	@Autowired
	BranchRepository branchRepo;

	@Autowired
	BranchService branchService;


	@PostMapping("/addRoles")
	public String AddRoles(@RequestBody Roles roles) {
	  roleService.AddNewRole(roles);
	  return ("Role has been Added");
	}


}
