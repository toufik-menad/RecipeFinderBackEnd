/**
 * 
 */
package com.canada.recipefinder.services;

import java.util.List;

import com.canada.recipefinder.entity.RoleEntity;
import com.canada.recipefinder.entity.UserEntity;

/**
 * @author MENAD
 *
 */
public interface AccountService {
	
	public UserEntity saveUser(UserEntity user);
	public RoleEntity saveRole(RoleEntity role);
	public void addRoleToUser(String userName, String role); 
	public UserEntity findUserByEmail(String email);
	public RoleEntity findRoleByName(String roleName);
	public List<UserEntity> findAll();

}
