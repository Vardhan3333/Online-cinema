package com.MovieApp.Service;

import java.util.List;

import com.MovieApp.Entity.Movie;


public interface MovieService {

	
	public List<Movie> getMovieDetails();
	public void saveMovie(Movie m);
	public Movie findMovie(Integer movieId);
	public void deleteMovie(Movie m);
}
