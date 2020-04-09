package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.Entites.AppRole;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
	public AppRole findByRoleName(String roleName);	

}
