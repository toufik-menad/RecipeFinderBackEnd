/**
 * 
 */
package com.canada.recipefinder.ejb;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.canada.recipefinder.entity.UserEntity;
import com.canada.recipefinder.services.AccountService;

/**
 * @author MENAD
 *
 */

public class UserDetailsServiceImpl implements UserDetailsService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		final UserEntity userEntity = accountService.findUserByEmail(email);
		if(userEntity==null) {
			throw new UsernameNotFoundException(email);
		}
		
		logger.info("userEntity: {}",userEntity.toString());
		
		final Collection<GrantedAuthority>authorities=new ArrayList<>();
		
		userEntity.getRoles().stream().forEach(role ->{
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		});
		
		logger.info("authorities: {}",authorities.size() );
		
		User user = new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
		return user;
	}

}
