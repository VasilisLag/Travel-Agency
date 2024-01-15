package com.example.demo.hello.Controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.hello.DTOs.LoginRequest;
import com.example.demo.hello.Entities.User;
import com.example.demo.hello.Services.UserService;

// Endpoints
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

	@Autowired
	private UserService us;
	
	@PostMapping("/login" )
    public Optional<User> login(@RequestBody LoginRequest loginRequest) {
        // Check if the user exists in the database
        return us.potentialUser(loginRequest.getUsername(), loginRequest.getPassword());
    }
	

	
}
