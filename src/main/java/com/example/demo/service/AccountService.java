package com.example.demo.service;

import com.example.demo.Entites.AppRole;
import com.example.demo.Entites.AppUser;

public interface AccountService {
	
	public AppUser saveUser(AppUser u);
	public AppRole saveRole(AppRole r);
	public void addRoleroUser(String username ,String role);
	public AppUser findUserByUsername(String username);

}
