package com.example.demo.hello.Services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.example.demo.hello.Entities.TravelAgency;
import com.example.demo.hello.Repositories.*;


@Service
public class TravelAgencyService {

	@Autowired
	private TravelAgencyRepository travelAgencyRepository;

	public void addTravelAgency(TravelAgency ta) throws Exception 
	{
		 if (ta.getId() != null && travelAgencyRepository.existsById(ta.getId())) 
		 {
		        throw new Exception("Travel Agency with ID " + ta.getId() + " already exists.");
		 }

		    travelAgencyRepository.save(ta);
	}
	
	public Optional<TravelAgency> getAgencyByName(String name){
		return travelAgencyRepository.findByName(name);
	}

	public Optional<TravelAgency> getAgencyById(Long id){
		return travelAgencyRepository.findById(id);
	}
	
	public List<TravelAgency> getAllAgencies() throws Exception {
		return travelAgencyRepository.findAll();
	}
	

}
	
	
	

