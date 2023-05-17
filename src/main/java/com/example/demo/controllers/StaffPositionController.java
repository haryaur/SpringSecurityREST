package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.StaffPosition;
import com.example.demo.services.StaffPositionService;

@RestController
public class StaffPositionController {

	@Autowired
	StaffPositionService positionService;


	@PostMapping("/addPosition")
	public String AddPosition(@RequestBody StaffPosition staffPosition) {
		positionService.AddNewPosition(staffPosition);
	  return ("Staff Position has been Successfully Created");
	}

}
