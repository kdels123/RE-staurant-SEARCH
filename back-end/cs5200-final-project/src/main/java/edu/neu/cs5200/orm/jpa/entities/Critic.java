package edu.neu.cs5200.orm.jpa.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Critic extends User{
	private String urlToOtherWork;
	
	@OneToMany(mappedBy="critic", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Review> reviews;  // 1tomany
	
	@ManyToMany
	@JoinTable(name="Critic2Patron",
			joinColumns=@JoinColumn(
					name="CRITIC_ID",
					referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(
					name="PATRON_ID",
					referencedColumnName="ID"))
	@JsonIgnore
	private List<Patron> followers; // manytomany
	
	@ManyToMany
	@JoinTable(name="Critic2BlockedPatron",
			joinColumns=@JoinColumn(
					name="CRITIC_ID",
					referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(
					name="PATRON_ID",
					referencedColumnName="ID"))
	@JsonIgnore
	private List<Patron> blockedFollowers;
	
	@ManyToMany(mappedBy="criticsInvited")
	@JsonIgnore
	private List<Owner> ownerInvites;
	
	@ManyToMany(mappedBy="criticEndorsements")
	@JsonIgnore
	private List<Owner> ownersEndorsed;
	
	@ManyToMany(mappedBy="criticAttendees")
	@JsonIgnore
	private List<Event> eventsAttended; //manytomany

	public String getUrlToOtherWork() {
		return urlToOtherWork;
	}
	public void setUrlToOtherWork(String urlToOtherWork) {
		this.urlToOtherWork = urlToOtherWork;
	}
	public List<Patron> getFollowers() {
		return followers;
	}
	public void setFollowers(List<Patron> followers) {
		this.followers = followers;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public List<Owner> getOwnerInvites() {
		return ownerInvites;
	}
	public void setOwnerInvites(List<Owner> ownerInvites) {
		this.ownerInvites = ownerInvites;
	}
	public List<Patron> getBlockedFollowers() {
		return blockedFollowers;
	}
	public void setBlockedFollowers(List<Patron> blockedFollowers) {
		for (Patron p: blockedFollowers) {
			if (this.followers.contains(p)) {
				this.followers.remove(p);
			}
		}
		this.blockedFollowers = blockedFollowers;
		
	}
	public List<Owner> getOwnersEndorsed() {
		return ownersEndorsed;
	}
	public void setOwnersEndorsed(List<Owner> ownersEndorsed) {
		this.ownersEndorsed = ownersEndorsed;
	}
	public List<Event> getEventsAttended() {
		return eventsAttended;
	}
	public void setEventsAttended(List<Event> eventsAttended) {
		this.eventsAttended = eventsAttended;
	}
	
	
}
