/**
 * 
 */
package com.canada.recipefinder.dto;

import javax.persistence.Entity;

/**
 * @author MENAD
 *
 */
@Entity
public class User {
	
	private String email;
	private String password;
	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public final void setPassword(String password) {
		this.password = password;
	}

}
