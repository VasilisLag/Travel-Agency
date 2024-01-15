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
    
    // Getter
    public Long getId() {return id;}
    
    // Default constructor
    public Reservation() {
    }

    // Constructor with parameters
    public Reservation(Citizen citizen, Excursion excursion) {
        this.citizen = citizen;
        this.excursion = excursion;
    }


}

