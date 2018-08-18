package edu.neu.cs5200.orm.jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.cs5200.orm.jpa.daos.EventDao;
import edu.neu.cs5200.orm.jpa.entities.Event;
import edu.neu.cs5200.orm.jpa.entities.Restaurant;
import edu.neu.cs5200.orm.jpa.entities.Review;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class EventService {
	@Autowired
	EventDao eventDao;

	// POST: Create Event
	@PostMapping("/api/owner/{oid}/restaurant/{rid}/event")
	public Event createEvent(@RequestBody Event event, @PathVariable("oid") int oid, @PathVariable("rid") int rid) {
		return eventDao.createEvent(event, oid, rid);
	}

	// GET an event by Id
	@GetMapping("/api/event/{eid}")
	public Optional<Event> findEventById(@PathVariable("eid") int eid) {
		return eventDao.findEventById(eid);
	}
	
	
	// GET list of events
	@GetMapping("/api/event")
	public List<Event> findAllEvents() {
		return eventDao.findAllEvents();
	}

	// GET list of events based on restaurant
	@GetMapping("/api/restaurant/{rid}/event")
	public List<Event> findEventsForRestaurant(@PathVariable("rid") int rid) {
		return eventDao.findEventsForRestaurant(rid);
	}
	
	// DELETE Delete event instance whose primary key is eid
	@DeleteMapping("/api/event/{eid}")
	public void deleteEventById(@PathVariable("edi") int eid) {
		eventDao.deleteEventById(eid);
	}
	
	// UPDATE event whose id is eid
	@PutMapping("/api/event/{eid}")
	public void updateEventById(@PathVariable("eid")int eid, @RequestBody Event newEvent) {
		eventDao.updateEvent(eid, newEvent);
	}
	
	

}
