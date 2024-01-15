package com.example.demo.hello.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Excursion {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String departureLocation;
    private String arrivalLocation;
    private double price;
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "travel_agency_id")
    private TravelAgency travelAgency;

    // Getters
    public String getName() {return name;}
    public String getDescription() {return description;}
    public String getStartDate() {return startDate;}
    public String getEndDate() {return endDate;}
    public String getDepartureLocation() {return departureLocation;}
    public String getArrivalLocation() {return arrivalLocation;}
    public double getPrice() {return price;}
    public int getCapacity() {return capacity;}
    public TravelAgency getAgency() {return travelAgency;}
    public Long getId() {return id;}
    
    
    
    // Default constructor
    public Excursion() {

    }

    // Constructor with parameters
    public Excursion(String name, String description, String startDate, String endDate,
    				String departureLocation, String arrivalLocation, double price, int capacity ,TravelAgency agency)
    {
    	this.name = name;
    	this.description = description;
    	this.startDate = startDate;
    	this.endDate = endDate;
    	this.departureLocation = departureLocation;
    	this.arrivalLocation = arrivalLocation;
    	this.price = price;
    	this.capacity = capacity;
    	this.travelAgency = agency;
    }
    

    

}

