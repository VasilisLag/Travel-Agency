package com.example.demo.hello.Configs;

import org.springframework.boot.*;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

import com.example.demo.hello.Entities.Citizen;
import com.example.demo.hello.Entities.Excursion;
import com.example.demo.hello.Entities.Reservation;
import com.example.demo.hello.Services.CitizenService;
import com.example.demo.hello.Services.ExcursionService;
import com.example.demo.hello.Services.ReservationService;
import org.springframework.beans.factory.annotation.*;

@Configuration
@Order(4)
public class ReservationServiceConfig implements CommandLineRunner {

	@Autowired
	private ReservationService rs;
	@Autowired
	private CitizenService cs;
	@Autowired
	private ExcursionService es;

	@Override
	public void run(String... args) throws Exception {

		
		Citizen c1 = cs.getCitizenById(1L).get();
		Citizen c2 = cs.getCitizenById(2L).get();
		Citizen c3 = cs.getCitizenById(3L).get();
		Citizen c4 = cs.getCitizenById(4L).get();
		Citizen c5 = cs.getCitizenById(5L).get();
		Citizen c6 = cs.getCitizenById(6L).get();
		Citizen c7 = cs.getCitizenById(7L).get();
		Citizen c8 = cs.getCitizenById(8L).get();
		Citizen c9 = cs.getCitizenById(9L).get();
		Citizen c10 = cs.getCitizenById(10L).get();
		
		Excursion e1 = es.getExcursionByName("ΜΕΤΕΩΡΑ").get();
		Excursion e2 = es.getExcursionByName("ΣΑΝΤΟΡΙΝΗ").get();
		Excursion e3 = es.getExcursionByName("ΗΡΑΚΛΕΙΟ").get();
		Excursion e4 = es.getExcursionByName("ΜΥΚΟΝΟΣ").get();
		Excursion e5 = es.getExcursionByName("ΑΡΑΧΩΒΑ").get();
		Excursion e6 = es.getExcursionByName("ΠΗΛΙΟ").get();
		Excursion e7 = es.getExcursionByName("ΦΛΩΡΙΝΑ").get();
		Excursion e8 = es.getExcursionByName("ΜΕΤΣΟΒΟ").get();
		Excursion e9 = es.getExcursionByName("ΚΑΡΠΕΝΗΣΙ").get();
		Excursion e10 = es.getExcursionByName("ΒΕΡΟΛΙΝΟ").get();
		Excursion e11 = es.getExcursionByName("ΒΑΡΚΕΛΩΝΗ").get();
		Excursion e12 = es.getExcursionByName("ΠΑΡΙΣΙ").get();
		Excursion e13 = es.getExcursionByName("ΛΟΝΔΙΝΟ").get();
		Excursion e14 = es.getExcursionByName("ΡΩΜΗ").get();
		Excursion e15 = es.getExcursionByName("ΤΡΙΚΑΛΑ").get();

		Reservation r1 = new Reservation(c1, e1, 2); 
		rs.addReservation(r1); 
		Reservation r2 = new Reservation(c2, e2, 3); 
		rs.addReservation(r2); 
		Reservation r3 = new Reservation(c3, e3, 1); 
		rs.addReservation(r3); 
		Reservation r4 = new Reservation(c4, e11, 4); 
		rs.addReservation(r4);
		Reservation r5 = new Reservation(c5, e12, 2); 
		rs.addReservation(r5);
		Reservation r6 = new Reservation(c6, e9, 2); 
		rs.addReservation(r6);
		Reservation r7 = new Reservation(c7, e6, 2); 
		rs.addReservation(r7);
		Reservation r8 = new Reservation(c8, e3, 2); 
		rs.addReservation(r8);
		Reservation r9 = new Reservation(c9, e15, 3); 
		rs.addReservation(r9);
		Reservation r10 = new Reservation(c10, e14, 2); 
		rs.addReservation(r10);
		Reservation r11 = new Reservation(c4, e9, 5); 
		rs.addReservation(r11);
		Reservation r12 = new Reservation(c8, e12, 2); 
		rs.addReservation(r12);
		


		 

	}

}
