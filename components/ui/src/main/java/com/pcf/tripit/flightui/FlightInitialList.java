package com.pcf.tripit.flightui;

import com.pcf.tripit.hotelui.HotelUI;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class FlightInitialList {
    public List<FlightUI> asList() {
        return Arrays.asList(new FlightUI("Air Canada", "14528", "8:00","10:00","NYC","Detroit",200),
                new FlightUI("Alaska Airlines ","6789","12.45","17.30","Chicago","California",400),
                new FlightUI("Jet Blu","9876","23.00","00.23","Texas","Colorado",368),
                new FlightUI("Delta","3486", "17.10","19.35","Washington D.C.","San Francisco",450),
                new FlightUI("Lufthansa","8763","5:00","6.00" ,"Seatlle","Boston",700),
                new FlightUI("United","5374","12.45","15.00","Dallas","Phoenix",520),
                new FlightUI("Frontier","7239","17.05","19.00","Columbus","Charlotte",250)

        );
    }

}
