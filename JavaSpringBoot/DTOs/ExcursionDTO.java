package com.example.demo.hello.DTOs;


public class ExcursionDTO {
	
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String departureLocation;
    private String arrivalLocation;
    private double price;
    private int capacity;
    private Long agencyId;
    
	public String getName() {return name;}
    public String getDescription() {return description;}
    public String getStartDate() {return startDate;}
    public String getEndDate() {return endDate;}
    public String getDepartureLocation() {return departureLocation;}
    public String getArrivalLocation() {return arrivalLocation;}
    public double getPrice() {return price;}
    public int getCapacity() {return capacity;}
    public Long getAgencyId() {return agencyId;}
}
