package edu.neu.cs5200.orm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.neu.cs5200.orm.jpa.entities.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Integer>{
	@Query("SELECT o FROM Owner o WHERE o.username=:username")
	public Owner findOwnerByUsername (@Param("username") String username);
	
	@Query("SELECT u FROM Owner u WHERE u.username=:username AND u.password=:password")
	public Owner findOwnerByCredentials(@Param("username") String username, @Param("password") String password);
}
