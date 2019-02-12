package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;

@Service
public class UserDao {
	
	@Autowired
	UserRepository repository;
	
	public User saveUser(User user){
		return repository.save(user);
		
	}
	
	public User findUserByuid(int uid){
		return repository.findUserByuid(uid);
	}
	
	public void deleteUserByuid(User user){
		 repository.delete(user);
		  
	}

}
