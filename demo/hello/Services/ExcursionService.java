package com.example.demo.hello.Services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.example.demo.hello.Entities.Excursion;
import com.example.demo.hello.Repositories.*;


@Service
public class ExcursionService {


	@Autowired
	private ExcursionRepository excursionRepository;
	
	public void addExcursion(Excursion e) throws Exception 
	{
		 if (e.getId() != null && excursionRepository.existsById(e.getId())) {
		        throw new Exception("Excursion with ID " + e.getId() + " already exists.");
		    }

		    excursionRepository.save(e);
	}
	
	public Optional<Excursion> getExcursionByName(String name){
		return excursionRepository.findByName(name);
	}
	

	public List<Excursion> getAllExcursions() throws Exception {
		return excursionRepository.findAll();
	}

	public List<Excursion> getExcursionByAgencyId(Long id) {
		return excursionRepository.findByTravelAgencyId(id);
	}
	
	public Optional<Excursion> getExcursionById(Long id){
		return excursionRepository.findById(id);
	}
	
	public List<Excursion> getExcursionsByDepartureLocation(String departureLocation) {
	    return excursionRepository.findByDepartureLocation(departureLocation);
	}

	public List<Excursion> getExcursionsByArrivalLocation(String arrivalLocation) {
	    return excursionRepository.findByArrivalLocation(arrivalLocation);

	}

	public List<Excursion> getExcursionsByStartDate(String startDate) {
	    return excursionRepository.findByStartDate(startDate);

	}
	public List<Excursion> getExcursionsByEndDate(String endDate) {
	    return excursionRepository.findByEndDate(endDate);

	}

	
	
	
}
