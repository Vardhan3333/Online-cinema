package com.example.OnlineCinemaTicketBookingSystemApplication1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OnlineCinemaTicketBookingSystemApplication1.Entity.Bookings;

public interface BookingsRepository extends JpaRepository<Bookings, Long> {
	
	public List<Bookings> findByUserUserId(Long Id);

}
