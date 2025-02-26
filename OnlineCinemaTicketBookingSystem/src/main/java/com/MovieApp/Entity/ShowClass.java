package com.MovieApp.Entity;



public class ShowClass {
	private  Integer showID;
	
	private String timeSlot;
	private Integer pricePerSeat;
	private Integer regularSeats_available;
	
	
	private int theatreID;
	
	
	private int movieID;
	
	

	
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

	public int getTheatreID() {
		return theatreID;
	}

	public void setTheatreID(int theatreID) {
		this.theatreID = theatreID;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	@Override
	public String toString() {
		return "ShowDetails [showID=" + showID + ", timeSlot=" + timeSlot + ", pricePerSeat=" + pricePerSeat
				+ ", regularSeats_available=" + regularSeats_available + ", theatre=" + theatreID + ", movie=" + movieID
				+ "]";
	
}
}
