/**
 * 
 */
package com.canada.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.canada.recipefinder.entity.UserEntity;
import com.canada.recipefinder.services.AccountService;

/**
 * @author MENAD
 *
 */
@RestController
public class registrationController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	AccountService accountService;
	
	
	@PostMapping(value="/register")
	public UserEntity register(@RequestBody UserEntity userEntity) {
		logger.info("username: {}", userEntity.getUsername());
		logger.info("password: {}", userEntity.getPassword());
		userEntity.getRoles().add(accountService.findRoleByName("USER"));
		return accountService.saveUser(userEntity);
		
		 
	}
	
	@GetMapping(value="/users")
	public List<UserEntity> getUers(){
		return accountService.findAll();
	}

}
