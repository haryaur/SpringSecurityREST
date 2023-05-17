package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Contacts;
import com.example.demo.repositories.ContactsRepository;

@Service
public class ContactsService {

	@Autowired
	ContactsRepository contactsRepo;

	public void AddContacts(Contacts contacts) {
	contactsRepo.save(contacts);
}

}
