package com.ui.pojo;

public class User {

	public User(String emailAddress, String password) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
	}

	private String emailAddress;
	private String password;
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
