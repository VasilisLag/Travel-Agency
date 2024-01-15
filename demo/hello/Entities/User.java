package com.example.demo.hello.Entities;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name="Username")
    private String username;
    @Column(name="Password")
    private String password;
	@Column(name="Role")
    private String userType;

	// Getters
    public String getUsername() {return username;}
    public String getPassword() {return password;}
    public String getUserType() {return userType;}
    public Long getId() {return id;}
    
    
    // Default constructor
    public User() {
        
    }
    
    public User(String username, String password, String userType) {
    	this.username = username;
    	this.password = password;
    	this.userType = userType;
    }
    


}
