package com.MovieApp.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MovieApp.Entity.Theatre;

@Repository
public interface TheatreRepo extends CrudRepository<Theatre, Integer>{

}
