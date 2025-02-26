package com.example.Online.Cinema.Ticket.Booking.System.Entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShowDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long showID;
	
	private Long proxyTheatre;
	private Long proxyMovie;
	
	
	
	@ManyToOne
	@JoinColumn(name="Theatre")
	private TheatreDetails1 theatre;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Movie")
    private MovieDetails movie;
	
	private LocalTime timeSlot;
	private Double pricePerSeat;
	private Integer regularSeats_Available;
	public Long getShowID() {
		return showID;
	}
	public void setShowID(Long showID) {
		this.showID = showID;
	}
	public Long getProxyTheatre() {
		return proxyTheatre;
	}
	public void setProxyTheatre(Long proxyTheatre) {
		this.proxyTheatre = proxyTheatre;
	}
	public Long getProxyMovie() {
		return proxyMovie;
	}
	public void setProxyMovie(Long proxyMovie) {
		this.proxyMovie = proxyMovie;
	}
	public TheatreDetails1 getTheatre() {
		return theatre;
	}
	public void setTheatre(TheatreDetails1 theatre) {
		this.theatre = theatre;
	}
	public MovieDetails getMovie() {
		return movie;
	}
	public void setMovie(MovieDetails movie) {
		this.movie = movie;
	}
	public LocalTime getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(LocalTime timeSlot) {
		this.timeSlot = timeSlot;
	}
	public Double getPricePerSeat() {
		return pricePerSeat;
	}
	public void setPricePerSeat(Double pricePerSeat) {
		this.pricePerSeat = pricePerSeat;
	}
	public Integer getRegularSeats_Available() {
		return regularSeats_Available;
	}
	public void setRegularSeats_Available(Integer regularSeats_Available) {
		this.regularSeats_Available = regularSeats_Available;
	}
	@Override
	public String toString() {
		return "ShowDetails [showID=" + showID + ", proxyTheatre=" + proxyTheatre + ", proxyMovie=" + proxyMovie
				+ ", theatre=" + theatre + ", movie=" + movie + ", timeSlot=" + timeSlot + ", pricePerSeat="
				+ pricePerSeat + ", regularSeats_Available=" + regularSeats_Available + "]";
	}
	
}
