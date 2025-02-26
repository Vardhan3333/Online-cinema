package com.MovieApp.Service;

import com.MovieApp.Entity.Login;

public interface LoginService {

	public Login addingUser(Login u);
	public String validateLogin(Integer loginID, String password);
	public Login findByEmail(String emailId);
	public void getRegister(Login u);
	
}
