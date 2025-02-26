package com.example.Online.Cinema.Ticket.Booking.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.Online.Cinema.Ticket.Booking.System.Entity.TheatreDetails1;

public interface TheatreRepository extends JpaRepository<TheatreDetails1, Long> {
	
//	@Query(" FROM com.example.Online.Cinema.Ticket.Booking.System.Entity.TheatreDetails1  WHERE district =:district")
	public List<TheatreDetails1> findByDistrict(String district);
}
