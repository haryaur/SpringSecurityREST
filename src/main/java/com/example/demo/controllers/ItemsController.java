package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Items;
import com.example.demo.entities.Users;
import com.example.demo.services.ItemsService;

@RestController
public class ItemsController {

	@Autowired
	ItemsService itemsService;


	@PostMapping("/addItems")
	public String AddItems(@RequestBody Items items) {
	  itemsService.addItems(items);
	  return ("Item has been successfully created");
	}

	@GetMapping("/items")
	public List<Items> listItems() {
		List<Items> listItems = itemsService.listAll();

		return listItems;
	}
}
