package com.karuite.entity;

/**
 * TdUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class TdUser implements java.io.Serializable {

	private static final long serialVersionUID = -7727973772823431603L;
	
	private Integer id;
	private String openid;
	private String username;
	private String password;
	private String telnumber;
	private String shopnumber;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelnumber() {
		return this.telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	public String getShopnumber() {
		return this.shopnumber;
	}

	public void setShopnumber(String shopnumber) {
		this.shopnumber = shopnumber;
	}
	
	// Constructors

	/** default constructor */
	public TdUser() {
	}

	/** full constructor */
	public TdUser(String openid, String username, String password,
			String telnumber, String shopnumber) {
		
		this.openid = openid;
		this.username = username;
		this.password = password;
		this.telnumber = telnumber;
		this.shopnumber = shopnumber;
	}

}
