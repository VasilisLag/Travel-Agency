package com.example.demo.hello.Configs;

import org.springframework.boot.*;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

import com.example.demo.hello.Entities.*;
import com.example.demo.hello.Services.ExcursionService;
import com.example.demo.hello.Services.TravelAgencyService;

import org.springframework.beans.factory.annotation.*;

@Configuration
@Order(3)
public class ExcursionServiceConfig implements CommandLineRunner {

	@Autowired
	private ExcursionService es;
	@Autowired
	private TravelAgencyService tas;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Initial Data for the Excursions
		TravelAgency ta1 = tas.getAgencyByName("Sky Explorers").get();
		if (ta1 != null)
		{
			Excursion e1 = new Excursion("ΜΕΤΕΩΡΑ","Mαγευτικό ταξίδι στα Μετέωρα","2024-02-11", "2024-02-15", "ΑΘΗΝΑ","ΜΕΤΕΩΡΑ", 200, 25, ta1 ); 
			es.addExcursion(e1);
			Excursion e2 = new Excursion("ΣΑΝΤΟΡΙΝΗ","Mαγευτικό ταξίδι στην Σαντορίνη","2024-04-29", "2024-05-04", "ΘΕΣΣΑΛΟΝΙΚΗ","ΣΑΝΤΟΡΙΝΗ", 500, 25, ta1 ); 
			es.addExcursion(e2);
			Excursion e3 = new Excursion("ΜΥΚΟΝΟΣ","Mαγευτικό ταξίδι στην Μύκονο","2024-07-11", "2024-07-16", "ΠΑΤΡΑ","ΜΥΚΟΝΟΣ", 750, 25, ta1 ); 
			es.addExcursion(e3);
			Excursion e4 = new Excursion("ΗΡΑΚΛΕΙΟ","Mαγευτικό ταξίδι στο Ηράκλειο","2024-08-11", "2024-08-15", "ΓΙΑΝΝΕΝΑ","ΗΡΑΚΛΕΙΟ", 350, 25, ta1 ); 
			es.addExcursion(e4);
			Excursion e5 = new Excursion("ΤΡΙΚΑΛΑ","Mαγευτικό ταξίδι στα Τρίκαλα","2024-03-08", "2024-03-11", "ΑΘΗΝΑ","ΤΡΙΚΑΛΑ", 200, 25, ta1 ); 
			es.addExcursion(e5);
		}

		TravelAgency ta2 = tas.getAgencyByName("Greek Adventures").get();
		if (ta2 != null)
		{
			Excursion e1 = new Excursion("ΑΡΑΧΩΒΑ","Mαγευτικό ταξίδι στην Αράχωβα","2024-10-11", "2024-10-14", "ΑΘΗΝΑ","ΑΡΑΧΩΒΑ", 320, 25, ta2 ); 
			es.addExcursion(e1);
			Excursion e2 = new Excursion("ΠΗΛΙΟ","Mαγευτικό ταξίδι στο Πήλιο","2024-09-29", "2024-10-01", "ΘΕΣΣΑΛΟΝΙΚΗ","ΠΗΛΙΟ", 280, 25, ta2 ); 
			es.addExcursion(e2);
			Excursion e3 = new Excursion("ΦΛΩΡΙΝΑ","Mαγευτικό ταξίδι στην Φλώρινα","2024-12-07", "2024-12-10", "ΠΑΤΡΑ","ΦΛΩΡΙΝΑ", 250, 25, ta2 ); 
			es.addExcursion(e3);
			Excursion e4 = new Excursion("ΜΕΤΣΟΒΟ","Mαγευτικό ταξίδι στο Μέτσοβο","2024-12-11", "2024-12-14", "ΛΑΡΙΣΑ","ΜΕΤΣΟΒΟ", 350, 25, ta2 ); 
			es.addExcursion(e4);
			Excursion e5 = new Excursion("ΚΑΡΠΕΝΗΣΙ","Mαγευτικό ταξίδι στο Καρπενήσι","2024-03-08", "2024-03-11", "ΘΕΣΣΑΛΟΝΙΚΗ","ΚΑΡΠΕΝΗΣΙ", 160, 25, ta2 ); 
			es.addExcursion(e5);
		}
		
		TravelAgency ta3 = tas.getAgencyByName("Global Discover").get();
		if (ta3 != null)
		{
			Excursion e1 = new Excursion("ΒΕΡΟΛΙΝΟ","Mαγευτικό ταξίδι στο Βερολίνο","2024-10-13", "2024-10-18", "ΑΘΗΝΑ","ΒΕΡΟΛΙΝΟ", 420, 25, ta3 ); 
			es.addExcursion(e1);
			Excursion e2 = new Excursion("ΒΑΡΚΕΛΩΝΗ","Mαγευτικό ταξίδι στη Βαρκελώνη","2024-09-12", "2024-09-15", "ΘΕΣΣΑΛΟΝΙΚΗ","ΒΑΡΚΕΛΩΝΗ", 280, 25, ta3 ); 
			es.addExcursion(e2);
			Excursion e3 = new Excursion("ΠΑΡΙΣΙ","Mαγευτικό ταξίδι στο Παρίσι","2024-10-07", "2024-10-12", "ΠΑΤΡΑ","ΠΑΡΙΣΙ", 500, 25, ta3 ); 
			es.addExcursion(e3);
			Excursion e4 = new Excursion("ΛΟΝΔΙΝΟ","Mαγευτικό ταξίδι στο Λονδίνο","2024-12-11", "2024-12-16", "ΑΘΗΝΑ","ΛΟΝΔΙΝΟ", 480, 25, ta3 ); 
			es.addExcursion(e4);
			Excursion e5 = new Excursion("ΡΩΜΗ","Mαγευτικό ταξίδι στη Ρώμη","2024-03-08", "2024-03-12", "ΘΕΣΣΑΛΟΝΙΚΗ","ΡΩΜΗ", 220, 25, ta3 ); 
			es.addExcursion(e5);
		}
		
		 

	}

}
