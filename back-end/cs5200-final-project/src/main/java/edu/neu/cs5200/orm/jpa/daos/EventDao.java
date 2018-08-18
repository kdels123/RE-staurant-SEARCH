package edu.neu.cs5200.orm.jpa.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.cs5200.orm.jpa.entities.Event;
import edu.neu.cs5200.orm.jpa.entities.Owner;
import edu.neu.cs5200.orm.jpa.entities.Patron;
import edu.neu.cs5200.orm.jpa.entities.Restaurant;
import edu.neu.cs5200.orm.jpa.repositories.EventRepository;

@Component
public class EventDao {
	@Autowired
	EventRepository eventRepository;
	@Autowired
	OwnerDao ownerDao;
	@Autowired
	RestaurantDao restaurantDao;
	@Autowired
	PatronDao patronDao;
	
	public void test() {
		// Delete all events
		deleteAllEvents();
		
		// Create event
		
		Event event = new Event();
		event.setAttire("casual");
		event.setTitle("drinks and drinks");
		
		Owner owner = new Owner();
		owner.setFirstName("Ken");
		owner.setLastName("Oringer");
		owner.setPhone("617-536-4300");
		owner.setUsername("kenO");
		
		ownerDao.createOwner(owner);
		event.setOwner(owner);
		
		createEvent(event);
	}
	
	// CREATE Event
	public Event createEvent(Event event, int ownerId, int restaurantId) {
		if (event.getOwner() != null) {
			ownerDao.createOwner(event.getOwner());
			event.setOwner(ownerDao.findOwnerByUsername(event.getOwner().getUsername()));
		}
		
		if (event.getRestaurant() != null) {
			restaurantDao.createRestaurant(event.getRestaurant());
			event.setRestaurant(restaurantDao.findRestaurantByName(event.getRestaurant().getName()));
		}
		
		if (event.getPatronAttendees() != null) {
			Patron newPatron = new Patron();
			List<Patron> patronList = new ArrayList<Patron>();
			for (Patron p : event.getPatronAttendees()) {
				patronDao.createPatron(p);
				newPatron = patronDao.findPatronByUsername(p.getUsername());
				patronList.add(newPatron);
			}
			event.setPatronAttendees(patronList);
		}
				
		if(!existEvent(event)) {
			Event newEvent = new Event();
			newEvent.setTitle(event.getTitle());
			newEvent.setDescription(event.getDescription());
			newEvent.setDateTime(event.getDateTime());
			newEvent.setPrice(event.getPrice());
			newEvent.setAttire(event.getAttire());
			
			newEvent.setPatronAttendees(event.getPatronAttendees());
			newEvent.setOwner(ownerDao.findOwnerById(ownerId).get());
			newEvent.setRestaurant(restaurantDao.findRestaurantById(restaurantId).get());
		
			return eventRepository.save(event);
		}
		return null;
	}
	
	//CREATE: event (that already contains owner and restaurant object)
	public Event createEvent(Event event) {
		if (event.getOwner() != null) {
			ownerDao.createOwner(event.getOwner());
			event.setOwner(ownerDao.findOwnerByUsername(event.getOwner().getUsername()));
		}
		
		if (event.getRestaurant() != null) {
			restaurantDao.createRestaurant(event.getRestaurant());
			event.setRestaurant(restaurantDao.findRestaurantByName(event.getRestaurant().getName()));
		}
		
		if (event.getPatronAttendees() != null) {
			Patron newPatron = new Patron();
			List<Patron> patronList = new ArrayList<Patron>();
			for (Patron p : event.getPatronAttendees()) {
				patronDao.createPatron(p);
				newPatron = patronDao.findPatronByUsername(p.getUsername());
				patronList.add(newPatron);
			}
			event.setPatronAttendees(patronList);
		}
				
		if(!existEvent(event)) {
			Event newEvent = new Event();
			newEvent.setTitle(event.getTitle());
			newEvent.setDescription(event.getDescription());
			newEvent.setDateTime(event.getDateTime());
			newEvent.setPrice(event.getPrice());
			newEvent.setAttire(event.getAttire());
			
			newEvent.setPatronAttendees(event.getPatronAttendees());
			newEvent.setOwner(ownerDao.createOwner(event.getOwner()));
			
			if(event.getRestaurant() != null) {
				newEvent.setRestaurant(restaurantDao.createRestaurant(event.getRestaurant()));
			}
			
		
			return eventRepository.save(event);
		}
		return null;
	}
	
	// DELETE all events
	public void deleteAllEvents() {
		eventRepository.deleteAll();
	}
		
	// DELETE event
	public void deleteEvent(Event event) {
		eventRepository.delete(event);
	}
	
	// DELETE Event by ID
	public void deleteEventById(int id) {
		eventRepository.deleteById(id);
	}
	
	// FIND ALL Events
	public List<Event> findAllEvents() {
		return (List<Event>) eventRepository.findAll();
	}
	
	// FIND Event by ID
	public Optional<Event> findEventById(int id) {
		return eventRepository.findById(id);
	}
	
	// UPDATE Event
	public void updateEvent(int id, Event newEvent) {
		Optional<Event> optional = findEventById(id);
		if (optional.isPresent()) {
			Event currEvent = optional.get();
			
			//String firstName = newOwner.getFirstName() != null ? newOwner.getFirstName() : currOwner.getFirstName();
//				String address = newEvent.getAddress() != null ? newEvent.getAddress() : currEvent.getAddress();
//				String attire = newEvent.getAttire() != null ? newEvent.getAttire() : currEvent.getAttire();
//				String city = newEvent.getCity() != null ? newEvent.getCity() : currEvent.getCity();
//				String state = newEvent.getState() != null ? newEvent.getState() : currEvent.getState();
			Date dateTime = newEvent.getDateTime() != null ? newEvent.getDateTime() : currEvent.getDateTime();
			String description = newEvent.getDescription() != null ? newEvent.getDescription() : currEvent.getDescription();
			Double price = newEvent.getPrice() != null ? newEvent.getPrice() : currEvent.getPrice();
			String title = newEvent.getTitle() != null ? newEvent.getTitle() : currEvent.getTitle();
			Owner owner = newEvent.getOwner() != null ? newEvent.getOwner() : currEvent.getOwner();
			Restaurant restaurant = newEvent.getRestaurant() != null ? newEvent.getRestaurant() : currEvent.getRestaurant();
			List<Patron> attendees = newEvent.getPatronAttendees() != null ? newEvent.getPatronAttendees() : currEvent.getPatronAttendees();
			
//				currEvent.setAddress(address);
//				currEvent.setAttire(attire);
//				currEvent.setCity(city);
//				currEvent.setState(state);
			currEvent.setDateTime(dateTime);
			currEvent.setDescription(description);
			currEvent.setPrice(price);
			currEvent.setTitle(title);
			currEvent.setOwner(owner);
			currEvent.setRestaurant(restaurant);
			currEvent.setPatronAttendees(attendees);
			
			eventRepository.save(currEvent);
		}
	}
	
	// Check if Event already exists
	public boolean existEvent(Event event) {
		List<Event> events = findAllEvents();
		if (events != null) {
			for (Event e : events) {
				if (e.getTitle().equals(event.getTitle())
						&& e.getDateTime().equals(event.getDateTime())
						&& e.getOwner().equals(event.getOwner())
						&& e.getRestaurant().equals(event.getRestaurant())) {
					return true;
				}
			}
		}
		return false;
	}
}
