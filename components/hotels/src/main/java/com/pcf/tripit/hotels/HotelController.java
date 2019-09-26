package com.pcf.tripit.hotels;

import com.pcf.tripit.hotels.bookings.Booking;
import com.pcf.tripit.hotels.bookings.BookingID;
import com.pcf.tripit.hotels.bookings.BookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    Logger LOGGER = LoggerFactory.getLogger(HotelController.class);

    private HotelRepository hotelRepository;
    private BookingRepository bookingRepository;

    public HotelController(HotelRepository hotelRepository, BookingRepository bookingRepository) {
        this.hotelRepository = hotelRepository;
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/filter")
    public Iterable<Hotel> getAvailable(@RequestParam String begin, @RequestParam String end) throws ParseException {

        LOGGER.info("In filter");
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(begin);
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);

        List<Hotel> available = new ArrayList<>();
        for(Hotel hotel: hotelRepository.findAll()){
            boolean isAvailable = true;
            Set<Long> roomIdSet = new HashSet<>();
            for(Booking booking: bookingRepository.findAll()){
                if(hotel.getId()==booking.getId().getHotel().getId() &&
                        !checkDateRange(startDate, endDate, booking.getBegin(), booking.getEnd())){
                    roomIdSet.add(booking.getId().getRoomId());
                }
            }
            if(roomIdSet.size()>=hotel.getCapacity()) isAvailable = false;
            if(isAvailable) available.add(hotel);
        }
        LOGGER.info("Out of filter");
        return available;
    }


    @GetMapping
    public Iterable<Hotel> getAvailable() {
        return hotelRepository.findAll();
    }

    private static boolean checkDateRange(Date start1, Date end1, Date start2, Date end2){
        return((start1.before(start2) && end1.before(start2)) || (start1.after(end2) && end1.after(end2)));
    }

    @GetMapping("/book")
    public ResponseEntity<Booking> bookHotel(@RequestParam String name, @RequestParam String address,
                                           @RequestParam String city,@RequestParam String begin,
                                           @RequestParam String end) throws ParseException {

        LOGGER.info("In book");
        Date beginDate = new SimpleDateFormat("yyyy-MM-dd").parse(begin);
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
        long roomId = 0L;
        Hotel hotel = hotelRepository.findByNameAndAddressAndCity(name, address, city).get(0);
        LOGGER.info("{} {} {} {}", hotel.getName(), hotel.getAddress(), hotel.getCity(), hotel.getId());
        List<Long> roomIdList = new ArrayList<>();
        for(Booking booking: bookingRepository.findAll()){
            if(booking.getId().getHotel().equals(hotel)
                    && !checkDateRange(beginDate, endDate, booking.getBegin(), booking.getEnd())){
                roomIdList.add(booking.getId().getRoomId());
            }
        }
        Collections.sort(roomIdList);
        if(roomIdList.isEmpty())
            roomId = generateRoomId(true, roomIdList);
        else if(roomIdList.size()<hotel.getCapacity())
            roomId = generateRoomId(false, roomIdList);

        if(roomId!=0L){
            bookingRepository.save(new Booking(new BookingID(hotel, roomId), beginDate, endDate));
            LOGGER.info("Booked");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            LOGGER.info("Not booked");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private long generateRoomId(boolean flag, List<Long> roomIdList){
        if(flag)
            return 1;
        else
            return roomIdList.get(roomIdList.size()-1)+1;
    }

    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
        hotel.setId(hotel.hashCode());
        hotelRepository.save(hotel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
