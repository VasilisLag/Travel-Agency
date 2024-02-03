package com.example.demo.hello.Configs;

import org.springframework.boot.*;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

import com.example.demo.hello.Entities.*;
import com.example.demo.hello.Services.TravelAgencyService;
import org.springframework.beans.factory.annotation.*;

@Configuration
@Order(2)
public class TravelAgencyServiceConfig implements CommandLineRunner {
	
	@Autowired
	private TravelAgencyService tas;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Initial Data for Travel Agencies
		TravelAgency ta1 = new TravelAgency("999888777", "Sky Explorers", "Manolhs Nikolaou", "PASS123");
		tas.addTravelAgency(ta1);

		TravelAgency ta2 = new TravelAgency("111222333", "Greek Adventures", "Nikos Manwlidhs", "MYGOODPASSWORD");
		tas.addTravelAgency(ta2);
		
		TravelAgency ta3 = new TravelAgency("444555666", "Global Discover", "Eleni Dhmopoulou", "GreekPass123@");
		tas.addTravelAgency(ta3);
		
		

		
		
	}

}
