package com.example.demo.security;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*
		auth.inMemoryAuthentication()
        .withUser("admin").password("123").roles("ADMIN","USER").
        and()
       .withUser("USER").password("1234").roles("USER");		
       */
		auth.userDetailsService(userDetailsService).
		passwordEncoder(bCryptPasswordEncoder);
		
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable();
	http.formLogin();
	http.authorizeRequests().antMatchers("/login/**","register/**").permitAll();
	http.authorizeRequests().antMatchers(HttpMethod.POST,"/tasks/**").hasAnyAuthority("ADMIN");
	http.authorizeRequests().anyRequest().authenticated();
	
	}

}
