package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Contacts;
import com.example.demo.services.ContactsService;

@RestController
public class ContactsController {

	@Autowired
	ContactsService contactsService;


	@PostMapping("/addContacts")
	public String AddContacts(@RequestBody Contacts contacts) {
	  contactsService.AddContacts(contacts);
	  return ("Contact has been successfully added");
	}

}