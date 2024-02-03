package com.example.demo.hello.Services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.example.demo.hello.Entities.Excursion;
import com.example.demo.hello.Entities.Reservation;
import com.example.demo.hello.Repositories.*;


@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private ExcursionRepository excursionRepository;

	
	public boolean addReservation(Reservation r) throws Exception
	{
		if (r.getId() != null && reservationRepository.existsById(r.getId())) {
	        throw new Exception("Reservation with ID " + r.getId() + " already exists.");
	    }
		
		int desiredPersons = r.getPersons();
		Excursion e = r.getExcursion();
		
        if (desiredPersons <= e.getCapacity()) {
            // Decrease the excursion's capacity by the number of persons
            e.setCapacity(e.getCapacity() - desiredPersons);
            excursionRepository.save(e); // Update the excursion's capacity
            reservationRepository.save(r); // Save the reservation
            return true; // Reservation successful
        } else {
            return false; // Reservation failed due to insufficient capacity
        }

	   
	}
	
	
	public List<Reservation> getAllReservations() throws Exception {
		return reservationRepository.findAll();
	}
	
	
	
}
