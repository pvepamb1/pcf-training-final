package com.pcf.tripit.flights;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    private Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

    @GetMapping("/filter")
    public Iterable<Flight> getFlights(@RequestParam String to, @RequestParam String from, @RequestParam String date) throws ParseException {
        LOGGER.info("In filter");
        if(to.equals("")||from.equals("")||date.equals("")) return flightRepository.findAll();
        LOGGER.info("Before parsing date is {}", date);
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        LOGGER.info("After parsing date is {}", date1);
        Iterable<Flight> flights = flightRepository.findByDestinationAndSource(to, from);
        List<Flight> available = new ArrayList<>();
        for (Flight flight:flights) {
            if(flight.getDepartureTime().getDate()==date1.getDate() && flight.getTicketsLeft()!=0)
                available.add(flight);
        }
        LOGGER.info("Count is {}", available.size());
        return available;
    }

    @GetMapping("/book")
    public ResponseEntity<Flight> bookFlight(@RequestParam String airlinesName, @RequestParam String flightNumber, @RequestParam String source,
                                             @RequestParam String destination, @RequestParam String departureTime, @RequestParam String arrivalTime) throws ParseException {
        LOGGER.info("In book");
        LOGGER.info("Before parsing date is {} {}", departureTime, arrivalTime);
        Date beginDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(departureTime);
        Date endDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(arrivalTime);
        LOGGER.info("After parsing date is {} {}", beginDate, endDate);
        Flight flight = flightRepository
                .findByAirlinesNameAndFlightNumberAndSourceAndDestinationAndDepartureTimeAndArrivalTime
                        (airlinesName, flightNumber, source, destination, endDate, beginDate).get(0);
        if(flight.getTicketsLeft()==0)
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        flight.setTicketsLeft(flight.getTicketsLeft()-1);
        flightRepository.save(flight);
        LOGGER.info("booked");
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Flight> create(@RequestBody Flight flight){
        flight.setId(flight.hashCode());
        if(flight.getTicketsLeft()==0)
            flight.setTicketsLeft(new Random().nextInt(10));
        flightRepository.save(flight);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
