package com.MovieApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookID;
	private String movieName;
	private String theatreName;
	private String theatreLocation;
	private Integer noOfTickets;
	private Integer costPerTicket;
	private Integer totalCost;
	private Integer loginID;
	private Integer showID;
	public Integer getBookID() {
		return bookID;
	}
	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}
	public Integer getNoOfTickets() {
		return noOfTickets;
	}
	public void setNoOfTickets(Integer noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	public Integer getCostPerTicket() {
		return costPerTicket;
	}
	public void setCostPerTicket(Integer costPerTicket) {
		this.costPerTicket = costPerTicket;
	}
	public Integer getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}
	public Integer getLoginID() {
		return loginID;
	}
	public void setLoginID(Integer loginID) {
		this.loginID = loginID;
	}
	
	public Integer getShowID() {
		return showID;
	}
	public void setShowID(Integer showID) {
		this.showID = showID;
	}
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreLocation() {
		return theatreLocation;
	}
	public void setTheatreLocation(String theatreLocation) {
		this.theatreLocation = theatreLocation;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", movieName=" + movieName + ", theatreName=" + theatreName
				+ ", theatreLocation=" + theatreLocation + ", noOfTickets=" + noOfTickets + ", costPerTicket="
				+ costPerTicket + ", totalCost=" + totalCost + ", loginID=" + loginID + ", showID=" + showID + "]";
	}
	
	
	
	

}
