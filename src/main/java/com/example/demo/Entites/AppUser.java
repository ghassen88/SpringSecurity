package com.example.demo.Entites;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.web.context.annotation.ApplicationScope;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import 
lombok.NoArgsConstructor;
import lombok.Setter;

@Entity


public class AppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long Id;
	@Column(unique = true)
	private String username;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<AppRole> roles=new ArrayList();
	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppUser(Long id, String username, String password, Collection<AppRole> roles) {
		super();
		Id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<AppRole> getRoles() {
		return roles;
	}
	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}
	
	
	

}
