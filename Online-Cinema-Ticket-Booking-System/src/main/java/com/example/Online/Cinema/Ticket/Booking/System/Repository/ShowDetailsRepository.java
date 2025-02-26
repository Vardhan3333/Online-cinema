package com.example.Online.Cinema.Ticket.Booking.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Online.Cinema.Ticket.Booking.System.Entity.ShowDetails;

public interface ShowDetailsRepository extends JpaRepository<ShowDetails, Long> {
	
//	public List<ShowDetails> findByTheatreTheatreId(Long theatreID);
	
	public List<ShowDetails> findByProxyTheatre(Long theatreId);
	
	

}
