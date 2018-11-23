/**
 * 
 */
package com.canada.recipefinder.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canada.recipefinder.entity.UserEntity;

/**
 * @author MENAD
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	public UserEntity findByUsername(String username );

}
