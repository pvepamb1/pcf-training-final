package com.pcf.tripit.hotels.bookings;

import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<BookingID, Long> {
}
