package com.pcf.tripit.hotels;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
        hotelRepository.save(hotel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
