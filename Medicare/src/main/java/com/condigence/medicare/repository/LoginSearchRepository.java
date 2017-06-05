package com.condigence.medicare.repository;


import com.condigence.medicare.model.User;

public interface LoginSearchRepository {
	
	public User findUserByContactNo(long l);
	
	public User findUserByemail(String search);

}
