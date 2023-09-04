package com.bodh.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User
{

	@Id
	@Column(name="id")
	private int userId;
	@Column(name="name")
	private String userName;
	@Column(name="email")
	private String email;
	@Column(name="phno")
	private long mobileNo;
	@Column(name="password")
	private String password;
	
	public User() {}

	public User(int userId, String userName, String email, long mobileNo, String password) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
