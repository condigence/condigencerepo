package com.condigence.medicare.repository;

import org.springframework.stereotype.Service;

import com.condigence.medicare.model.User;


@Service
public class LoginSearchRepositoryimpl implements LoginSearchRepository {

	

	@Override
	public User findUserByContactNo(long l) {
		User u1 = new User();
		u1.setEmail("ankit.ankit.saini@gmail.com");
		u1.setContactNo(9742085972L);
		u1.setPassword("12345");
		u1.setUserName("Ankit Saini");
		
		return u1;
	}

	@Override
	public User findUserByemail(String search) {
		User u1 = new User();
		u1.setEmail("ankit.ankit.saini@gmail.com");
		u1.setContactNo(9742085972L);
		u1.setPassword("12345");
		u1.setUserName("Ankit Saini");
		return u1;
	}

}
