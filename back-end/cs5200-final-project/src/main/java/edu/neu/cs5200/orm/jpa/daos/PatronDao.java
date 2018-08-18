package edu.neu.cs5200.orm.jpa.daos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.cs5200.orm.jpa.entities.Critic;
import edu.neu.cs5200.orm.jpa.entities.Event;
import edu.neu.cs5200.orm.jpa.entities.Patron;
import edu.neu.cs5200.orm.jpa.entities.Restaurant;
import edu.neu.cs5200.orm.jpa.repositories.PatronRepository;
import edu.neu.cs5200.orm.jpa.repositories.RestaurantRepository;


@Component
public class PatronDao {
	@Autowired
	PatronRepository patronRepository;
	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	CriticDao criticDao;
	
	public void test() {
//		//Delete all Patron
//		deleteAllPatrons();
//				
//		//Create Patron
//		Patron patron = new Patron();
//		patron.setFirstName("Jen");
//		patron.setLastName("Sherman");
//		patron.setUsername("jenO");
//		patron.setPassword("jen123");
//		createPatron(patron);
//				
//		Patron patron2 = new Patron();
//		patron2.setFirstName("Chris");
//		patron2.setLastName("Chan");
//		patron2.setUsername("chrisC");
//		patron2.setPassword("chris123");
//		createPatron(patron2);
		//Delete all Patron
//		deleteAllPatrons();
				
		//Create Patron
//		Patron patron = new Patron();
//		patron.setFirstName("Jen");
//		patron.setLastName("Sherman");
//		patron.setUsername("jenO");
//		patron.setPassword("jen123");
//		
//		Critic critic = new Critic();
//		critic.setFirstName("Suzy");
//		critic.setLastName("Smith");
//		critic.setUsername("suzyS");
//		critic.setPassword("suzy123");
//		
//		patron.setFavoriteCritic(critic);
//		createPatron(patron);
//				
//		Patron patron2 = new Patron();
//		patron2.setFirstName("Chris");
//		patron2.setLastName("Chan");
//		patron2.setUsername("chrisC");
//		patron2.setPassword("chris123");
//		createPatron(patron2);
		
		
	}
	
	// CREATE Patron
	public Patron createPatron(Patron patron) {
		if(patron.getFavoriteCritic() != null) {
			criticDao.createCritic(patron.getFavoriteCritic());
			Critic c = criticDao.findCriticByUsername(patron.getFavoriteCritic().getUsername());
			patron.setFavoriteCritic(c);
		}
		if(!existPatron(patron)) {
			return patronRepository.save(patron);
		}
		return null;
	}
		
	// DELETE all patrons
	public void deleteAllPatrons() {
		patronRepository.deleteAll();
	}
		
	// DELETE Patron
	public void deletePatron(Patron patron) {
		patronRepository.delete(patron);
	}
		
	// DELETE Patron by ID
	public void deletePatronById(int id) {
		patronRepository.deleteById(id);
	}
		
	// FIND ALL Patrons
	public List<Patron> findAllPatrons() {
		return (List<Patron>) patronRepository.findAll();
	}
		
	// FIND Patron by ID
	public Optional<Patron> findPatronById(int id) {
		return patronRepository.findById(id);
	}
	
	// FIND Patron by username
	public Patron findPatronByUsername(String username) {
		return patronRepository.findPatronByUsername(username);
	}
	
	// Find Patron by credentials (username and password)
	public Patron findPatronByCredentials(String username, String password) {
		return patronRepository.findPatronByCredentials(username, password);
	}
	
	// UPDATE Patron add restaurantId to patron
	public void addRestaurantToPatron(int rid, int pid) {
		Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(rid);
		Optional<Patron> optionalPatron = findPatronById(pid);
		
		List<Restaurant> restaurantsVisited;
		List<Patron> patronVisitors;
		
		if (optionalPatron.isPresent() && optionalRestaurant.isPresent()) {
			Patron patron = optionalPatron.get();
			Restaurant restaurant = optionalRestaurant.get();
			
			restaurantsVisited = patron.getRestaurantsVisited();
			restaurantsVisited.add(restaurant);
			
			patronVisitors = restaurant.getPatrons();
			patronVisitors.add(patron);
		
			restaurant.setPatrons(patronVisitors);
			restaurantRepository.save(restaurant);
			
			patron.setRestaurantsVisited(restaurantsVisited);
			patronRepository.save(patron);
		}
	}
		
	// UPDATE Patron
	public void updatePatron(int id, Patron newPatron) {
		Optional<Patron> optional = findPatronById(id);
		if (optional.isPresent()) {
			Patron currPatron = optional.get();
			String firstName = newPatron.getFirstName() != null ? newPatron.getFirstName() : currPatron.getFirstName();
			String lastName = newPatron.getLastName() != null ? newPatron.getLastName() : currPatron.getLastName();
			String username = newPatron.getUsername() != null ? newPatron.getUsername() : currPatron.getUsername();
			String password = newPatron.getPassword() != null? newPatron.getPassword(): currPatron.getPassword();
			String email = newPatron.getEmail() != null ? newPatron.getEmail() : currPatron.getEmail();
			String phone = newPatron.getPhone() != null ? newPatron.getPhone() : currPatron.getPhone();
			Date dob = newPatron.getDob() != null ? newPatron.getDob() : currPatron.getDob();
			
			List<Restaurant> restaurantsVisited = newPatron.getRestaurantsVisited() != null ? (List<Restaurant>) newPatron.getRestaurantsVisited() : currPatron.getRestaurantsVisited();
			List<Event> eventsAttended = newPatron.getEventsAttended() != null ? (List<Event>) newPatron.getEventsAttended() : currPatron.getEventsAttended();
			List<Critic> criticsFollow = newPatron.getCriticsFollow() != null ? (List<Critic>) newPatron.getCriticsFollow() : currPatron.getCriticsFollow();
		
			currPatron.setFirstName(firstName);
			currPatron.setLastName(lastName);
			currPatron.setUsername(username);
			currPatron.setPassword(password);
			currPatron.setEmail(email);
			currPatron.setPhone(phone);
			currPatron.setDob(dob);
			currPatron.setRestaurantsVisited(restaurantsVisited);
			currPatron.setEventsAttended(eventsAttended);
			currPatron.setCriticsFollow(criticsFollow);
			
			//createPatron(currPatron);
			patronRepository.save(currPatron);
		}
	}
		
	// Check if Patron already exists
	public boolean existPatron(Patron patron) {
		List<Patron> patrons = findAllPatrons();
		for (Patron p : patrons) {
			if (p.getUsername().equals(patron.getUsername())) {
				return true;
			}
		}
		return false;
	}
}
