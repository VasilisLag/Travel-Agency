package com.example.demo.hello.Entities;
import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;

    @OneToOne
    @JoinColumn(name = "excursion_id")
    private Excursion excursion;
    
    private int persons;
    // Getter
    public Long getId() {return id;}
    public int getPersons() {return persons;}
    public Excursion getExcursion() {return excursion;}
    
    // Default constructor
    public Reservation() {
    }

    // Constructor with parameters
    public Reservation(Citizen citizen, Excursion excursion, int persons) {
        this.citizen = citizen;
        this.excursion = excursion;
        this.persons = persons;
    }


}

