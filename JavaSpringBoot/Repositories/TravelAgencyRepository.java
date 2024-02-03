package com.example.demo.hello.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.hello.Entities.TravelAgency;

@Repository
public interface TravelAgencyRepository extends JpaRepository<TravelAgency, Long> {
    
	Optional<TravelAgency> findByName(String name);
    
}
