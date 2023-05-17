package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.StaffPosition;
import com.example.demo.repositories.StaffPositionRepository;

@Service
public class StaffPositionService {

	@Autowired
	StaffPositionRepository staffRepo;

	public void AddNewPosition(StaffPosition staffPosition) {
	staffRepo.save(staffPosition);
}
}
