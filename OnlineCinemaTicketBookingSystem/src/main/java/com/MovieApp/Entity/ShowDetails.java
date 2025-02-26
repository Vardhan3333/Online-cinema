package com.MovieApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ShowDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  Integer showID;
	
	private String timeSlot;
	private Integer pricePerSeat;
	private Integer regularSeats_available;
	
	@ManyToOne
	@JoinColumn(name="theatreID")
	private Theatre theatre;
	
	@OneToOne
	@JoinColumn(name="movieId")
	private Movie movie;
	
	

	public ShowDetails() {
		super();
	}

	public ShowDetails(Integer showID, String timeSlot, Integer pricePerSeat, Integer regularSeats_available,
			Theatre theatre, Movie movie) {
		super();
		this.showID = showID;
		this.timeSlot = timeSlot;
		this.pricePerSeat = pricePerSeat;
		this.regularSeats_available = regularSeats_available;
		this.theatre = theatre;
		this.movie = movie;
	}

	public Integer getShowID() {
		return showID;
	}

	public void setShowID(Integer showID) {
		this.showID = showID;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public Integer getPricePerSeat() {
		return pricePerSeat;
	}

	public void setPricePerSeat(Integer pricePerSeat) {
		this.pricePerSeat = pricePerSeat;
	}

	public Integer getRegularSeats_available() {
		return regularSeats_available;
	}

	public void setRegularSeats_available(Integer regularSeats_available) {
		this.regularSeats_available = regularSeats_available;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "ShowDetails [showID=" + showID + ", timeSlot=" + timeSlot + ", pricePerSeat=" + pricePerSeat
				+ ", regularSeats_available=" + regularSeats_available + ", theatre=" + theatre + ", movie=" + movie
				+ "]";
	}
	
	
	
	

}
