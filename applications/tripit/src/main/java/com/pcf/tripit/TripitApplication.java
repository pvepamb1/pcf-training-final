package com.pcf.tripit;

import com.pcf.tripit.flightui.FlightClient;
import com.pcf.tripit.hotelui.HotelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class TripitApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripitApplication.class, args);
	}

	@Bean
	public FlightClient flightClient(RestOperations restOperations){
		return new FlightClient("//flights-ms/flights", restOperations);
	}

	@Bean
	public HotelClient hotelClient(RestOperations restOperations) {
		return new HotelClient("//hotels-ms/hotels", restOperations);
	}

}
