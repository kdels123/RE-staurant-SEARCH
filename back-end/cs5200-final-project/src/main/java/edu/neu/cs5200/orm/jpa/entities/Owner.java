package edu.neu.cs5200.orm.jpa.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Owner extends User{
	
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
	private List<Restaurant> restaurants; //1tomany
	
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
	//@JsonIgnore
	private List<Event> events; //1toMany
	
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
	

}
