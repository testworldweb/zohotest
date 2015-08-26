package com.testworldweb.zohotest;

public class UserDetails {
	private String userEmailId;
	private String userPassword;
	UserDetails(String userEmailId,String userPassword)
	{
		this.userEmailId=userEmailId;	
		this.userPassword=userPassword;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	

}
