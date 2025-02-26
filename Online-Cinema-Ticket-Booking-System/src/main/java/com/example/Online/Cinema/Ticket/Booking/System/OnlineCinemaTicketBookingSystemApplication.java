package com.example.Online.Cinema.Ticket.Booking.System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OnlineCinemaTicketBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCinemaTicketBookingSystemApplication.class, args);
	}

}
