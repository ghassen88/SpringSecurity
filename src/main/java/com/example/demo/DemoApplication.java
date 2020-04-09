package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.Entites.AppRole;
import com.example.demo.Entites.AppUser;
import com.example.demo.service.AccountService;
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.repositories","com.example.demo.service"})
@EntityScan("com.example.demo.Entites")



public class DemoApplication   {
  
	
	@Autowired
	private AccountService accountService;
	
	
	
	public static void main(String[] args) {
		System.setProperty("server.port", "8081");
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getBCE() {
		return new BCryptPasswordEncoder();
	}
	
	
	 



	
	

}
