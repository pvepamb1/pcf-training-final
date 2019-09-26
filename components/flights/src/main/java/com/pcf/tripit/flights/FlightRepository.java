package com.pcf.tripit.flights;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {

    Iterable<Flight> findByToAndFromAndDate(String to, String from, String date);

    Iterable<Flight> findByToAndFrom(String to, String from);
}
