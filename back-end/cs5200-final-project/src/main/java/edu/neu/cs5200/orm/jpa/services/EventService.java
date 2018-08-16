package edu.neu.cs5200.orm.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.cs5200.orm.jpa.daos.EventDao;
import edu.neu.cs5200.orm.jpa.entities.Event;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class EventService {
	@Autowired
	EventDao eventDao;
	
	// GET list of events
	@GetMapping("/api/event")
	public List<Event> findAllEvents() {
		return eventDao.findAllEvents();
	}
}
