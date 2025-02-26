package com.example.OnlineCinemaTicketBookingSystemApplication1.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;

@Entity
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	@Column(unique = true)
	private String UserName;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	private String FirstName;
	private String LastName;
	private Integer Age;
	private String Gender;
	@Column(unique = true)
	private String Password;
	private String Address;
	private Long PhoneNo;
	private String Role;
	@Column(unique = true)
	private Long RegistrationId;
	public Long getRegistrationId() {
		return RegistrationId;
	}
	public void setRegistrationId(Long registrationId) {
		RegistrationId = registrationId;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", UserName=" + UserName + ", FirstName=" + FirstName + ", LastName="
				+ LastName + ", Age=" + Age + ", Gender=" + Gender + ", Password=" + Password + ", Address=" + Address
				+ ", PhoneNo=" + PhoneNo + ", Role=" + Role + ", RegistrationId=" + RegistrationId + "]";
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Long getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		PhoneNo = phoneNo;
	}
}
