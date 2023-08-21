package com.springboot.order_project.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "UserDetails")
public class UserDto {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int customerId;
	@Column(nullable = false , unique = true)
	private String userName;
	@Column(nullable =false )
	private String password;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false , unique = true)
	private long phoneNo;
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "UserDto [userName=" + userName + ", password=" + password + ", name=" + name + ", phoneNo=" + phoneNo
				+ "]";
	}
}
