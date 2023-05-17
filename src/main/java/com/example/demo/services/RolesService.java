package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Roles;
import com.example.demo.repositories.RolesRepository;

@Service
public class RolesService {

	@Autowired
	RolesRepository rolesRepo;

	public void AddNewRole(Roles roles) {
	rolesRepo.save(roles);
}

}
