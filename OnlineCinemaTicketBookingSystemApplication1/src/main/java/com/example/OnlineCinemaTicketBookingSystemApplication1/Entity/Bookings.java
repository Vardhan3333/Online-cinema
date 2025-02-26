package com.example.OnlineCinemaTicketBookingSystemApplication1.Entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Bookings implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String date;
	private Integer seats;
	private String paymentStatus;
	private String BookingStatus;
	private List<String> selectedSeats;
	private LocalTime timeSlot;
	private String movieName;
	private String language;
	private Duration duration;
	private String theatreName;
	private String metroLocation;
	private String district;
	public LocalTime getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(LocalTime timeSlot) {
		this.timeSlot = timeSlot;
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
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getMetroLocation() {
		return metroLocation;
	}
	public void setMetroLocation(String metroLocation) {
		this.metroLocation = metroLocation;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public List<String> getSelectedSeats() {
		return selectedSeats;
	}
	public void setSelectedSeats(List<String> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getBookingStatus() {
		return BookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		BookingStatus = bookingStatus;
	}
	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name="user")
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Bookings [id=" + id + ", date=" + date + ", seats=" + seats + ", paymentStatus=" + paymentStatus
				+ ", BookingStatus=" + BookingStatus + ", selectedSeats=" + selectedSeats + ", timeSlot=" + timeSlot
				+ ", movieName=" + movieName + ", language=" + language + ", duration=" + duration + ", theatreName="
				+ theatreName + ", metroLocation=" + metroLocation + ", district=" + district + ", user=" + user
				+ "]";
	}
	
	
	
	
	
	

}
