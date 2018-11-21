/**
 * 
 */
package com.canada.recipefinder.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.canada.recipefinder.entity.UserEntity;

/**
 * @author MENAD
 *
 */
public interface UserRepository extends JpaRepository<UserEntity, String>{
	public UserEntity findByEmail(String email );

}
