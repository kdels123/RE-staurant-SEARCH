package edu.neu.cs5200.orm.jpa.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Owner extends User{
	
	@OneToMany(mappedBy="owner")
	private List<Restaurant> restaurants; //1tomany
	
	@OneToMany(mappedBy="owner")
	private List<Event> events; //1toMany

}
