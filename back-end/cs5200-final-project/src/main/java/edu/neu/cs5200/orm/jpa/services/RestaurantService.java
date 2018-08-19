package edu.neu.cs5200.orm.jpa.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.cs5200.orm.jpa.daos.RestaurantDao;
import edu.neu.cs5200.orm.jpa.entities.Restaurant;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestaurantService {
	@Autowired
	RestaurantDao restaurantDao;
	
	//GET: List of restaurants
	@GetMapping("/api/restaurant")
	public List<Restaurant> findAllRestaurant() {
		return restaurantDao.findAllRestaurants();
	}
	
	//GET: Restaurant instance whose primary key is rid
	@GetMapping("/api/restaurant/{rid}")
	public Optional<Restaurant> findRestaurantById (@PathVariable("rid") int id) {
		return restaurantDao.findRestaurantById(id);
	}
	
	//GET: Restaurant instances for patronId
	@GetMapping("/api/patron/{pid}/restaurant")
	public List<Restaurant> findRestaurantByPatron(@PathVariable("pid") int pid) {
		return restaurantDao.findRestaurantsByPatron(pid);
	}
	
	//GET: Restaurant instances for ownerId
	@GetMapping("/api/owner/{oid}/restaurant")
	public List<Restaurant> findRestaurantByOwner(@PathVariable("oid") int oid) {
		return restaurantDao.findRestaurantByOwner(oid);
	}
		
	//DELETE: Delete restaurant instance whose primary key is rid
	@DeleteMapping("/api/restaurant/{rid}")
	public void deleteRestaurantById(@PathVariable("rid") int id) {
		restaurantDao.deleteRestaurantById(id);
	}
	
	//POST: Create Restaurant
	@PostMapping("/api/restaurant")
	public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantDao.createRestaurant(restaurant);
	}
	
	//POST: Create Restaurant with Owner
		@PostMapping("/api/owner/{oid}/restaurant")
		public Restaurant createRestaurantWitOwner(@PathVariable("oid") int oid, @RequestBody Restaurant restaurant) {
			return restaurantDao.createRestaurant(oid, restaurant);
		}
	
	//PUT: Update restaurant instance whose primary key is rid
	@PutMapping("/api/restaurant/{rid}")
	@Transactional
	public void updateRestaurant(@PathVariable("rid")int id, @RequestBody Restaurant newRestaurant) {
		restaurantDao.updateRestaurant(id, newRestaurant);
	}
	
	//POST: get Restaurant by Name
	@PostMapping("/api/restaurant/name")
	public Restaurant findRestaurantByName(@RequestBody Restaurant restaurant) {
		return  restaurantDao.findRestaurantByName(restaurant.getName());
	}
	
}
