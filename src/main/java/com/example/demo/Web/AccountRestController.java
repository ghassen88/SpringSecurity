package com.example.demo.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entites.AppUser;
import com.example.demo.service.AccountService;

@RestController
public class AccountRestController {

	
	@Autowired
	private AccountService accountService;
	
  @PostMapping(value = "register")
	public AppUser saveUser(@RequestBody AppUser user) {
		return accountService.saveUser(user);
	}
	
	

}
