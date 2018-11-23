/**
 * 
 */
package com.canada.recipefinder.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserEntity saveUser(UserEntity user) {
		final String pass= passwordEncoder.encode(user.getPassword());
		user.setPassword(pass);
		return userRepository.save(user);
	}

	@Override
	public RoleEntity saveRole(RoleEntity role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String role) {
		final RoleEntity roleEntity = roleRepository.findByRole(role);
		final UserEntity user = userRepository.findByUsername(username);
		user.getRoles().add(roleEntity );		
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		LOGGER.info("email {}",email );
		return userRepository.findByUsername(email);
	}

}
