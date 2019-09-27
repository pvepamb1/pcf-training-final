package com.pcf.tripit.hotelui;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class HotelClient {
    private static ParameterizedTypeReference<List<HotelUI>> hotelListType = new ParameterizedTypeReference<List<HotelUI>>() {
    };
    private static ParameterizedTypeReference<HotelUI> hotelType = new ParameterizedTypeReference<HotelUI>() {
    };
    private String hotelURL;
    private RestOperations restOperations;
    private static final int CACHE_SIZE = 5;
    private final List<HotelUI> lastRead = new ArrayList<>(CACHE_SIZE);
    private static final Logger log = LoggerFactory.getLogger(HotelClient.class);

    public HotelClient(String hotelURL, RestOperations restOperations) {
        this.hotelURL = hotelURL;
        this.restOperations = restOperations;
    }

    public void create(HotelUI hotel) {
        log.debug("Url is {}",hotelURL);
        System.out.println(hotelURL);
        restOperations.postForEntity(hotelURL, hotel, HotelUI.class);
    }

    @HystrixCommand(fallbackMethod="getAllFallback",commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
    })
    public List<HotelUI> getAll() {
        List<HotelUI> read = restOperations.exchange(hotelURL, HttpMethod.GET, null, hotelListType).getBody();
        log.debug("Read {} podcasts from {}", read.size(), hotelURL);

        lastRead.clear();
        int copyCount = Math.min(read.size(), CACHE_SIZE);
        for (int i =0; i < copyCount; i++)
            lastRead.add(read.get(i));
        log.debug("Copied {} hotels into the cache", copyCount);

        return read;
    }

    public List<HotelUI> getDates(String begin, String end){
        String finalUrl = hotelURL+"/filter?begin="+begin+"&end="+end;
        return restOperations.exchange(finalUrl, HttpMethod.GET, null, hotelListType).getBody();
    }

    public List<HotelUI> getAllFallback() {
        log.debug("Returning {} hotels from the fallback method", lastRead.size());

        return lastRead;
    }

    public ResponseEntity<HotelUI> bookHotel(String name, String address, String city, String begin, String end){
        String finalUrl = hotelURL+"/book?name="+name+"&address="+address+"&city="+city+"&begin="+begin+"&end="+end;
        try{
        return restOperations.exchange(finalUrl, HttpMethod.GET, null, hotelType);
        }catch(HttpStatusCodeException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
