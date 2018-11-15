/**
 * 
 */
package com.canada.recipefinder.entity;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author MENAD
 *
 */

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<Role>();

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}