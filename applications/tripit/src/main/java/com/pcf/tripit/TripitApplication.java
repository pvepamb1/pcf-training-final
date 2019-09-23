package com.pcf.tripit;

import com.pcf.tripit.hotelui.HotelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TripitApplication {

	@Value("${hotels.ms.url}")
	private String url;

	public static void main(String[] args) {
		SpringApplication.run(TripitApplication.class, args);
	}
	//@Bean
	/*public MovieClient movieClient(RestOperations restOperations) {
		return new MovieClient("//movies-ms/movies", restOperations);
	}*/

	@Bean
	public HotelClient hotelClient(RestOperations restOperations) {
		return new HotelClient(url, restOperations);
	}

	@Bean
	public RestOperations restOperations() {
		return new RestTemplate();
	}
}
