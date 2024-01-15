package com.example.demo.hello.Services;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.example.demo.hello.Repositories.UserRepository;
import com.example.demo.hello.Entities.User;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;


	public List<User> getAllUsers() throws Exception 
	{
		return userRepository.findAll();
	}

	public Optional<User> potentialUser(String username, String password)
	{
		Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
		return user;
        
	}
	
	
}
