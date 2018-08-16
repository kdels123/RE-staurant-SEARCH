package edu.neu.cs5200.orm.jpa.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.cs5200.orm.jpa.entities.Event;
import edu.neu.cs5200.orm.jpa.entities.Patron;
import edu.neu.cs5200.orm.jpa.entities.Review;
import edu.neu.cs5200.orm.jpa.entities.Owner;
import edu.neu.cs5200.orm.jpa.entities.Restaurant;
import edu.neu.cs5200.orm.jpa.entities.Vibe;
import edu.neu.cs5200.orm.jpa.repositories.RestaurantRepository;

@Component
public class RestaurantDao {
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	OwnerDao ownerDao;
	
	public void test() {
		// Delete all restaurants
		deleteAllRestaurants();
		
		
		//Create restaurant
		Restaurant r1 = new Restaurant();
		r1.setName("Toro");
		r1.setAddress("1704 Washington St");
		r1.setCity("Boston");
		r1.setState("MA");
		r1.setPhone("617-536-4300");
		r1.setNumberOfVisits(2000);
		r1.setPrice("$$$");
		Owner owner = new Owner();
		owner.setFirstName("Ken");
		owner.setLastName("Oringer");
		owner.setPhone("617-536-4300");
		owner.setUsername("kenO");
		
		r1.setOwner(owner);
		
		createRestaurant(r1);
		
		List<Restaurant> list = findAllRestaurants();
		for (Restaurant r : list) {
			System.out.println(r.getName());
		}
	}
	
	// CREATE Restaurant
	public Restaurant createRestaurant(Restaurant restaurant) {
		
		if(restaurant.getOwner() != null) {
			ownerDao.createOwner(restaurant.getOwner());
			restaurant.setOwner(ownerDao.findOwnerByUsername(restaurant.getOwner().getUsername()));
		}
		
		if(!existRestaurant(restaurant)) {
			return restaurantRepository.save(restaurant);
		} else {
			return null;
		}
	}
		
	// DELETE all Restaurants
	public void deleteAllRestaurants() {
		restaurantRepository.deleteAll();
	}
		
	// DELETE Restaurant
	public void deleteRestaurant(Restaurant restaurant) {
		restaurantRepository.delete(restaurant);
	}
		
	// DELETE Restaurant by ID
	public void deleteRestaurantById(int id) {
		restaurantRepository.deleteById(id);
	}
		
	// FIND ALL Restaurants
	public List<Restaurant> findAllRestaurants() {
		return (List<Restaurant>) restaurantRepository.findAll();
	}
		
	// FIND Restaurant by ID
	public Optional<Restaurant> findRestaurantById(int id) {
		return restaurantRepository.findById(id);
	}
	
	// FIND Restaurant by Name
	public Restaurant findRestaurantByName(String name) {
		return restaurantRepository.findRestaurantByName(name);
	}
		
	// UPDATE Restaurant
	public void updateRestaurant(int id, Restaurant newRestaurant) {
		Optional<Restaurant> optional = findRestaurantById(id);
		if (optional.isPresent()) {
			Restaurant currRestaurant = optional.get();
			
			String name = newRestaurant.getName() != null ? newRestaurant.getName() : currRestaurant.getName();
			String address = newRestaurant.getAddress() != null ? newRestaurant.getAddress() : currRestaurant.getAddress();
			String city = newRestaurant.getCity() != null ? newRestaurant.getCity() : currRestaurant.getCity();
			String state = newRestaurant.getState() != null ? newRestaurant.getState() : currRestaurant.getState();
			String phone = newRestaurant.getPhone() != null ? newRestaurant.getPhone() : currRestaurant.getPhone();
			Date dateEst = newRestaurant.getDateEst() != null ? newRestaurant.getDateEst() : currRestaurant.getDateEst();
			String hoursOfOpp = newRestaurant.getHoursOfOpp() != null ? newRestaurant.getHoursOfOpp() : currRestaurant.getHoursOfOpp();
			Integer numberOfVisits = newRestaurant.getNumberOfVisits() != null ? newRestaurant.getNumberOfVisits() : currRestaurant.getNumberOfVisits();
			String price = newRestaurant.getPrice() != null ? newRestaurant.getPrice() : currRestaurant.getPrice();
			Vibe vibe = newRestaurant.getVibe() != null ? newRestaurant.getVibe() : currRestaurant.getVibe();
			Owner owner = newRestaurant.getOwner() != null ? newRestaurant.getOwner() : currRestaurant.getOwner();
			List<Review> reviews = newRestaurant.getReviews() != null ? newRestaurant.getReviews() : currRestaurant.getReviews();
			List<Patron> patrons = newRestaurant.getPatrons() != null ? newRestaurant.getPatrons() : currRestaurant.getPatrons();
			List<Event> events = newRestaurant.getEvents() != null ? newRestaurant.getEvents() : currRestaurant.getEvents();
			
			currRestaurant.setName(name);
			currRestaurant.setAddress(address);
			currRestaurant.setCity(city);
			currRestaurant.setState(state);
			currRestaurant.setPhone(phone);
			currRestaurant.setDateEst(dateEst);
			currRestaurant.setHoursOfOpp(hoursOfOpp);
			currRestaurant.setNumberOfVisits(numberOfVisits);
			currRestaurant.setPrice(price);
			currRestaurant.setVibe(vibe);
			currRestaurant.setOwner(owner);
			currRestaurant.setReviews(reviews);
			currRestaurant.setPatrons(patrons);
			currRestaurant.setEvents(events);
			
			restaurantRepository.save(currRestaurant);
		}
	}
		
	// Check if Restaurant already exists
	public boolean existRestaurant(Restaurant restaurant) {
		List<Restaurant> restaurants = findAllRestaurants();
		for (Restaurant r : restaurants) {
			if (r.getName().equals(restaurant.getName())) {
				return true;
			}
		}
		return false;
	}
}
