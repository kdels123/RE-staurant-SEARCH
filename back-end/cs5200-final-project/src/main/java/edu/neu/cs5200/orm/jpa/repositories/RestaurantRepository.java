package edu.neu.cs5200.orm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.neu.cs5200.orm.jpa.entities.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>{
	@Query("SELECT r FROM Restaurant r WHERE r.name=:name")
	Restaurant findRestaurantByName (@Param("name") String name);
}
