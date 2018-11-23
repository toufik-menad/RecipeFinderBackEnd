/**
 * 
 */
package com.canada.recipefinder.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author MENAD
 *
 */

@Entity
public class UserEntity {
	@Id @GeneratedValue
	@Column(unique=true)
	private Integer id;
	
	@Column(unique = true)
	private String username;

	@Column(columnDefinition="VARCHAR(100)")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<RoleEntity> roles = new ArrayList<>();
	
	
	UserEntity(){		
	}
	
	public UserEntity(Integer id, String email, String password, Collection<RoleEntity> roles) {
		this.id = id;
		this.username = email;
		this.password = password;
		this.roles = roles;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return username;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.username = email;
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
	public Collection<RoleEntity> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
