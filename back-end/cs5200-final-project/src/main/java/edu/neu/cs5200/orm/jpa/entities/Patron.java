package edu.neu.cs5200.orm.jpa.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Patron extends User{
	
	@OneToOne
	//@MapsId
	private Critic favoriteCritic;
	
	@ManyToMany(mappedBy="patrons")
	@JsonIgnore
	private List<Restaurant> restaurantsVisited; //manytomany
	
	@ManyToMany(mappedBy="patronAttendees")
	@JsonIgnore
	private List<Event> eventsAttended; //manytomany
	
	@ManyToMany(mappedBy="followers")
	@JsonIgnore
	private List<Critic> criticsFollow; //manytomany
	
	@ManyToMany(mappedBy="blockedFollowers")
	@JsonIgnore
	private List<Critic> criticsBlockedBy; //manytomany
	
	@ManyToMany
	@JsonIgnore
	private List<Owner> ownerInvites;
	
	@ManyToMany
	@JsonIgnore
	private List<Owner> ownersEndorsed;
	
	
//	public void addRestaurantToList(Restaurant restaurant) {
//		if (restaurantsVisited.isEmpty()) {
//			restaurantsVisited.add(restaurant);
//		}
//		else if (!(restaurantsVisited.isEmpty())) {
//			if (restaurantsVisited.c)
//		}
//	}
//	
	
	
	public List<Restaurant> getRestaurantsVisited() {
		return restaurantsVisited;
	}
	public void setRestaurantsVisited(List<Restaurant> restaurantsVisited) {
		this.restaurantsVisited = restaurantsVisited;
	}
	public List<Event> getEventsAttended() {
		return eventsAttended;
	}
	public void setEventsAttended(List<Event> eventsAttended) {
		this.eventsAttended = eventsAttended;
	}
	public List<Critic> getCriticsFollow() {
		return criticsFollow;
	}
	public void setCriticsFollow(List<Critic> criticsFollow) {
		this.criticsFollow = criticsFollow;
	}
	public Critic getFavoriteCritic() {
		return favoriteCritic;
	}
	public void setFavoriteCritic(Critic favoriteCritic) {
		this.favoriteCritic = favoriteCritic;
	}
	public List<Owner> getOwnerInvites() {
		return ownerInvites;
	}
	public void setOwnerInvites(List<Owner> ownerInvites) {
		this.ownerInvites = ownerInvites;
	}
	public List<Critic> getCriticsBlockedBy() {
		return criticsBlockedBy;
	}
	public void setCriticsBlockedBy(List<Critic> criticsBlockedBy) {
		this.criticsBlockedBy = criticsBlockedBy;
	}
	public List<Owner> getOwnersEndorsed() {
		return ownersEndorsed;
	}
	public void setOwnersEndorsed(List<Owner> ownersEndorsed) {
		this.ownersEndorsed = ownersEndorsed;
	}
	
	
}
