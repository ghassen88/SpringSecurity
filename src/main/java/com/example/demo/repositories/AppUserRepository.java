package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.Entites.AppRole;
import com.example.demo.Entites.AppUser;


@Repository
public interface AppUserRepository  extends JpaRepository<AppUser, Long>{
	public AppUser findByUsername(String username);	

}
