package com.pcf.tripit.flightui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.List;

public class FlightClient {

    private static ParameterizedTypeReference<List<FlightUI>> flightListType = new ParameterizedTypeReference<List<FlightUI>>() {
    };
    private static ParameterizedTypeReference<FlightUI> flightType = new ParameterizedTypeReference<FlightUI>() {
    };
    private String flightURL;
    private RestOperations restOperations;
    private static final int CACHE_SIZE = 5;
    private final List<FlightUI> lastRead = new ArrayList<>(CACHE_SIZE);
    private static final Logger log = LoggerFactory.getLogger(FlightClient.class);

    public FlightClient(String flightURL, RestOperations restOperations) {
        this.flightURL = flightURL;
        this.restOperations = restOperations;
    }

    public void create(FlightUI hotel) {
        restOperations.postForEntity(flightURL, hotel, FlightUI.class);
    }

    // @HystrixCommand(fallbackMethod="getAllFallback",commandProperties = {
    // @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
    //})
    public List<FlightUI> getAll() {
        List<FlightUI> read = restOperations.exchange(flightURL, HttpMethod.GET, null, flightListType).getBody();
        log.debug("Read {} podcasts from {}", read.size(), flightURL);

        lastRead.clear();
        int copyCount = (read.size() < CACHE_SIZE) ? read.size() : CACHE_SIZE;
        for (int i =0; i < copyCount; i++)
            lastRead.add(read.get(i));
        log.debug("Copied {} hotels into the cache", copyCount);

        return read;
    }

    public List<FlightUI> getDates(String begin, String end){
        String finalUrl = flightURL +"/filter?begin="+begin+"&end="+end;
        return restOperations.exchange(finalUrl, HttpMethod.GET, null, flightListType).getBody();
    }

    public List<FlightUI> getAllFallback() {
        log.debug("Returning {} hotels from the fallback method", lastRead.size());

        return lastRead;
    }

    public FlightUI bookHotel(String name, String address, String city, String begin, String end){
        String finalUrl = flightURL +"/book?name="+name+"&address="+address+"&city="+city+"&begin="+begin+"&end="+end;
        FlightUI hotelUI = restOperations.exchange(finalUrl, HttpMethod.GET, null, flightType).getBody();
        return hotelUI;
    }
}
