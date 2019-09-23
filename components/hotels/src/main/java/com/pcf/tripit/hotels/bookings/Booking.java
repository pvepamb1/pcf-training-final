package com.pcf.tripit.hotels.bookings;

import com.pcf.tripit.hotels.Hotel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Booking {

    private static final long serialVersionUID = 1L;

    @Id
    private BookingID id;

    private Date begin;
    private Date end;

    public Booking() {
    }

    public Booking(BookingID id, Date begin, Date end) {
        this.id = id;
        this.begin = begin;
        this.end = end;
    }

    public BookingID getId() {
        return id;
    }

    public void setId(BookingID id) {
        this.id = id;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
