package edu.neu.cs5200.orm.jpa.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.cs5200.orm.jpa.entities.Owner;
import edu.neu.cs5200.orm.jpa.entities.Restaurant;
import edu.neu.cs5200.orm.jpa.entities.Vibe;
import edu.neu.cs5200.orm.jpa.repositories.RestaurantRepository;
import edu.neu.cs5200.orm.jpa.repositories.VibeRepository;

@Component
public class VibeDao {
	@Autowired
	VibeRepository vibeRepository;
	@Autowired
	RestaurantDao restaurantDao;
	@Autowired
	RestaurantRepository restaurantRepository;
	
	public void test() {
//		//Delete vibes
//		deleteAllVibes();
//		
//		//Create vibe
//		Vibe vibe = new Vibe();
//		vibe.setCuisine("Mediterranean");
//		vibe.setDietarySpeciality("Vegetarian");
//		vibe.setOutdoorSeating("Yes");
//		vibe.setAlcoholServed("Yes");
//		
//		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
//		Restaurant restaurant = new Restaurant();
//		restaurant.setName("Anoush'ella");
//		restaurant.setAddress("35 West Newton Street");
//		restaurant.setCity("Boston");
//		//restaurant.setNumberOfVisits(2000);
//		
//		Owner owner = new Owner();
//		owner.setFirstName("Nina");
//		owner.setLastName("Festekjian");
//		owner.setUsername("nFest");
//		owner.setPassword("nFest");
//		
//		restaurant.setOwner(owner);
//		restaurantList.add(restaurant);
//		
//		vibe.setRestaurants(restaurantList);
//		
//		createVibe(vibe);
		
		
	}
	
	
	// CREATE Vibe
	public Vibe createVibe(Vibe vibe) {
		System.out.println("VibeDAo CHECK 1");
		vibe = vibeRepository.save(vibe);
		if(vibe.getRestaurants() != null) {
			//Restaurant restaurant = new Restaurant();
			List<Restaurant> restaurantList = new ArrayList<Restaurant>();
			for (Restaurant r: vibe.getRestaurants()) {
				//r.setVibe(vibe);
				restaurantDao.createRestaurant(r);
				r = restaurantDao.findRestaurantByName(r.getName());
				restaurantList.add(r);
				
			}
			vibe.setRestaurants(restaurantList);
			for (Restaurant r : vibe.getRestaurants()) {
				System.out.println(r.getId() + " " + r.getName());
				System.out.println("vibe id " + vibe.getId());
				Optional<Vibe> optional = findVibeById(vibe.getId());
				if (optional.isPresent()) {
					Vibe setVibe = optional.get();
					r.setVibe(setVibe);
					restaurantDao.updateRestaurant(r.getId(), r);
				}
//				restaurantDao.updateRestaurant(r.getId(), r);
			}
		}
		
		

//		if(!existVibe(vibe)) {
//			System.out.println("VibeDAo CHECK 2");
			return vibeRepository.save(vibe);
//		}
		
//		return null;
	}
		
	// DELETE all Vibes
	public void deleteAllVibes() {
		System.out.println("CHECK DELETE ALL");
//		Restaurant newR = new Restaurant();
		for (Vibe v : vibeRepository.findAll() ) {
			System.out.println("CHECK DELETE ALL 2");
			for(Restaurant r : v.getRestaurants()) {
				
				System.out.println("CHECK DELETE ALL 3");
				System.out.println(r.getName());
//				newR.setVibe(null);
				r.setVibe(null);
				System.out.println(r.getId());
				//restaurantDao.updateRestaurant(r.getId(), newR);
				restaurantRepository.save(r);
				System.out.println("CHECK DELETE ALL 4");
			}
		}
		vibeRepository.deleteAll();
	}
		
	// DELETE Vibe
	public void deleteVibe(Vibe vibe) {
		vibeRepository.delete(vibe);
	}
		
	// DELETE Vibe by ID
	public void deleteVibeById(int id) {
		for (Vibe v: vibeRepository.findAll()) {
			for(Restaurant r : v.getRestaurants()) {
				if (r.getVibe().getId() == id) {
					r.setVibe(null);
				}
			}
		}
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
				System.out.println("VibeDAo EXIST CHECK true");
				return true;
			}
		}
		System.out.println("VibeDAo EXIST CHECK");
		return false;
	}


}
