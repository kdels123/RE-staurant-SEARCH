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
	@JsonIgnore
	private List<Owner> ownerInvites;

	
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
	
	
	
}
