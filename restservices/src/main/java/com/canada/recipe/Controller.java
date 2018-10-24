/**
 * 
 */
package com.canada.recipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MENAD
 *
 */
@RestController
@RequestMapping("/api")
public class Controller {
	
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TestRepository TestRepository;
	
	
	
	@PostMapping(path="/test")
	public String printMessage(@RequestBody Test test) {
		LOGGER.info("This is a test to make sure the  controller works just fine");
		TestRepository.save(test);
		return "TEST";
	}
	
	
	
	

}
