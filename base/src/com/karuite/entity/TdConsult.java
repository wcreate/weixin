package com.karuite.entity;

/**
 * @author MyEclipse Persistence Tools
 */
public class TdConsult implements java.io.Serializable {

	private static final long serialVersionUID = -7727973772823431603L;
	
	private int id;
	private String username;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public TdConsult()
	{
		
	}
	
	public TdConsult(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

}
