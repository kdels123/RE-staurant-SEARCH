package edu.neu.cs5200.orm.jpa.entities.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.cs5200.orm.jpa.entities.RestaurantOwner;
import edu.neu.cs5200.orm.jpa.entities.repositories.RestaurantOwnerRepository;

@Component
public class RestaurantOwnerDao {
	@Autowired
	RestaurantOwnerRepository restaurantOwnerRepo;
	
	public void test() {
		RestaurantOwner restaurantOwner = new RestaurantOwner();
		restaurantOwner.setFirstName("Ken");
		restaurantOwner.setLastName("Oringer");
		restaurantOwner.setRestaurantName("Toro");
		restaurantOwner.setPhoneNumber("617-536-4300");
		restaurantOwner.setAddress("1704 Washington St, Boston, MA 02118");
		
		createRestaurantOwner(restaurantOwner);
	}
	
	public void createRestaurantOwner(RestaurantOwner restaurantOwner) {
		restaurantOwnerRepo.save(restaurantOwner);
	}
}
