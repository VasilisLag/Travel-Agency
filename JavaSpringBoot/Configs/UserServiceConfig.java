package com.example.demo.hello.Configs;

import org.springframework.boot.*;
import org.springframework.context.annotation.*;
import com.example.demo.hello.Services.UserService;
import org.springframework.beans.factory.annotation.*;

@Configuration
public class UserServiceConfig implements CommandLineRunner {
	
	@Autowired
	private UserService us;
	
	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
