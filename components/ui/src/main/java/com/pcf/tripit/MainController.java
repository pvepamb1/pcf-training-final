package com.pcf.tripit;

import com.pcf.tripit.hotelui.HotelClient;
import com.pcf.tripit.hotelui.HotelInitialList;
import com.pcf.tripit.hotelui.HotelUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private HotelInitialList hotelInitialList;
    private HotelClient hotelClient;

    @Autowired
    public MainController(HotelInitialList hotelInitialList, HotelClient hotelClient) {
        this.hotelInitialList = hotelInitialList;
        this.hotelClient = hotelClient;
    }

    @GetMapping("/")
    public String message(Map<String, Object> model){
        hotelInitialList.asList().forEach(hotelClient::create);
        return "index";
    }
 }
