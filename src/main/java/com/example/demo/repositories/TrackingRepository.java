package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Tracking;

public interface TrackingRepository extends JpaRepository<Tracking,Integer> {

}
