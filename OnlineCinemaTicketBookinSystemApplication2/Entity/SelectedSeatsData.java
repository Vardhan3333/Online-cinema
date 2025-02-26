package com.example.Online.Cinema.Ticket.Booking.System.Entity;

import java.util.List;

public class SelectedSeatsData {
	
	List<String> selectedseatsdata;

	@Override
	public String toString() {
		return "SelectedSeatsData [selectedseatsdata=" + selectedseatsdata + "]";
	}

	public List<String> getSelectedseatsdata() {
		return selectedseatsdata;
	}

	public void setSelectedseatsdata(List<String> selectedseatsdata) {
		this.selectedseatsdata = selectedseatsdata;
	}

}
