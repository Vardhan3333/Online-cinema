package com.example.OnlineCinemaTicketBookingSystemApplication1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Seats {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String Seat;
	
	@Override
	public String toString() {
		return "Seats [Id=" + Id + ", Seat=" + Seat + ", user=" + user + "]";
	}
	public String getSeat() {
		return Seat;
	}
	public void setSeat(String seat) {
		Seat = seat;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name="user")
	private User user;
}
