package com.example.Online.Cinema.Ticket.Booking.System.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/cinema")
public class Controller {
	
	@GetMapping("/Hi")
	public ResponseEntity<String> Hi() {
		return new ResponseEntity<>("I love her",HttpStatus.OK);
	}
}
