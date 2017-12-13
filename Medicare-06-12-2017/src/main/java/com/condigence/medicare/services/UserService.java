package com.condigence.medicare.services;

import java.util.List;

import com.condigence.medicare.dto.UserDTO;
import com.condigence.medicare.model.User;

public interface UserService {

	public User findUserByEmail(String email);

	public void saveUser(User user);

	public List<User> findUsersByName(String name);

	public List<User> findUsersByEmail(String email);
}
