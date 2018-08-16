package edu.neu.cs5200.orm.jpa.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String phone;
	private Date dateEst;
	private String hoursOfOpp;
	private Integer numberOfVisits = 0;
	private String price;
	private String imageUrl;

	
	
	@ManyToOne
	@JsonIgnore
	private Vibe vibe;
	
	@ManyToOne
	@JsonIgnore
	private Owner owner; //manyto1

	@OneToMany(mappedBy="restaurant", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Review> reviews; //1tomany
	
	@ManyToMany
	@JoinTable(name="Restaurant2Patron",
		joinColumns=@JoinColumn(
				name="RESTAURANT_ID",
				referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(
				name="PATRON_ID",
				referencedColumnName="ID"))
	@JsonIgnore
	private List<Patron> patrons;  //manytomany
	
	@OneToMany(mappedBy="restaurant", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Event> events; //1tomany
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDateEst() {
		return dateEst;
	}
	public void setDateEst(Date dateEst) {
		this.dateEst = dateEst;
	}
	public String getHoursOfOpp() {
		return hoursOfOpp;
	}
	public void setHoursOfOpp(String hoursOfOpp) {
		this.hoursOfOpp = hoursOfOpp;
	}
	public Integer getNumberOfVisits() {
		return numberOfVisits;
	}
	public void setNumberOfVisits(Integer numberOfVisits) {
		this.numberOfVisits = numberOfVisits;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Vibe getVibe() {
		return vibe;
	}
	public void setVibe(Vibe vibe) {
		this.vibe = vibe;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public List<Patron> getPatrons() {
		return patrons;
	}
	public void setPatrons(List<Patron> patrons) {
		this.patrons = patrons;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
}
