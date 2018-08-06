package edu.neu.cs5200.orm.jpa.entities;

import javax.persistence.Entity;

@Entity
public class RestaurantOwner extends User{
	private String restaurantName;
	private String address;
	private String phoneNumber;
//	private List<Review> reviews;
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
