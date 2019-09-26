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

@RestController
@RequestMapping("/flights")
public class FlightController {

    private FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

    @GetMapping("/filter")
    public Iterable<Flight> getFlights(@RequestParam String to, @RequestParam String from, @RequestParam String date) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        Iterable<Flight> flights = flightRepository.findByDestinationAndSource(to, from);
        List<Flight> available = new ArrayList<>();
        for (Flight flight:flights) {
            if(flight.getDepartureTime().getDate()==date1.getDate() && flight.getTicketsLeft()!=0)
                available.add(flight);
        }
        return available;
    }

    @GetMapping("/book")
    public ResponseEntity<Flight> bookFlight(@RequestParam String name, @RequestParam String flightNumber, @RequestParam String from,
                                             @RequestParam String to, @RequestParam String departureTime, @RequestParam String arrivalTime) throws ParseException {
        LOGGER.info("In book");
        Date beginDate = new SimpleDateFormat("yyyy-MM-dd").parse(departureTime);
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(arrivalTime);
        Flight flight = flightRepository
                .findByAirlinesNameAndFlightNumberAndSourceAndDestinationAndDepartureTimeAndArrivalTime
                        (name, flightNumber, from, to, departureTime, arrivalTime).get(0);
        flight.setTicketsLeft(flight.getTicketsLeft()-1);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
