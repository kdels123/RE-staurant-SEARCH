package edu.neu.cs5200.orm.jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.neu.cs5200.orm.jpa.entities.Event;

public interface EventRepository extends CrudRepository<Event, Integer>{

}
