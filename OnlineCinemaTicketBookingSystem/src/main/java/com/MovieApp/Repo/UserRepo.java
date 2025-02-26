package com.MovieApp.Repo;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.MovieApp.Entity.Login;


public interface UserRepo extends CrudRepository<Login, Integer>{

Optional<Login> findByEmailId(String loginID);
	Login getByEmailId(String emailId);
	
	
}
