package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Items;
import com.example.demo.repositories.ItemsRepository;

@Service
public class ItemsService {


	@Autowired
	private ItemsRepository itemsRepo;

	public List<Items> listAll() {
		return itemsRepo.findAll();
	}

	public void addItems(Items items) {
		itemsRepo.save(items);
	}
}

