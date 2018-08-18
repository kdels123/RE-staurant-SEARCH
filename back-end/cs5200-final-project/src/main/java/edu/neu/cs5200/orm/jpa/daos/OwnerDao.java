package edu.neu.cs5200.orm.jpa.daos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.cs5200.orm.jpa.entities.Critic;
import edu.neu.cs5200.orm.jpa.entities.Event;
import edu.neu.cs5200.orm.jpa.entities.Owner;
import edu.neu.cs5200.orm.jpa.entities.Patron;
import edu.neu.cs5200.orm.jpa.entities.Restaurant;
import edu.neu.cs5200.orm.jpa.entities.Review;
import edu.neu.cs5200.orm.jpa.repositories.OwnerRepository;

@Component
public class OwnerDao {
	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	EventDao eventDao;
	@Autowired
	PatronDao patronDao;
	@Autowired
	CriticDao criticDao;
	
	public void test() {
//		//Delete all owners
//		deleteAllOwners();
//		
//		//Create owners
//		Owner owner = new Owner();
//		owner.setFirstName("Ken");
//		owner.setLastName("Oringer");
//		owner.setPhone("617-536-4300");
//		owner.setUsername("kenO");
//		owner.setPassword("ken123");
//		createOwner(owner);
//		
//		Owner owner2 = new Owner();
//		owner2.setFirstName("Jamie");
//		owner2.setLastName("Bissonnette");
//		owner2.setUsername("jamieB");
//		owner2.setPassword("jamie123");
//		createOwner(owner2);
		
	}
	
	
	// CREATE Owner
	public Owner createOwner(Owner owner) {
		if(!existOwner(owner)) {
			return ownerRepository.save(owner);
		}
		return null;
	}
	
	// DELETE all owners
	public void deleteAllOwners() {
		ownerRepository.deleteAll();
	}
	
	// DELETE Owner
	public void deleteOwner(Owner owner) {
		ownerRepository.delete(owner);
	}
	
	// DELETE Owner by ID
	public void deleteOwnerById(int id) {
		ownerRepository.deleteById(id);
	}
	
	// FIND ALL Owners
	public List<Owner> findAllOwners() {
		return (List<Owner>) ownerRepository.findAll();
	}
	
	// FIND Owner by ID
	public Optional<Owner> findOwnerById(int id) {
		return ownerRepository.findById(id);
	}
	
	// FIND Owner by Username
	public Owner findOwnerByUsername(String username) {
		return ownerRepository.findOwnerByUsername(username);
	}
	
	// Find Owner by credentials (username and password)
	public Owner findOwnerByCredentials(String username, String password) {
		return ownerRepository.findOwnerByCredentials(username, password);
	}
	
	
//	// UPDATE Patron add eventId to patron
//		public void addEventToPatron(int eid, int pid) {
//			Optional<Event> optionalEvent = eventDao.findEventById(eid);
//			Optional<Patron> optionalPatron = findPatronById(pid);
//			
//			List<Event> eventsAttended;
//			List<Patron> patronAttended;
//			
//			if (optionalPatron.isPresent() && optionalEvent.isPresent()) {
//				Patron patron = optionalPatron.get();
//				Event event = optionalEvent.get();
//				
//				eventsAttended = patron.getEventsAttended();
//				eventsAttended.add(event);
//				
//				patronAttended = event.getPatronAttendees();
//				patronAttended.add(patron);
//			
//				event.setPatronAttendees(patronAttended);
//				eventRepository.save(event);
//				
//				patron.setEventsAttended(eventsAttended);
//				patronRepository.save(patron);
//			}
//		}
	
	// Update Owner add patronId to patronsInvited
	public void addPatronInviteToOwner(int pid, int oid) {
		Optional <Owner> optionalOwner = findOwnerById(oid);
		Optional <Patron> optionalPatron = patronDao.findPatronById(pid);
		
		List<Patron> patronsInvited;
		
		if (optionalOwner.isPresent() && optionalPatron.isPresent()) {
			Owner owner = optionalOwner.get();
			Patron patron = optionalPatron.get();
			
			patronsInvited = owner.getPatronsInvited();
			patronsInvited.add(patron);
			
			owner.setPatronsInvited(patronsInvited);
			ownerRepository.save(owner);
			
		}
	}
	
	// Update Owner add criticId to criticsInvited
		public void addCriticInviteToOwner(int cid, int oid) {
			Optional <Owner> optionalOwner = findOwnerById(oid);
			Optional <Critic> optionalCritic = criticDao.findCriticById(cid);
			
			List<Critic> criticsInvited;
			
			if (optionalOwner.isPresent() && optionalCritic.isPresent()) {
				Owner owner = optionalOwner.get();
				Critic critic = optionalCritic.get();
				
				criticsInvited = owner.getCriticsInvited();
				criticsInvited.add(critic);
				
				owner.setCriticsInvited(criticsInvited);
				ownerRepository.save(owner);
				
			}
		}
	
	
	
	
	// UPDATE Owner
	public void updateOwner(int id, Owner newOwner) {
		Optional<Owner> optional = findOwnerById(id);
		if (optional.isPresent()) {
			Owner currOwner = optional.get();
			String firstName = newOwner.getFirstName() != null ? newOwner.getFirstName() : currOwner.getFirstName();
			String lastName = newOwner.getLastName() != null ? newOwner.getLastName() : currOwner.getLastName();
			String username = newOwner.getUsername() != null ? newOwner.getUsername() : currOwner.getUsername();
			String password = newOwner.getPassword() != null? newOwner.getPassword(): currOwner.getPassword();
			String email = newOwner.getEmail() != null ? newOwner.getEmail() : currOwner.getEmail();
			String phone = newOwner.getPhone() != null ? newOwner.getPhone() : currOwner.getPhone();
			Date dob = newOwner.getDob() != null ? newOwner.getDob() : currOwner.getDob();
			List<Restaurant> restaurants = newOwner.getRestaurants() != null ? (List<Restaurant>) newOwner.getRestaurants() : currOwner.getRestaurants();
			List<Event> events = newOwner.getEvents() != null ? (List<Event>) newOwner.getEvents() : currOwner.getEvents();
		
			currOwner.setFirstName(firstName);
			currOwner.setLastName(lastName);
			currOwner.setUsername(username);
			currOwner.setPassword(password);
			currOwner.setEmail(email);
			currOwner.setPhone(phone);
			currOwner.setDob(dob);
			currOwner.setRestaurants(restaurants);
			currOwner.setEvents(events);
			
			//createOwner(currOwner);
			ownerRepository.save(currOwner);
		
		
		}
	}
	
	// Check if Owner already exists
	public boolean existOwner(Owner owner) {
		List<Owner> owners = findAllOwners();
		for (Owner o : owners) {
			if (o.getUsername().equals(owner.getUsername())) {
				return true;
			}
		}
		return false;
	}
	
	// FIND Owner by restaurantId
		public Owner findOwnerByEventId(int eventId) {
			Optional<Event> data = eventDao.findEventById(eventId);
			if(data.isPresent()) {
				Event event = data.get();
				return event.getOwner();
			}
			return null;
		}
}
