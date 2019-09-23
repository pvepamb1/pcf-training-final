package com.pcf.tripit.hotels.bookings;

import com.pcf.tripit.hotels.Hotel;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class BookingID implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn
    private Hotel hotelId;
    @Column(length = 5)
    private String roomId;

    public BookingID() {
    }

    public BookingID(Hotel hotelId, String roomId) {
        this.hotelId = hotelId;
        this.roomId = roomId;
    }

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
