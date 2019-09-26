package com.pcf.tripit.flights;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {

    Iterable<Flight> findByDestinationAndSource(String to, String from);

    List<Flight> findByAirlinesNameAndFlightNumberAndSourceAndDestinationAndDepartureTimeAndArrivalTime(String airlinesName, String flightNumber, String source, String destination, Date beginDate, Date endDate);

}
