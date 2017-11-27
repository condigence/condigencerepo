package com.condigence.medicare.services;

import java.util.List;

import com.condigence.medicare.dto.UserDTO;
import com.condigence.medicare.model.User;

public interface UserService {

	public User findUserByEmail(String email);

	public void saveUser(User user);

	public List<UserDTO> findUsersByName(String name);

	public List<UserDTO> findUsersByEmail(String email);
}
