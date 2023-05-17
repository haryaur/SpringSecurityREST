package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.BranchManager;

public interface ManagerRepository extends JpaRepository<BranchManager,Integer> {

}
