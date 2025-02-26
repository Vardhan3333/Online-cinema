package com.MovieApp.Service;

import java.util.List;

import com.MovieApp.Entity.Theatre;

public interface TheatreService {

	
	public List<Theatre> getTheatreDetails();
	public void saveTheatre(Theatre t);
	public Theatre findTheatre(Integer theatreId);
	public void deleteTheatre(Theatre t);
}
