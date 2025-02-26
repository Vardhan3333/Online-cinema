package com.MovieApp.Repo;

import org.springframework.data.repository.CrudRepository;

import com.MovieApp.Entity.Payment;

public interface PaymentRepo extends CrudRepository<Payment, Integer>{

}
