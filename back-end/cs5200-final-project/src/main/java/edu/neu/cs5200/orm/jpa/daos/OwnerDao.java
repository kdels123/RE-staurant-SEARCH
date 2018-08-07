package edu.neu.cs5200.orm.jpa.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.cs5200.orm.jpa.entities.Owner;
import edu.neu.cs5200.orm.jpa.repositories.OwnerRepository;

@Component
public class OwnerDao {
	@Autowired
	OwnerRepository restaurantOwnerRepo;
	
	public void test() {
		Owner owner = new Owner();
//		restaurantOwner.setFirstName("Ken");
//		restaurantOwner.setLastName("Oringer");
//		restaurantOwner.setRestaurantName("Toro");
//		restaurantOwner.setPhoneNumber("617-536-4300");
//		restaurantOwner.setAddress("1704 Washington St, Boston, MA 02118");
//		
//		createRestaurantOwner(restaurantOwner);
	}
	
	public void createRestaurantOwner(Owner restaurantOwner) {
		restaurantOwnerRepo.save(restaurantOwner);
	}
}
