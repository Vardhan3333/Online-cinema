package com.example.Online.Cinema.Ticket.Booking.System.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity 
public class TheatreDetails1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long theatreID;
	private String theatreName;
	private String metroLocation;
	private String district;
	private Integer numberOfShows;
	private Integer seatingCapacity;
	private Integer reservationCapacityRegular;
	public Long getTheatreID() {
		return theatreID;
	}
	public void setTheatreID(Long theatreID) {
		this.theatreID = theatreID;
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
	public Integer getNumberOfShows() {
		return numberOfShows;
	}
	public void setNumberOfShows(Integer numberOfShows) {
		this.numberOfShows = numberOfShows;
	}
	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public Integer getReservationCapacityRegular() {
		return reservationCapacityRegular;
	}
	public void setReservationCapacityRegular(Integer reservationCapacityRegular) {
		this.reservationCapacityRegular = reservationCapacityRegular;
	}
	@Override
	public String toString() {
		return "TheatreDetails1 [theatreID=" + theatreID + ", theatreName=" + theatreName + ", metroLocation="
				+ metroLocation + ", district=" + district + ", numberOfShows=" + numberOfShows + ", seatingCapacity="
				+ seatingCapacity + ", reservationCapacityRegular=" + reservationCapacityRegular + "]";
	}
	
//	@OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
//    private List<ShowDetails> shows;
	
//	public List<ShowDetails> getShows() {
//		return shows;
//	}
//	public void setShows(List<ShowDetails> shows) {
//		this.shows = shows;
//	}
	
	
	

}
