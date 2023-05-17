package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.StaffPosition;

public interface StaffPositionRepository extends JpaRepository<StaffPosition, Integer>{

}
