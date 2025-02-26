package com.MovieApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieApp.Entity.Theatre;
import com.MovieApp.Repo.TheatreRepo;

@Service
public class TheatreServiceImpl implements TheatreService{
	
	
	@Autowired
	private TheatreRepo theatreRepo;

	@Override
	public List<Theatre> getTheatreDetails() {
		return (List<Theatre>) theatreRepo.findAll();
	}
	@Override
	public void saveTheatre(Theatre t) {
		theatreRepo.save(t);
	}
	@Override
	public Theatre findTheatre(Integer theatreId) {
		return theatreRepo.findById(theatreId).orElse(null);
	}
	@Override
	public void deleteTheatre(Theatre t) {
		theatreRepo.delete(t);
		
	}

}
