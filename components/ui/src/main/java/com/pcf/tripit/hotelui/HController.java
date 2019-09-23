package com.pcf.tripit.hotelui;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;


@Controller
public class HController {
    private HotelClient hotelClient;

    public HController(HotelClient hotelClient) {
        this.hotelClient = hotelClient;
    }

    @GetMapping("/hotels")
    public String allHotels(Map<String, Object> model) {
        model.put("hotels", hotelClient.getAll() );
        return "hotel";
    }
}
