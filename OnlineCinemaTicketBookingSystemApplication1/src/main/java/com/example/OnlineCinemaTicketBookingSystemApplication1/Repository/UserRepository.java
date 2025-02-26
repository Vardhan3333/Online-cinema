package com.example.OnlineCinemaTicketBookingSystemApplication1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.OnlineCinemaTicketBookingSystemApplication1.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.RegistrationId = :registrationId")
    User findByRegistrationId(Long registrationId);


}
