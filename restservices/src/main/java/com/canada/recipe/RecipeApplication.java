package com.canada.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 * First commit --reloaded the project
 * a test to make sure the git is set up correctly
 * added moduless
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan({"com.canada.*"})
public class RecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeApplication.class, args);
	}
}
