package com.example.demo.hello.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.hello.Entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
  
}
