package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Approval;

public interface ApprovalRepository extends JpaRepository<Approval,Integer> {
}

