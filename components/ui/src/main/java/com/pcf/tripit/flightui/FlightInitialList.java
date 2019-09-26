package com.pcf.tripit.flightui;

import com.pcf.tripit.hotelui.HotelUI;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class FlightInitialList {
    public List<FlightUI> asList() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

        return Arrays.asList(new FlightUI("Air Canada", "14528", sdf.parse("Sun Sep 01 11:50:55 EDT 2019"),sdf.parse("Sun Sep 01 13:40:55 EDT 2019"),"NYC","Detroit",200),
                new FlightUI("Alaska Airlines ","6789",sdf.parse("Mon Sep 02 08:10:25 EDT 2019"),sdf.parse("Mon Sep 02 12:50:55 EDT 2019"),"Chicago","California",400),
                new FlightUI("Jet Blu","9876",sdf.parse("Tue Sep 03 17:40:55 EDT 2019"),sdf.parse("Tue Sep 03 19:00:55 EDT 2019"),"Texas","Colorado",368),
                new FlightUI("Delta","3486",sdf.parse("Wed Sep 04 11:50:55 EDT 2019"),sdf.parse("Wed Sep 04 11:50:55 EDT 2019"),"Washington D.C.","San Francisco",450),
                new FlightUI("Lufthansa","8763",sdf.parse("Thu Sep 05 20:00:55 EDT 2019"),sdf.parse("Thu Sep 05 23:15:55 EDT 2019") ,"Seatlle","Boston",700),
                new FlightUI("United","5374",sdf.parse("Fri Sep 01 06:50:55 EDT 2019"),sdf.parse("Fri Sep 01 08:50:55 EDT 2019"),"Dallas","Phoenix",520),
                new FlightUI("Frontier","7239",sdf.parse("Sat Sep 07 14:10:55 EDT 2019"),sdf.parse("Sat Sep 07 17:20:55 EDT 2019"),"Columbus","Charlotte",250)

        );
    }

}
