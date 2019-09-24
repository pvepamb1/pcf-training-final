package com.pcf.tripit.hotelui;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class HotelInitialList {

    public List<HotelUI> asList() {
        return Arrays.asList(new HotelUI("Hilton", "Madission Avenue", "New York",10,200,""),
                new HotelUI("Hayatt", "Hopkins Avenue", "Texas",10,150,""),
                new HotelUI("Westin", "Xyz Drive", "California",10,100,""),
                new HotelUI("Fairmont", "Lincon Street", "Virginia",10,190,""),
                new HotelUI("J W Marriot", "Harbour Avenue", "Florida",10,300,""),
                new HotelUI("Renaissance", "Rock Creek Drive", "Colorado",10,620,""),
                new HotelUI("Loews", "Washburn Street", "Ohio",10,340,"")

        );
    }
}
