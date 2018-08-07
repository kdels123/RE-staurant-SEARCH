package edu.neu.cs5200.orm.jpa.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Patron extends User{
	
	@ManyToMany(mappedBy="patrons")
	@JsonIgnore
	private List<Restaurant> restaurantsVisited; //manytomany
	
	@ManyToMany(mappedBy="attendees")
	@JsonIgnore
	private List<Event> eventsAttended; //manytomany
	
	@ManyToMany(mappedBy="followers")
	@JsonIgnore
	private List<Critic> criticsFollow; //manytomany
//	
//	
//	public List<Restaurant> getRestaurantsVisited() {
//		return restaurantsVisited;
//	}
//	public void setRestaurantsVisited(List<Restaurant> restaurantsVisited) {
//		this.restaurantsVisited = restaurantsVisited;
//	}
//	public List<Event> getEventsAttended() {
//		return eventsAttended;
//	}
//	public void setEventsAttended(List<Event> eventsAttended) {
//		this.eventsAttended = eventsAttended;
//	}
//	public List<Critic> getCriticsFollow() {
//		return criticsFollow;
//	}
//	public void setCriticsFollow(List<Critic> criticsFollow) {
//		this.criticsFollow = criticsFollow;
//	}
//	
	
	
	
	
}
