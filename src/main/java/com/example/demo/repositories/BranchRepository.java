package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.BranchLocation;

public interface BranchRepository extends JpaRepository<BranchLocation, Integer>{

}
