package edu.neu.cs5200.orm.jpa.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vibe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String cuisine;
	private String dietarySpeciality;
	private String outdoorSeating;
	private String alcoholServed;
	private Integer averageAge;
	
	@OneToMany(mappedBy="vibe")
//	@JsonIgnore
	private List<Restaurant> restaurants;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getDietarySpeciality() {
		return dietarySpeciality;
	}

	public void setDietarySpeciality(String dietarySpeciality) {
		this.dietarySpeciality = dietarySpeciality;
	}

//	public boolean isOutdoorSeating() {
//		return outdoorSeating;
//	}
//
//	public void setOutdoorSeating(boolean outdoorSeating) {
//		this.outdoorSeating = outdoorSeating;
//	}
//
//	public boolean isAlchoholServed() {
//		return alcoholServed;
//	}
//
//	public void setAlchoholServed(boolean alchoholServed) {
//		this.alcoholServed = alchoholServed;
//	}

	
	
	
	public String getOutdoorSeating() {
		return outdoorSeating;
	}

	public void setOutdoorSeating(String outdoorSeating) {
		this.outdoorSeating = outdoorSeating;
	}

	public String getAlcoholServed() {
		return alcoholServed;
	}

	public void setAlcoholServed(String alcoholServed) {
		this.alcoholServed = alcoholServed;
	}

	public Integer getAverageAge() {
		return averageAge;
	}

	public void setAverageAge(Integer averageAge) {
		this.averageAge = averageAge;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
	
}
