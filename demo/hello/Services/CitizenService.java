package com.example.demo.hello.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hello.Entities.Citizen;
import com.example.demo.hello.Repositories.CitizenRepository;

@Service
public class CitizenService {

	@Autowired
	private CitizenRepository citizenRepository;
	
	public void addCitizen(Citizen c) throws Exception {
		 if (c.getId() != null && citizenRepository.existsById(c.getId())) {
		        throw new Exception("Citizen with ID " + c.getId() + " already exists.");
		    }

		    citizenRepository.save(c);	
	}
	
	
	public Optional<Citizen> getCitizenById(Long id){
		return citizenRepository.findById(id);
	}
	
	public List<Citizen> getAllCitizens() throws Exception {
		return citizenRepository.findAll();
	}
}
