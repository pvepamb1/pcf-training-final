package com.pcf.tripit.hotelui;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/hotels")
public class HController {
    private HotelClient hotelClient;

    public HController(HotelClient hotelClient) {
        this.hotelClient = hotelClient;
    }
    @GetMapping
    public String allHotels(Map<String, Object> model) {
        model.put("hotels", hotelClient.getAll() );
        return "hotel";
    }

    @GetMapping("/filter")
    public String getDates(@RequestParam String begin, @RequestParam String end, Map<String,Object> model){
        List<HotelUI> hotelUIList = hotelClient.getDates(begin,end);
        for(HotelUI hotelUI: hotelUIList)
            hotelUI.setDate("begin="+begin+"&end="+end);
        model.put("hotels", hotelUIList);
        return "hotel";
    }

    @GetMapping("/book")
    public String bookHotel(Map<String,Object> model){
        model.put("hotels", hotelClient.bookHotel());
        return "hbook";
    }
}
