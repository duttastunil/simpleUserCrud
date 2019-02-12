package com.example.demo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;

@RestController
public class UserService {
	
	@Autowired
	UserDao userdao;
	
	@GetMapping("/user/{id}")
	
	public User getUserByID(@PathVariable int id){
		return userdao.findUserByuid(id);
	}
	
	@PostMapping("/createUser/{address}/{name}")
	
	public User createUser(@PathVariable String name, @PathVariable String address){
		User user = new User();
		user.setUser_address(address);
		user.setUserName(name);
		return userdao.saveUser(user);
	}
	
	@PostMapping("/saveUser")
	
	public User saveUser(@RequestBody User user){
		return userdao.saveUser(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	@Transactional
	public User deleteUser(@PathVariable int id){
		User user = userdao.findUserByuid(id);
		userdao.deleteUserByuid(user);
		return user;
	}
	

}
