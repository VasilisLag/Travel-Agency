package com.example.demo.hello.Controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import com.example.demo.hello.Entities.*;
import com.example.demo.hello.Services.TravelAgencyService;

// Endpoints
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TravelAgencyController {

	@Autowired
	private TravelAgencyService tas;
	
	
	@GetMapping(path="/allAgencies")
	public List<TravelAgency> getAllAgencies()  throws Exception{
		return tas.getAllAgencies();
	} 
	
	@PostMapping(path="/registerAgency")
	public boolean addAgency(@RequestBody TravelAgency ta) throws Exception {
		String name = ta.getName();
		String afm = ta.getAfm();
		String owner = ta.getOwner();
		String password = ta.getPassword();
		if (name != null && afm != null && owner != null && password != null)
		{
			TravelAgency ta1 = new TravelAgency(afm, name, owner, password);
			tas.addTravelAgency(ta1);
			return true;
		}
		return false;
		
	}
	

}
