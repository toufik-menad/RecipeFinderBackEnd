/**
 * 
 */
package com.canada.recipefinder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canada.recipefinder.entity.RoleEntity;

/**
 * @author MENAD
 *
 */
public interface RoleRepository extends JpaRepository<RoleEntity, String> {

	public RoleEntity findByRole(String role);

}
