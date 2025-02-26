package com.example.OnlineCinemaTicketBookingSystemApplication1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.example.OnlineCinemaTicketBookingSystemApplication1")

public class OnlineCinemaTicketBookingSystemApplication1Application {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCinemaTicketBookingSystemApplication1Application.class, args);
	}

}
