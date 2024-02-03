package com.example.demo.hello.Entities;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class Citizen extends User {
	

	@Column(name="Email")
    private String email;
	@Column(name="Afm")
    private String afm;
	@Column(name="FirstName")
    private String name;
	@Column(name="LastName")
    private String surname;

	
    public String getEmail() {return email;}
    public String getPassword() {return super.getPassword();}
    public String getAfm() {return afm;}
    public String getSurname() {return surname;}
    public String getName() {return name;}
    public Long getId() {return super.getId();}

    
    // Default constructor
    public Citizen() {

    }

    // Constructor with parameters
    public Citizen(String name, String surname,String afm, String email, String password) {
        super(email, password, "citizen");
        this.afm = afm;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    



}
