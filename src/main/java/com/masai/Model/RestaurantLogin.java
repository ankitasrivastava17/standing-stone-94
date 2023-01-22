package com.masai.Model;

public class RestaurantLogin {
	private String contactNumber;
	private String password;
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RestaurantLogin(String contactNumber, String password) {
		super();
		this.contactNumber = contactNumber;
		this.password = password;
	}
	public RestaurantLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RestaurantLogin [contactNumber=" + contactNumber + ", password=" + password + "]";
	}
//	public String RestaurantLogin() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public String RestaurantLogout(String uniqueId) {
		// TODO Auto-generated method stub
		return null;
	}
	public String RestaurantLogin() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
