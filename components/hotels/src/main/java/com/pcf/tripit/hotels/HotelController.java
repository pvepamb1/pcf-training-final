package com.pcf.tripit.hotels;

import com.pcf.tripit.hotels.bookings.Booking;
import com.pcf.tripit.hotels.bookings.BookingID;
import com.pcf.tripit.hotels.bookings.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelRepository hotelRepository;
    private BookingRepository bookingRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/book")
    public Iterable<Hotel> getAvailable(@RequestParam String begin, @RequestParam String end) throws ParseException {

        Date startDate = new SimpleDateFormat("YYYY/MM/DD").parse(begin);
        Date endDate = new SimpleDateFormat("YYYY/MM/DD").parse(end);

        List<Hotel> available = new ArrayList<>();
        for(Hotel hotel: hotelRepository.findAll()){
            boolean isAvailable = true;
            Set<String> roomIdSet = new HashSet<>();
            for(Booking booking: bookingRepository.findAll()){
                if(hotel.getId()==booking.getId().getHotelId().getId() &&
                        !checkDateRange(startDate, endDate, booking.getBegin(), booking.getEnd())){
                    roomIdSet.add(booking.getId().getRoomId());
                }
            }
            if(roomIdSet.size()>=hotel.getCapacity()) isAvailable = false;
            if(isAvailable) available.add(hotel);
        }

        return available;
    }


    @GetMapping
    public Iterable<Hotel> getAvailable() {
        return hotelRepository.findAll();
    }

    private static boolean checkDateRange(Date start1, Date end1, Date start2, Date end2){
        return((start1.before(start2) && end1.before(start2)) || (start1.after(end2) && end1.after(end2)));
    }

    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
        hotelRepository.save(hotel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
