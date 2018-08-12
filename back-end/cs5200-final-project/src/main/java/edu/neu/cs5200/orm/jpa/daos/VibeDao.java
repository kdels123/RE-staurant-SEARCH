package edu.neu.cs5200.orm.jpa.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.cs5200.orm.jpa.entities.Owner;
import edu.neu.cs5200.orm.jpa.entities.Restaurant;
import edu.neu.cs5200.orm.jpa.entities.Vibe;
import edu.neu.cs5200.orm.jpa.repositories.VibeRepository;

@Component
public class VibeDao {
	@Autowired
	VibeRepository vibeRepository;
	@Autowired
	RestaurantDao restaurantDao;
	
	public void test() {
		//Delete vibes
		deleteAllVibes();
		
		//Create vibe
		Vibe vibe = new Vibe();
		vibe.setCuisine("Mediterranean");
		vibe.setDietarySpeciality("Vegetarian");
		vibe.setOutdoorSeating("Yes");
		vibe.setAlcoholServed("Yes");
		
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		Restaurant restaurant = new Restaurant();
		restaurant.setName("Anoush'ella");
		restaurant.setAddress("35 West Newton Street");
		restaurant.setCity("Boston");
		
		Owner owner = new Owner();
		owner.setFirstName("Nina");
		owner.setLastName("Festekjian");
		owner.setUsername("nFest");
		owner.setPassword("nFest");
		
		restaurant.setOwner(owner);
		restaurantList.add(restaurant);
		
		vibe.setRestaurants(restaurantList);
		
		createVibe(vibe);
		
		
	}
	
	
	
	// CREATE Vibe
	public Vibe createVibe(Vibe vibe) {
		if(vibe.getRestaurants() != null) {
			//Restaurant restaurant = new Restaurant();
			List<Restaurant> restaurantList = new ArrayList<Restaurant>();
			for (Restaurant r: vibe.getRestaurants()) {
				restaurantDao.createRestaurant(r);
				r = restaurantDao.findRestaurantByName(r.getName());
				restaurantList.add(r);
				System.out.println("CHECK 0");
				System.out.println(r.getName());
			}
			vibe.setRestaurants(restaurantList);
		}

		if(!existVibe(vibe)) {
			System.out.println("CHECK 1");
			System.out.println(vibe.getRestaurants());
			return vibeRepository.save(vibe);
		}
		
		return null;
	}
		
	// DELETE all Vibes
	public void deleteAllVibes() {
		vibeRepository.deleteAll();
	}
		
	// DELETE Vibe
	public void deleteVibe(Vibe vibe) {
		vibeRepository.delete(vibe);
	}
		
	// DELETE Vibe by ID
	public void deleteVibeById(int id) {
		vibeRepository.deleteById(id);
	}
		
	// FIND ALL vibe
	public List<Vibe> findAllVibes() {
		return (List<Vibe>) vibeRepository.findAll();
	}
		
	// FIND Vibe by ID
	public Optional<Vibe> findVibeById(int id) {
		return vibeRepository.findById(id);
	}
		
	// UPDATE Vibe
	public void updateVibe(int id, Vibe newVibe) {
		Optional<Vibe> optional = findVibeById(id);
		if (optional.isPresent()) {
			Vibe currVibe = optional.get();
			
			String cuisine = newVibe.getCuisine() != null ? newVibe.getCuisine() : currVibe.getCuisine();
			String dietarySpeciality = newVibe.getDietarySpeciality() != null ? newVibe.getDietarySpeciality() : currVibe.getDietarySpeciality();
			String outdoorSeating = newVibe.getOutdoorSeating() != null ? newVibe.getOutdoorSeating() : currVibe.getOutdoorSeating();
			String alcoholServed = newVibe.getAlcoholServed() != null ? newVibe.getAlcoholServed() : currVibe.getAlcoholServed();
			Integer averageAge = newVibe.getAverageAge() != null ? newVibe.getAverageAge() : currVibe.getAverageAge();
			List<Restaurant> restaurants = newVibe.getRestaurants() != null ? newVibe.getRestaurants() : currVibe.getRestaurants();
			
			currVibe.setCuisine(cuisine);
			currVibe.setDietarySpeciality(dietarySpeciality);
			currVibe.setOutdoorSeating(outdoorSeating);
			currVibe.setAlcoholServed(alcoholServed);
			currVibe.setAverageAge(averageAge);
			currVibe.setRestaurants(restaurants);
	
			vibeRepository.save(currVibe);
		}
	}
		
	// Check if Vibe already exists
	public boolean existVibe(Vibe vibe) {
		List<Vibe> vibes = findAllVibes();
		for (Vibe v : vibes) {
			if (v.getCuisine().equals(vibe.getCuisine())
					&& v.getDietarySpeciality().equals(vibe.getDietarySpeciality())
					&& v.getAlcoholServed().equals(vibe.getAlcoholServed())
					&& v.getOutdoorSeating().equals(vibe.getOutdoorSeating())
					&& v.getAverageAge().equals(vibe.getAverageAge())) {
				return true;
			}
		}
		return false;
	}


}
