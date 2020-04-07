package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entites.Etudiant;
import com.example.demo.Entites.Role;
import com.example.demo.Entites.User;
import com.example.demo.Repositories.RoleRepository;
import com.example.demo.Repositories.UserRepository;

@RestController
@Secured(value = {"ROLE_ADMIN"})
public class UserRestService {
	
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
     public User saveUser(@RequestBody User u) {
		return userRepository.save(u) ;
		
	}
	@RequestMapping(value = "users", method = RequestMethod.GET)

	public List<User> listUsers(){
		return userRepository.findAll();
		
	}
	@RequestMapping(value = "saveRole", method = RequestMethod.POST)
    public Role saveRole(@RequestBody Role r) {
		return roleRepository.save(r) ;
		
	}
	@RequestMapping(value = "roles", method = RequestMethod.GET)

	public List<Role> listRoles(){
		return roleRepository.findAll();
		
	}
	public User addRoleToUser(String username,String role) {
		User u = userRepository.findByUsername(username);
		Role r = roleRepository.findByRole(role);
		u.getRoles().add(r);
		userRepository.save(u);
		return u;
		
	}
	
}
