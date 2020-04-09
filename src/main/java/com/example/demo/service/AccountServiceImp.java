package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entites.AppRole;
import com.example.demo.Entites.AppUser;
import com.example.demo.repositories.AppRoleRepository;
import com.example.demo.repositories.AppUserRepository;

@Service
@Transactional

public class AccountServiceImp implements AccountService {
  
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AppUserRepository  appUserRepository;
	@Autowired
	private AppRoleRepository  appRoleRepository;
	@Override
	public AppUser saveUser(AppUser u) {
		String hasPw=bCryptPasswordEncoder.encode(u.getPassword());
		u.setPassword(hasPw);
		
	
		
		return appUserRepository.save(u);
	}
	@Override
	public AppRole saveRole(AppRole r) {
		return appRoleRepository.save(r);
				
	}
	@Override
	public void addRoleroUser(String username, String roleName) {
		AppUser user = appUserRepository.findByUsername(username);
		AppRole role = appRoleRepository.findByRoleName(roleName);
		user.getRoles().add(role);
		
	}
	@Override
	public AppUser findUserByUsername(String username) {
		return findUserByUsername(username);
	}
	
}
