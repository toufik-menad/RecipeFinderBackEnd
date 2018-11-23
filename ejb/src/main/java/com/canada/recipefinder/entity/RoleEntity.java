/**
 * 
 */
package com.canada.recipefinder.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MENAD
 *
 */
@Entity
public class RoleEntity {
	@Id @GeneratedValue
	@Column(unique=true)
	private Integer id;
	
	@Column(unique=true)
	private String role;
	
	
	public RoleEntity() {
	}
	
	public RoleEntity(Integer id, String role) {
		this.id = id;
		this.role = role;
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
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
