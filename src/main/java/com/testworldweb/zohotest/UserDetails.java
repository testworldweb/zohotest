package com.testworldweb.zohotest;
/**
 * Pojo for userDetails , contains userEmailId, userPassword
 * @author testworldweb
 *
 */
public class UserDetails {
	private String userEmailId;
	private String userPassword;
	UserDetails(String userEmailId,String userPassword)
	{
		this.userEmailId=userEmailId;	
		this.userPassword=userPassword;
	}
	/**
	 * @return the userEmailId
	 */
	public String getUserEmailId() {
		return userEmailId;
	}
	/**
	 * @param userEmailId the userEmailId to set
	 */
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	

}
