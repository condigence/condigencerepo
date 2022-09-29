package com.digitmarket.defaultstore.vendor.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitmarket.defaultstore.vendor.model.Role;
import com.digitmarket.defaultstore.vendor.model.User;
import com.digitmarket.defaultstore.vendor.repository.RoleRepository;
import com.digitmarket.defaultstore.vendor.repository.UserRepository;


@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

//	@Override
//	public User findUserByEmail(String email) {
//		return userRepository.findByEmail(email).get(0);
//	}

//	@Override
//	public void saveUser(User user) {
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//		user.setActive(true);
//		//TODO : FIX ME Vish
//		Role userRole = roleRepository.findByRole("VENDOR");
//		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//		userRepository.save(user);
//	}

//	@Override
//	@Transactional
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		// Here User name is email id only
//		User user = userRepository.findByEmail(email).get(0);
//		List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
//		return buildUserForAuthentication(user, authorities);
//	}

//	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
//		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
//		for (Role role : userRoles) {
//			roles.add(new SimpleGrantedAuthority(role.getRole()));
//		}
//
//		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
//		return grantedAuthorities;
//	}

//	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
//		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
//				user.isActive(), true, true, true, authorities);
//	}	
//	
//	@Override
//	public List<User> findUsersByName(String name) {
//		return userRepository.findByName(name);
//	}
//	
//	@Override
//	public List<User> findUsersByEmail(String name) {
//		return userRepository.findByEmail(name);
//	}

}