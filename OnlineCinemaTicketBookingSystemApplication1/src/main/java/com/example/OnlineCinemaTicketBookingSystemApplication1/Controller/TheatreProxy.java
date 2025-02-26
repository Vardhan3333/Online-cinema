package com.example.OnlineCinemaTicketBookingSystemApplication1.Controller;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Online.Cinema.Ticket.Booking.System.Entity.ShowDetails;
import com.example.Online.Cinema.Ticket.Booking.System.Entity.TheatreDetails1;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

@FeignClient(value = "threatre-service")

public interface TheatreProxy {

    @GetMapping("/theatrelist")
    public ResponseEntity<List<TheatreDetails1>> Get();
    
    @GetMapping("/cinema/Hi")
	public ResponseEntity<String> Hi() ;
    
    @PostMapping("admin/movies")
	public ResponseEntity<?> GetMovies(@RequestParam String location,HttpSession session);
    
    @PostMapping("admin/bookingdetails")
	public ResponseEntity<List> BookingDetails(@RequestParam String selectedDate,@RequestParam Integer selectedSeats,@RequestParam Long showId);
    
    @PostMapping("admin/seatdetails")
	public ResponseEntity<List<String>> seatDetails(@RequestBody List<String> selectedSeats);
    
    @GetMapping("admin/data")
	public List<String> Seats();
    
    @GetMapping("admin/data2")
	public List<String> Details();
    
    @PostMapping("admin/showId")
	public ResponseEntity<ShowDetails> GetShowId( Long Id);
    
    @GetMapping("admin/timeslot/{showId}")
	public LocalTime GetTime(@PathVariable Long showId);
    
    @GetMapping("admin/theatredetails/{theatreId}")
	public List<String> GetTheatre(@PathVariable Long theatreId);
    
    @GetMapping("admin/moviedetails/{movieId}")
	public List<String> GetMovie(@PathVariable Long movieId);
    
    @GetMapping("admin/duration/{movieId}")
	public Duration GetDuration( @PathVariable Long movieId);
}
