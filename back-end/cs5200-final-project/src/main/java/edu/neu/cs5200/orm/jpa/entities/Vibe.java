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
	private boolean outdoorSeating;
	private boolean alchoholServed;
	private int averageAge;
	
	@OneToMany(mappedBy="vibe")
	@JsonIgnore
	private List<Restaurant> restaurants;
}
