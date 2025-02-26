package com.example.Online.Cinema.Ticket.Booking.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Online.Cinema.Ticket.Booking.System.Entity.MovieDetails;

public interface MovieRepository extends JpaRepository<MovieDetails, Long> {
//	public List<MovieDetails> findBy(String location){
//		return 
//	}
	
//	List<MovieDetails> findByMovieName(String moviename);
}
