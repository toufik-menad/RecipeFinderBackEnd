/**
 * 
 */
package com.canada.recipefinder.ejb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canada.recipefinder.dao.RoleRepository;
import com.canada.recipefinder.dao.UserRepository;
import com.canada.recipefinder.entity.RoleEntity;
import com.canada.recipefinder.entity.UserEntity;
import com.canada.recipefinder.services.AccountService;

/**
 * @author MENAD
 *
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserEntity saveUser(UserEntity user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public RoleEntity saveRole(RoleEntity role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String email, String roleName) {
		final RoleEntity role = roleRepository.findByRole(roleName);
		final UserEntity user = userRepository.findByEmail(email);
		user.getRoles().add(role);		
	}

	@Override
	public UserEntity findUserByUserName(String email) {
		return userRepository.findByEmail(email);
	}

}
