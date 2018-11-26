/**
 * 
 */
package com.canada.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.canada.recipefinder.entity.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author MENAD
 *
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	private ObjectMapper objectMapper = new ObjectMapper();
	private final AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter(final AuthenticationManager authenticationManager) {
		this.authenticationManager=authenticationManager;
	}
	
	
	 @Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
	    UserEntity user = null;
		try {
			user = objectMapper.readValue( request.getInputStream(), UserEntity.class);
			
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
		logger.info("Username :{}, password: {}", user.getUsername(), user.getPassword());
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
	}
	 
	 
	 
	 @Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		 final User springUser = (User) authResult.getPrincipal();
		 final String JwtToken = Jwts.builder()
				 .setSubject(springUser.getUsername())
				 .setExpiration(SecurityConstants.DATE)
				 .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
				 .claim("roles", springUser.getAuthorities())
				 .compact();
		response.addHeader(SecurityConstants.AUTHORIZATION,SecurityConstants.TOKEN+ JwtToken);
	} 

}
