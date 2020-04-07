package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;



@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
public void globalConfig(AuthenticationManagerBuilder auth,DataSource data) throws Exception{
		
		
		/*
	auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("ADMIN","PROF");
	auth.inMemoryAuthentication().withUser("prof1").password("123").roles("PROF");
	auth.inMemoryAuthentication().withUser("et1").password("password").roles("ETUDIANT");
	auth.inMemoryAuthentication().withUser("sco1").password("123").roles("SCOLARITE");
	*/
		
		auth.jdbcAuthentication()
		.dataSource(data)
		.usersByUsernameQuery("select username as principal ,password as credentials, true form users where =?")
		.authoritiesByUsernameQuery("select users_username as principal ,roles_role as role from users_roles where users_username=?")
        .rolePrefix("ROLE_");
        
}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub toutes les requetes doit etre authentifié desiqnpattern:builder
		http.
		csrf().disable().
		authorizeRequests().anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll();
	}
}
		
		
	



