package com.example.demo.hello.Configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.example.demo.hello.Entities.Citizen;
import com.example.demo.hello.Services.CitizenService;

@Configuration
@Order(1)
public class CitizenServiceConfig implements CommandLineRunner{

	@Autowired
	private CitizenService cs;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Initial Data for Citizens
		Citizen c1 = new Citizen("Christos", "Christodoulou", "111222333","chris@uom.edu.gr", "ChrisPass");
		cs.addCitizen(c1);
		Citizen c2 = new Citizen("Maria", "Papadopoulou", "123456789","mariavas@gmail.com", "testuser654321");
		cs.addCitizen(c2);
		Citizen c3 = new Citizen("Apostolos", "Nikolaidhs", "456123789","dai17085@uom.edu.gr", "FakePass");
		cs.addCitizen(c3);
		Citizen c4 = new Citizen("Eleni", "Petaloti", "123456789","elena@uom.edu.gr", "ElenaPass");
		cs.addCitizen(c4);
		Citizen c5 = new Citizen("Vasileios", "Lagopoulos", "123456789","vasilis@uom.edu.gr", "VasilisPass");
		cs.addCitizen(c5);
		Citizen c6 = new Citizen("Dimitris", "Nikolaou", "999888777","dimnikol@outlook.com", "NikolDim!@");
		cs.addCitizen(c6);
		Citizen c7 = new Citizen("Antonia", "Charalampidou", "654654654","antonia@gmail.com", "Antonia123!#");
		cs.addCitizen(c7);
		Citizen c8 = new Citizen("Nikoleta", "Panagiotidou", "111999888","nikoletaPan@hotmail.com", "Nikol1996@!");
		cs.addCitizen(c8);
		Citizen c9 = new Citizen("Giannis", "Hatzinikolaou", "156156156","hatzigian@gmail.com", "HatziGian1987!");
		cs.addCitizen(c9);
		Citizen c10 = new Citizen("Marina", "Giagkoglou", "434434434","margiagk@outlook.com", "GiagkMar6565!");
		cs.addCitizen(c10);

		
		
	}
}
