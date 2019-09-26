package com.pcf.tripit;

import com.pcf.tripit.flightui.FlightClient;
import com.pcf.tripit.flightui.FlightInitialList;
import com.pcf.tripit.hotelui.HotelClient;
import com.pcf.tripit.hotelui.HotelInitialList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    private HotelInitialList hotelInitialList;
    private HotelClient hotelClient;
    private FlightClient flightClient;
    private FlightInitialList flightInitialList;

    @Autowired
    public MainController(HotelInitialList hotelInitialList, HotelClient hotelClient, FlightClient flightClient, FlightInitialList flightInitialList) {
        this.hotelInitialList = hotelInitialList;
        this.hotelClient = hotelClient;
        this.flightClient = flightClient;
        this.flightInitialList = flightInitialList;
    }

    @GetMapping("/")
    public String message(Map<String, Object> model){
        hotelInitialList.asList().forEach(hotelClient::create);
        flightInitialList.asList().forEach(flightClient::create);
        return "index";
    }
 }
