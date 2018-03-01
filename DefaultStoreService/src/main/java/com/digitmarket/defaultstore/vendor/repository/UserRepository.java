package com.digitmarket.defaultstore.vendor.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitmarket.defaultstore.vendor.model.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long>{

	public List<User> findAllByOrderByIdDesc();

	List<User> findByLastName(String name);

	List<User> findByName(String name);

	List<User> findByEmail(String email);
}
