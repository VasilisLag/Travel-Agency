package com.example.demo.hello.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class TravelAgency extends User {
	
	@Column(name="Name")
    private String name;
	@Column(name="AFM")
    private String afm;
	@Column(name="Owner")
    private String owner;

	// Getters
    public String getPassword() {return super.getPassword();}
    public String getAfm() {return afm;}
    public String getOwner() {return owner;}
    public String getName() {return name;}
    public Long getId() {return super.getId();}

    
    // Default constructor
    public TravelAgency() {

    }

    // Constructor with parameters
    public TravelAgency( String afm, String name, String owner, String password) {
        super(afm, password, "travel_agency");
        this.afm = afm;
        this.owner = owner;
        this.name = name;
    }
    

}

