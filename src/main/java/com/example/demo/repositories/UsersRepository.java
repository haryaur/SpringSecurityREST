package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	@Query("SELECT u FROM Users u WHERE u.email = ?1")
	public Users findByEmail(String email);
	
	@Query("SELECT u FROM Users u WHERE u.userId = ?1")
	public Users findById(Long userId);
	
}
