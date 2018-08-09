package edu.neu.cs5200.orm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.neu.cs5200.orm.jpa.entities.Critic;

public interface CriticRepository extends CrudRepository<Critic, Integer>{
	@Query("SELECT c FROM Critic c WHERE c.username=:username")
	Critic findCriticByUsername (@Param("username") String username);
}
