package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entites.Role;
import com.example.demo.Entites.User;


@Repository
public interface UserRepository extends JpaRepository<User,String> {

	User findByUsername(String username);

	





}
