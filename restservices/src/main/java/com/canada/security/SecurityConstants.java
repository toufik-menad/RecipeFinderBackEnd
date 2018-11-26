/**
 * 
 */
package com.canada.security;

import java.util.Date;

/**class that holds all the constants used at the moment we generate the jwt
 * @author MENAD
 *
 */
abstract class SecurityConstants {

	public static final String SECRET = "TEST";
	public static final Date DATE = new Date(System.currentTimeMillis()+500);
	public static final String TOKEN = "Bearer ";
	public static final String AUTHORIZATION = "Authorization";
	
	

}
