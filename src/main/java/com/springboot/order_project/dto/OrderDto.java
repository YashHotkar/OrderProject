package com.springboot.order_project.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="OrderTable")
public class OrderDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@Column(nullable = false)
	private String productName;
	@Column(nullable = false)
	private int price;
//	@Column(nullable = false)
//	private int customerId;
	@Column(nullable = false)
	private int productId;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@ManyToOne
	UserDto UserDto;
	public UserDto getUserDto() {
		return UserDto;
	}
	public void setUserDto(UserDto userDto) {
		UserDto = userDto;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
