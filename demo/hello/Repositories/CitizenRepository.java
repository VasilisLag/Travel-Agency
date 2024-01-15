package com.example.demo.hello.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.hello.Entities.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
	Optional<Citizen> findById(Long id);

}
