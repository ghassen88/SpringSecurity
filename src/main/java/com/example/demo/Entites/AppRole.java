package com.example.demo.Entites;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

public class AppRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long Id;
	private String roleName;
	public AppRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppRole(Long id, String roleName) {
		super();
		Id = id;
		this.roleName = roleName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

}
