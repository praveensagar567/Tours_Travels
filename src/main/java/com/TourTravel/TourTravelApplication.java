package com.TourTravel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.TourTravel")
public class TourTravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourTravelApplication.class, args);
	}

}
