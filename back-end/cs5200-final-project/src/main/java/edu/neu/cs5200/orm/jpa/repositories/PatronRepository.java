package edu.neu.cs5200.orm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.neu.cs5200.orm.jpa.entities.Patron;

public interface PatronRepository extends CrudRepository<Patron, Integer>{
	@Query("SELECT p FROM Patron p WHERE p.username=:username")
	Patron findPatronByUsername (@Param("username") String username);
	
	@Query("SELECT u FROM Patron u WHERE u.username=:username AND u.password=:password")
	public Patron findPatronByCredentials(@Param("username") String username, @Param("password") String password);
}

