package com.MovieApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieApp.Entity.Login;
import com.MovieApp.Repo.UserRepo;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	UserRepo userRepo;

	
	public Login addingUser(Login u) {
		return userRepo.save(u);
	}
	public String validateLogin(Integer loginID, String password) {   
		Login user=userRepo.findById(loginID).orElse(null);
		if(user==null) {
			return "Invalid";
		}else if(user.getPassword().equals(password)) {
			return "success";
		}
			
		return "Invalid";
				
	}
	public Login findByEmail(String emailId) {
		
		return userRepo.getByEmailId(emailId);
	}
	public void getRegister(Login u) {
		userRepo.save(u);
		
	}

}
