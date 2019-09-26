package com.pcf.tripit.flightui;

import com.pcf.tripit.hotelui.HotelUI;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class FlightInitialList {
    public List<FlightUI> asList() {
        return Arrays.asList(new FlightUI("Air Canada", "14528", "2019-01-02T11:50:55","2019-01-03T01:50:55","NYC","Detroit",200),
                new FlightUI("Alaska Airlines ","6789","2019-01-02T12:50:55","2018-05-05T11:50:55","Chicago","California",400),
                new FlightUI("Jet Blu","9876","2019-01-02T11:50:55","2018-05-07T02:50:55","Texas","Colorado",368),
                new FlightUI("Delta","3486", "2019-04-08T09:50:55","2018-05-09T03:50:55","Washington D.C.","San Francisco",450),
                new FlightUI("Lufthansa","8763","2019-05-10T11:50:55","2018-05-11T11:50:55" ,"Seatlle","Boston",700),
                new FlightUI("United","5374","2019-06-12T11:50:55","2018-05-13T11:50:55","Dallas","Phoenix",520),
                new FlightUI("Frontier","7239","2019-07-14T11:50:55","2018-05-15T11:50:55","Columbus","Charlotte",250)

        );
    }

}
