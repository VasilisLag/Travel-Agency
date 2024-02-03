package com.example.demo.hello.Controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.hello.DTOs.ExcursionDTO;
import com.example.demo.hello.Entities.*;
import com.example.demo.hello.Services.ExcursionService;
import com.example.demo.hello.Services.TravelAgencyService;

// Endpoints
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ExcursionController {

	@Autowired
	private ExcursionService es;
	@Autowired
	private TravelAgencyService tas;
	
	
	

	@GetMapping(path = "/allExcursions")
	public List<Excursion> getAllExcursions(
	    @RequestParam(required = false) Long agencyId,
	    @RequestParam(required = false) String departureLocation,
	    @RequestParam(required = false) String arrivalLocation,
	    @RequestParam(required = false) String startDate,
	    @RequestParam(required = false) String endDate

	) throws Exception {
		List<Excursion> List1 = es.getAllExcursions();
	    if (agencyId != null) {
	    	List<Excursion> tempList = es.getExcursionByAgencyId(agencyId);
	    	List1 = findCommonObjects(List1, tempList);
	    } 
	    if (departureLocation != "") {
	    	List<Excursion> tempList = es.getExcursionsByDepartureLocation(departureLocation);
	    	List1 = findCommonObjects(List1, tempList);
	    } if (arrivalLocation != "") {
	    	List<Excursion> tempList = es.getExcursionsByArrivalLocation(arrivalLocation);
	    	List1 = findCommonObjects(List1, tempList);
	    }if (startDate != "") {
	    	List<Excursion> tempList = es.getExcursionsByStartDate(startDate);
	    	List1 = findCommonObjects(List1, tempList);
	    }
	    if (endDate != "") {
	    	List<Excursion> tempList = es.getExcursionsByEndDate(endDate);
	    	List1 = findCommonObjects(List1, tempList);
	    }
	    
	    
	    return List1;
	}

	
	 public static <T> List<T> findCommonObjects(List<T> list1, List<T> list2) {
	        Set<T> set1 = new HashSet<>(list1);
	        List<T> commonObjects = new ArrayList<>();

	        for (T obj : list2) {
	            if (set1.contains(obj)) {
	                commonObjects.add(obj);
	            }
	        }

	        return commonObjects;
	    }

	
	@GetMapping(path="/excursion")
	public ResponseEntity<Excursion> getExcursionById(@RequestParam(required = true) Long id) throws Exception {
		if (id != null) {
	        try {
	            Excursion ex = es.getExcursionById(id)
	                    .orElseThrow(() -> new NoSuchElementException("Excursion not found"));
	            return ResponseEntity.ok(ex);
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build(); // Excursion not found
	        }
	    } else {
	        return ResponseEntity.badRequest().build(); // Invalid or missing id
	    }
	}
	
	@PostMapping(path="/registerExcursion")
	public void addExcursion(@RequestBody ExcursionDTO ex) throws Exception{
		String name = ex.getName();
		String description = ex.getDescription();
		String startDate = ex.getStartDate();
		String endDate = ex.getEndDate();
		String depLocation = ex.getDepartureLocation();
		String arrLocation = ex.getArrivalLocation();
		double price = ex.getPrice();
		int capacity = ex.getCapacity();
		Long agencyId = ex.getAgencyId();
		
		TravelAgency ta = tas.getAgencyById(agencyId)
                .orElseThrow(() -> new NoSuchElementException("Travel agency not found "));

		Excursion e = new Excursion(name, description, startDate, endDate, depLocation, arrLocation, price, capacity, ta);
		es.addExcursion(e);
		
	}
	
	
	

	

}
