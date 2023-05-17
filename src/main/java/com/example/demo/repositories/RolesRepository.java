package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
	@Query("SELECT r FROM Roles r WHERE r.roleName= ?1")
	public Roles findByName(String roleName);
}
