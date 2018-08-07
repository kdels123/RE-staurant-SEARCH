package edu.neu.cs5200.orm.jpa.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private Date dateTime;
	private String address;
	private String city;
	private String state;
	private Double price;
	private String attire;
	
	@ManyToOne
	private Owner owner; //manyto1
	
	@ManyToOne
	private Restaurant restaurant; //manyto1
	
	@ManyToMany
	@JoinTable(name="Event2Patron",
			joinColumns=@JoinColumn(
					name="EVENT_ID",
					referencedColumnName = "ID"),
			inverseJoinColumns=@JoinColumn(
					name="PATRON_ID",
					referencedColumnName="ID"))
	@JsonIgnore
	private List<Patron> attendees; //manytomany
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAttire() {
		return attire;
	}
	public void setAttire(String attire) {
		this.attire = attire;
	}
//	public List<Patron> getAttendees() {
//		return attendees;
//	}
//	public void setAttendees(List<Patron> attendees) {
//		this.attendees = attendees;
//	}
//	public Restaurant getRestaurant() {
//		return restaurant;
//	}
//	public void setRestaurant(Restaurant restaurant) {
//		this.restaurant = restaurant;
//	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	
	
}
