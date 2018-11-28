/**
 * 
 */
package com.canada.security;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @author MENAD
 *
 */
public class JWTAuthorizationFilter extends OncePerRequestFilter  {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String jwt = request.getHeader(SecurityConstants.AUTHORIZATION);
		logger.info("jwt"+jwt);
		
		if(jwt == null || !jwt.startsWith(SecurityConstants.TOKEN)) {
			filterChain.doFilter(request, response);
			logger.info("Token not valid");
			return;
		}else {
			
			final Claims claims = Jwts.parser()
					.setSigningKey(SecurityConstants.SECRET)
					.parseClaimsJws(jwt.replace(SecurityConstants.TOKEN , ""))
					.getBody();
			final String username = claims.getSubject();
			final List<Map<String,String>> roles = (List<Map<String, String>>) claims.get("roles");
			
			final Collection<GrantedAuthority>authorities = roles.stream().map(r -> new SimpleGrantedAuthority(r.get("authority"))).collect(Collectors.toList());
			
			final UsernamePasswordAuthenticationToken userNamePasswordToken = new UsernamePasswordAuthenticationToken(username,null,authorities);
			SecurityContextHolder.getContext().setAuthentication(userNamePasswordToken);
			filterChain.doFilter(request, response);
		}
		
	}
	
	
	

}
