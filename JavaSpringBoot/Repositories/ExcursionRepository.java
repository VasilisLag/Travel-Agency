package com.example.demo.hello.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.hello.Entities.*;

import java.util.List;

@Repository
public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
	List<Excursion> findByTravelAgencyId(Long travelAgencyId);
	Optional<Excursion> findByName(String name);
	List<Excursion> findByDepartureLocation(String departureLocation);
	List<Excursion> findByArrivalLocation(String arrivalLocation);
	List<Excursion> findByStartDate(String startDate);
	List<Excursion> findByEndDate(String endDate);

	Optional<Excursion> findById(Long id);
}
