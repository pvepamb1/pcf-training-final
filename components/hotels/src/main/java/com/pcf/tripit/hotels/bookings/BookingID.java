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
    private Hotel hotel;
    @Column(length = 5)
    private long roomId;

    public BookingID() {
    }

    public BookingID(Hotel hotel, long roomId) {
        this.hotel = hotel;
        this.roomId = roomId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }
}
