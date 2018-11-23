/**
 * 
 */
package com.canada.recipefinder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.canada.recipefinder.entity.RoleEntity;

/**
 * @author MENAD
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

	public RoleEntity findByRole(String role);

}
