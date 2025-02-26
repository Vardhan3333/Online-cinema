package com.MovieApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieApp.Entity.Movie;
import com.MovieApp.Repo.MovieRepo;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepo movieRepo;

	@Override
	public List<Movie> getMovieDetails() {
		// TODO Auto-generated method stub
		return (List<Movie>) movieRepo.findAll();
	}

	@Override
	public void saveMovie(Movie m) {
		// TODO Auto-generated method stub
		movieRepo.save(m);
	}

	@Override
	public Movie findMovie(Integer movieId) {
		// TODO Auto-generated method stub
		return movieRepo.findById(movieId).orElse(null);
	}

	@Override
	public void deleteMovie(Movie m) {
		// TODO Auto-generated method stub
		movieRepo.delete(m);
	}

}
