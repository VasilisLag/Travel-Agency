package com.example.demo.hello.Controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import com.example.demo.hello.Entities.*;
import com.example.demo.hello.Services.CitizenService;

//Endpoints
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CitizenController {

	
	@Autowired
	private CitizenService cs;
	
	@GetMapping(path="/allCitizens")
	public List<Citizen> getAllCitizens()  throws Exception{
		return cs.getAllCitizens();
	} 
	
	@PostMapping(path="/registerCitizen")
	public boolean addCitizen(@RequestBody Citizen c) throws Exception {
		String name = c.getName();
		String surname = c.getSurname();
		String afm = c.getAfm();
		String email = c.getEmail();
		String password = c.getPassword();
		if (name != null && surname != null && afm != null && email != null && password != null) {
			Citizen c1 = new Citizen(name, surname, afm, email, password);
			cs.addCitizen(c1);
			return true;
		}
		return false;
		
	}
	
}
