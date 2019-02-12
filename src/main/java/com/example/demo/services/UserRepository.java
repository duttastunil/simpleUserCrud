package com.example.demo.services;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	
	
	@SuppressWarnings("unchecked")
	public User save(User user);
	public User findUserByuid(int uid);
	//public User deleteUserByuid(int uid);

}
