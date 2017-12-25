package com.condigence.medicare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.condigence.medicare.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {	
	
	public List<User> findAllByOrderByIdDesc();
	
	List<User> findByLastName(String name);

	List<User> findByName(String name);

	List<User> findByEmail(String email);
}
