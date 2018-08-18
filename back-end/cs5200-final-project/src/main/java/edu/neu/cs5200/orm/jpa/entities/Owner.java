package edu.neu.cs5200.orm.jpa.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Owner extends User{
	
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
	private List<Restaurant> restaurants; //1tomany
	
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
	//@JsonIgnore
	private List<Event> events; //1toMany
	
	@ManyToMany
	@JoinTable(name="Owner2Patron",
	joinColumns=@JoinColumn(
			name="OWNER_ID",
			referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(
			name="PATRON_ID",
			referencedColumnName="ID"))
	@JsonIgnore
	private List<Patron> patronsInvited; //owner invites patrons to restaurant
	
	@ManyToMany
	@JoinTable(name="Owner2Critic",
	joinColumns=@JoinColumn(
			name="OWNER_ID",
			referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(
			name="CRITIC_ID",
			referencedColumnName="ID"))
	@JsonIgnore
	private List<Critic> criticsInvited; //owner invites critics to restaurant
	
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

	public List<Patron> getPatronsInvited() {
		return patronsInvited;
	}

	public void setPatronsInvited(List<Patron> patronsInvited) {
		this.patronsInvited = patronsInvited;
	}

	public List<Critic> getCriticsInvited() {
		return criticsInvited;
	}

	public void setCriticsInvited(List<Critic> criticsInvited) {
		this.criticsInvited = criticsInvited;
	}
	
	
	

}
