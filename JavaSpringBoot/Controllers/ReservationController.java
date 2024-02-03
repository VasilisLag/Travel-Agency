package com.example.demo.hello.Controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import com.example.demo.hello.DTOs.ReservationDTO;
import com.example.demo.hello.Entities.*;
import com.example.demo.hello.Services.CitizenService;
import com.example.demo.hello.Services.ExcursionService;
import com.example.demo.hello.Services.ReservationService;

// Endpoints
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ReservationController {

	@Autowired
	private ReservationService rs;
	@Autowired
	private CitizenService cs;
	@Autowired
	private ExcursionService es;
	

	
	@GetMapping(path="/allReservations")
	public List<Reservation> getAllReservations()  throws Exception{
		return rs.getAllReservations();
	} 
	
	@PostMapping(path="/addReservation")
	public boolean addReservation(@RequestBody ReservationDTO rd) throws Exception{
		Long citId = rd.getCitizen();
		Long exId = rd.getExcursion();
		int persons = rd.getPersons();
		System.out.println(persons);
		Citizen c1 = cs.getCitizenById(citId)
                .orElseThrow(() -> new NoSuchElementException("Citizen not found "));
		Excursion ex1 = es.getExcursionById(exId)
                .orElseThrow(() -> new NoSuchElementException("Excursion not found "));
		if(c1 != null && ex1 != null && persons > 0) {
			Reservation r = new Reservation(c1, ex1, persons);
			boolean reservationHappened = rs.addReservation(r);
			return reservationHappened;
		}
		return false;
		
		
		
	}
	
	
	

	

}
