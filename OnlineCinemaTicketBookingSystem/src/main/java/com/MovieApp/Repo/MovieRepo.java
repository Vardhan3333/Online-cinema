package com.MovieApp.Repo;

import org.springframework.data.repository.CrudRepository;

import com.MovieApp.Entity.Movie;

public interface MovieRepo extends CrudRepository<Movie, Integer>{

}
