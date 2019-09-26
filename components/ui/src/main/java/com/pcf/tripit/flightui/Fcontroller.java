package com.pcf.tripit.flightui;

import com.pcf.tripit.hotelui.HotelClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/flights")
public class Fcontroller {

    private FlightClient flightClient;

    public Fcontroller(FlightClient flightClient) {
        this.flightClient = flightClient;
    }

    @GetMapping
    public String getFilter(Map<String, Object> model) {
        return "filterflights";
    }

    @GetMapping("/filter")
    public String getLocDates(@RequestParam String to, @RequestParam String from, @RequestParam String date, Map<String,Object> model){
        List<FlightUI> flightUIList = flightClient.getDates(to,from,date);
        model.put("flights", flightUIList);
        return "flight";
    }

    @GetMapping("/book")
    public String bookFlight(@RequestParam String airlinesName, @RequestParam String flightNumber, @RequestParam String source,
                             @RequestParam String destination, @RequestParam String departureTime, @RequestParam String arrivalTime,Map<String, Object> model) throws ParseException {

        ResponseEntity<FlightUI> responseEntity = flightClient.bookFlight(airlinesName, flightNumber, source, destination, departureTime,arrivalTime);
        if (responseEntity.getStatusCode().is4xxClientError()){
            return "fFailure";
        }
        else {
            model.put("flight", responseEntity.getBody());
            return "fSuccess";
        }

    }
}
