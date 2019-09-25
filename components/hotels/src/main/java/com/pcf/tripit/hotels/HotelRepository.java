package com.pcf.tripit.hotels;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {
    Long findIDByNameAndAddressAndCity(String name, String address, String city);

    List<Hotel> findByNameAndAddressAndCity(String name, String address, String city);
}
