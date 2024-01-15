package com.example.demo.hello.Services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.example.demo.hello.Entities.Reservation;
import com.example.demo.hello.Repositories.*;


@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;


	
	public void addReservation(Reservation r) throws Exception
	{
		if (r.getId() != null && reservationRepository.existsById(r.getId())) {
	        throw new Exception("Reservation with ID " + r.getId() + " already exists.");
	    }

	    reservationRepository.save(r);
	}
	
	
	public List<Reservation> getAllReservations() throws Exception {
		return reservationRepository.findAll();
	}
	
	
	
}
