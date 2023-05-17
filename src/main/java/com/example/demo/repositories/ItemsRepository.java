package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer>{

}
