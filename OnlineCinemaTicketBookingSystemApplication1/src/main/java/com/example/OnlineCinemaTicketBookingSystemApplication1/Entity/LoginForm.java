package com.example.OnlineCinemaTicketBookingSystemApplication1.Entity;

public class LoginForm {
	
	private Long RegistrationId;
	private String Password;
	public Long getRegistrationId() {
		return RegistrationId;
	}
	public void setRegistrationId(Long registrationId) {
		RegistrationId = registrationId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "LoginForm [RegistrationId=" + RegistrationId + ", Password=" + Password + "]";
	}
	
	

}
