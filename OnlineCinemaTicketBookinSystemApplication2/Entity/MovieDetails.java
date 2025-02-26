package com.example.Online.Cinema.Ticket.Booking.System.Entity;

import java.time.Duration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MovieDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long movieID;
	private String movieName;
	private String language;
	private Duration duration;
	public Long getMovieID() {
		return movieID;
	}
	public void setMovieID(Long movieID) {
		this.movieID = movieID;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "MovieDetails [movieID=" + movieID + ", movieName=" + movieName + ", language=" + language
				+ ", duration=" + duration + "]";
	}
	
}
