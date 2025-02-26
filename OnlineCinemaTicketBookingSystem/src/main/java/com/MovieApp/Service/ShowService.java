package com.MovieApp.Service;

import java.util.List;



import com.MovieApp.Entity.ShowDetails;


public interface ShowService {

	
	public List<ShowDetails> getShowDetails();

	public void saveShow(ShowDetails s);

	public void deleteShow(ShowDetails sd);

	public ShowDetails findshow(int showID);
}
