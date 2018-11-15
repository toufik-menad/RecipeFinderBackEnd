/**
 * 
 */
package com.canada.recipefinder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MENAD
 *
 */
@Entity
@Table(name="role")
public class RoleEntity {
	@Id
	@Column(unique=true , nullable=false)
	private String role;

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
