package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entites.Role;


@Repository
public interface RoleRepository  extends JpaRepository<Role, String>{


	Role findByRole(String role);


}
