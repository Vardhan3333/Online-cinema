package com.example.OnlineCinemaTicketBookingSystemApplication1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OnlineCinemaTicketBookingSystemApplication1.Entity.Seats;

public interface SeatRepository extends JpaRepository<Seats, Long> {

}
