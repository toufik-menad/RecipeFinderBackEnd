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


	public UserEntity(Integer id, String username, String password, Collection<RoleEntity> roles) {
		this.id = id;
		this.username = username;
		this.password = password;
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


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
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
	 * @param roles the roles to set
	 */
	public void setRoles(Collection<RoleEntity> roles) {
		this.roles = roles;
	}

}
