package com.condigence.medicare.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.condigence.medicare.dto.UserDTO;
import com.condigence.medicare.model.Role;
import com.condigence.medicare.model.User;
import com.condigence.medicare.repository.RoleRepository;
import com.condigence.medicare.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(true);
		Role userRole = roleRepository.findByRole("SUPERADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// Here User name is email id only
		User user = userRepository.findByEmail(email);
		List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
		return buildUserForAuthentication(user, authorities);
	}

	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (Role role : userRoles) {
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.isActive(), true, true, true, authorities);
	}

	@Override
	public List<UserDTO> findUsersByName(String name) {
		List<UserDTO> userDTOs = new ArrayList<>();
		List<User> users = userRepository.findByName(name);
		for (User user : users) {
			UserDTO userDTO = new UserDTO();
			userDTO.setActive(user.isActive());
			userDTO.setEmail(user.getEmail());
			userDTO.setId((int) user.getId());
			userDTO.setLastName(user.getLastName());
			userDTO.setName(user.getName());
			userDTO.setRole(user.getRoles().iterator().next().getRole());
			userDTOs.add(userDTO);
		}

		return userDTOs;
	}

	@Override
	public List<UserDTO> findUsersByEmail(String email) {
		List<UserDTO> userDTOs = new ArrayList<>();
		UserDTO userDTO = new UserDTO();
		User user = userRepository.findByEmail(email);
		userDTO.setActive(user.isActive());
		userDTO.setEmail(user.getEmail());
		userDTO.setId((int) user.getId());
		userDTO.setLastName(user.getLastName());
		userDTO.setName(user.getName());
		userDTO.setRole(user.getRoles().iterator().next().getRole());
		userDTOs.add(userDTO);

		return userDTOs;
	}
}
