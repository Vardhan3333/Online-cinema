package com.MovieApp.Repo;

import org.springframework.data.repository.CrudRepository;

import com.MovieApp.Entity.ShowDetails;

public interface ShowRepo extends CrudRepository<ShowDetails, Integer>{

}
