package com.condigence.medicare.repository;

import org.springframework.data.repository.CrudRepository;

import com.condigence.medicare.model.User;

public interface LoginRepository extends CrudRepository<User, Integer>{

}
