package com.canada.recipe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.canada.recipefinder.entity.RoleEntity;
import com.canada.recipefinder.entity.UserEntity;
import com.canada.recipefinder.services.AccountService;

/*
 * First commit --reloaded the project
 * a test to make sure the git is set up correctly
 * added moduless
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
@EnableWebSecurity
@ComponentScan({"com.canada.*"})
@EnableJpaRepositories({"com.*"})
@EntityScan({"com.*"})
public class RecipeApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RecipeApplication.class, args);
	}
	
	@Autowired
	AccountService service;
	
	
	
	@Bean
	public BCryptPasswordEncoder getBcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
  
	@Override
	public void run(String... arg0) throws Exception{
		RoleEntity role = new RoleEntity(null, "USER");
  
		UserEntity userEntity = new UserEntity(null,"user","test",null );
		UserEntity userEntity1 = new UserEntity(null,"user1","test",null );
		service.saveUser(userEntity);
		service.saveUser(userEntity1);
		service.saveRole(role);
		service.addRoleToUser("user", "USER");
		service.addRoleToUser("user1", "USER");
		
	}
}
