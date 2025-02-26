package com.MovieApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Theatre {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer theatreID;
	private String theatreName;
	private String locationName;
	private String district;
	private Integer noOfShows;
	private Integer seatingCapacity;
	private Integer reservationCapacityRegular;
	public Theatre() {
		super();
	}
	public Integer getTheatreID() {
		return theatreID;
	}
	public void setTheatreID(Integer theatreID) {
		this.theatreID = theatreID;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Integer getNoOfShows() {
		return noOfShows;
	}
	public void setNoOfShows(Integer noOfShows) {
		this.noOfShows = noOfShows;
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
		return "Theatre [theatreID=" + theatreID + ", theatreName=" + theatreName + ", locationName=" + locationName
				+ ", district=" + district + ", noOfShows=" + noOfShows + ", seatingCapacity=" + seatingCapacity
				+ ", reservationCapacityRegular=" + reservationCapacityRegular + "]";
	}
	
}
