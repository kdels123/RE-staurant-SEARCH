package edu.neu.cs5200.orm.jpa.daos;

import java.util.ArrayList;
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
import edu.neu.cs5200.orm.jpa.repositories.CriticRepository;
import edu.neu.cs5200.orm.jpa.repositories.EventRepository;
import edu.neu.cs5200.orm.jpa.repositories.OwnerRepository;
import edu.neu.cs5200.orm.jpa.repositories.PatronRepository;

@Component
public class CriticDao {
	@Autowired
	CriticRepository criticRepository;
	@Autowired
	PatronDao patronDao;
	@Autowired
	ReviewDao reviewDao;
	@Autowired
	PatronRepository patronRepository;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	EventDao eventDao;
	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	OwnerDao ownerDao;
	
	public void test() {
		//Delete all critic
		deleteAllCritics();
				
		//Create critic
		Critic critic = new Critic();
		critic.setFirstName("Suzy");
		critic.setLastName("Smith");
		critic.setUsername("suzyS");
		critic.setPassword("suzy123");
		createCritic(critic);
		
		//Create Critic
		Critic critic2 = new Critic();
		critic2.setFirstName("Rachel");
		critic2.setLastName("Harrison");
		critic2.setUsername("rachelH");
		critic2.setPassword("rachel123");
		
		// add follower (patron)
		Patron patron = new Patron();
		patron.setFirstName("Jen");
		patron.setLastName("Sherman");
		patron.setUsername("jenO");
		patron.setPassword("jen123");
		
		List<Patron> followers = new ArrayList<Patron>();
		followers.add(patron);
		
		// add blocked follower (patron)
		List<Patron> blockedFollowers = new ArrayList<Patron> ();
		blockedFollowers.add(patron);
		
		critic2.setFollowers(followers);
		critic2.setBlockedFollowers(blockedFollowers);
		createCritic(critic2);
	}
	
	// CREATE Critic
	public Critic createCritic(Critic critic) {
		if(critic.getFollowers() != null) {
			List<Patron> followers = new ArrayList<Patron>();
			for (Patron p : critic.getFollowers()) {
				patronDao.createPatron(p);
				p = patronDao.findPatronByUsername(p.getUsername());
				followers.add(p);
			}
			critic.setFollowers(followers);
		}
		
		if(critic.getBlockedFollowers() != null) {
			List<Patron> blockedFollowers = new ArrayList<Patron>();
			for (Patron p : critic.getBlockedFollowers()) {
				patronDao.createPatron(p);
				p = patronDao.findPatronByUsername(p.getUsername());
				blockedFollowers.add(p);
			}
			critic.setBlockedFollowers(blockedFollowers);
		}
		
		if(!existCritic(critic)) {
			return criticRepository.save(critic);
		}
		return null;
	}
		
	// DELETE all critics
	public void deleteAllCritics() {
		List<Patron> patronList = patronDao.findAllPatrons();
		for (Patron p : patronList) {
			p.setFavoriteCritic(null);
			patronRepository.save(p);
			
		}
		List<Critic> criticList = (List<Critic>) criticRepository.findAll();
		for (Critic c : criticList) {
			for (Owner o : c.getOwnerInvites()) {
				List<Critic> criticsInvited = o.getCriticsInvited();
				criticsInvited.remove(c);
			}
			for (Owner o : c.getOwnersEndorsed()) {
				List<Critic> criticEndorsements = o.getCriticEndorsements();
				criticEndorsements.remove(c);
			}
			for (Event e : c.getEventsAttended()) {
				List<Critic> criticAttendees = e.getCriticAttendees();
				criticAttendees.remove(c);
			}
		}
		
		criticRepository.deleteAll();
	}
		
	// DELETE Critic
	public void deleteCritic(Critic critic) {
		List<Patron> patronList = patronDao.findAllPatrons();
		for (Patron p : patronList) {
			if(p.getFavoriteCritic() != null) {
				if(p.getFavoriteCritic().getId() == critic.getId()) {
					p.setFavoriteCritic(null);
					patronRepository.save(p);
				}
			}
			
		}
		Optional<Critic> optional = criticRepository.findById(critic.getId());
		if (optional.isPresent()) {
			Critic c = optional.get();	
			for (Owner o : c.getOwnerInvites()) {
				List<Critic> criticsInvited = o.getCriticsInvited();
				criticsInvited.remove(c);
			}
			for (Owner o : c.getOwnersEndorsed()) {
				List<Critic> criticEndorsements = o.getCriticEndorsements();
				criticEndorsements.remove(c);
			}
			for (Event e : c.getEventsAttended()) {
				List<Critic> criticAttendees = e.getCriticAttendees();
				criticAttendees.remove(c);
			}
		}
		
		criticRepository.delete(critic);
	}
		
	// DELETE Critic by ID
	public void deleteCriticById(int id) {
		List<Patron> patronList = patronDao.findAllPatrons();
		for (Patron p : patronList) {
			if(p.getFavoriteCritic() != null) {
				if(p.getFavoriteCritic().getId() == id) {
					p.setFavoriteCritic(null);
					patronRepository.save(p);
				}
				
			}
		}
		
		Optional<Critic> optional = criticRepository.findById(id);
		if (optional.isPresent()) {
			Critic c = optional.get();	
			for (Owner o : c.getOwnerInvites()) {
				List<Critic> criticsInvited = o.getCriticsInvited();
				criticsInvited.remove(c);
			}
			for (Owner o : c.getOwnersEndorsed()) {
				List<Critic> criticEndorsements = o.getCriticEndorsements();
				criticEndorsements.remove(c);
			}
			for (Event e : c.getEventsAttended()) {
				List<Critic> criticAttendees = e.getCriticAttendees();
				criticAttendees.remove(c);
			}
		}
		criticRepository.deleteById(id);
	}
		
	// FIND ALL Critic
	public List<Critic> findAllCritics() {
		return (List<Critic>) criticRepository.findAll();
	}
		
	// FIND Critic by ID
	public Optional<Critic> findCriticById(int id) {
		return criticRepository.findById(id);
	}
		
	// FIND Critic by username
	public Critic findCriticByUsername(String username) {
		return criticRepository.findCriticByUsername(username);
	}
	
	// FIND Critics by patronId
	public List<Critic> findCriticsByPatronId(int pid) {
		Optional<Patron> data = patronDao.findPatronById(pid);
		if(data.isPresent()) {
			Patron patron = data.get();
			return patron.getCriticsFollow();
		}
		return null;
	}
	
	// Find Critic by credentials (username and password)
	public Critic findCriticByCredentials(String username, String password) {
		return criticRepository.findCriticByCredentials(username, password);
	}
	
	// FIND Critic by reviewId
	public Critic findCritcByReviewId(int reviewId) {
		Optional<Review> data = reviewDao.findReviewById(reviewId);
		if(data.isPresent()) {
			Review review = data.get();
			return review.getCritic();
		}
		return null;
	}
	
	
	
	// UPDATE Critic add patron to critic's followersBlocked
		public void addBlockedPatronToCritic(int pid, int cid) {
		
			Optional<Patron> optionalPatron = patronDao.findPatronById(pid);
			Optional<Critic> optionalCritic = findCriticById(cid);
//			
			List<Patron> blockedFollowers;		
			if (optionalCritic.isPresent() && optionalPatron.isPresent()) {
				Critic critic = optionalCritic.get();
				Patron patron = optionalPatron.get();
				
				blockedFollowers = critic.getBlockedFollowers();
				blockedFollowers.add(patron);
				
				critic.setBlockedFollowers(blockedFollowers);
				criticRepository.save(critic);
			}

		}
		
		// UPDATE Critic add eventId to critic
		public void addEventToCritic(int eid, int cid) {
			Optional<Event> optionalEvent = eventDao.findEventById(eid);
			Optional<Critic> optionalCritic = findCriticById(cid);
			
			List<Event> eventsAttended;
			List<Critic> criticAttendees;
			
			if (optionalCritic.isPresent() && optionalEvent.isPresent()) {
				Critic critic = optionalCritic.get();
				Event event = optionalEvent.get();
				
				eventsAttended = critic.getEventsAttended();
				eventsAttended.add(event);
				
				criticAttendees = event.getCriticAttendees();
				criticAttendees.add(critic);
			
				event.setCriticAttendees(criticAttendees);
				eventRepository.save(event);
				
				critic.setEventsAttended(eventsAttended);
				criticRepository.save(critic);
			}
		}
		
		// UPDATE Critic add cid to critic's ownersEndorsed
		public void addOwnerToCriticEndorsed(int oid, int cid) {
			Optional<Owner> optionalOwner = ownerDao.findOwnerById(oid);
			Optional<Critic> optionalCritic = findCriticById(cid);
			
			List<Owner> ownersEndorsed;
			List<Critic> criticEndorsements;
			
			if (optionalCritic.isPresent() && optionalOwner.isPresent()) {
				Critic critic = optionalCritic.get();
				Owner owner = optionalOwner.get();
				
				ownersEndorsed = critic.getOwnersEndorsed();
				ownersEndorsed.add(owner);
				
				criticEndorsements = owner.getCriticEndorsements();
				criticEndorsements.add(critic);
				
				owner.setCriticEndorsements(criticEndorsements);
				ownerRepository.save(owner);
				
				critic.setOwnersEndorsed(ownersEndorsed);
				criticRepository.save(critic);
			}
		}
		

	
	
	// UPDATE Critic
	public void updateCritic(int id, Critic newCritic) {
		Optional<Critic> optional = findCriticById(id);
		if (optional.isPresent()) {
			Critic currCritic = optional.get();
			String firstName = newCritic.getFirstName() != null ? newCritic.getFirstName() : currCritic.getFirstName();
			String lastName = newCritic.getLastName() != null ? newCritic.getLastName() : currCritic.getLastName();
			String username = newCritic.getUsername() != null ? newCritic.getUsername() : currCritic.getUsername();
			String password = newCritic.getPassword() != null? newCritic.getPassword(): currCritic.getPassword();
			String email = newCritic.getEmail() != null ? newCritic.getEmail() : currCritic.getEmail();
			String phone = newCritic.getPhone() != null ? newCritic.getPhone() : currCritic.getPhone();
			Date dob = newCritic.getDob() != null ? newCritic.getDob() : currCritic.getDob();
			String url = newCritic.getUrlToOtherWork() != null ? newCritic.getUrlToOtherWork() : currCritic.getUrlToOtherWork();
			
			List<Review> reviews = newCritic.getReviews() != null ? (List<Review>) newCritic.getReviews() : currCritic.getReviews();
			List<Patron> followers = newCritic.getFollowers() != null ? (List<Patron>) newCritic.getFollowers() : currCritic.getFollowers();
			
			currCritic.setFirstName(firstName);
			currCritic.setLastName(lastName);
			currCritic.setUsername(username);
			currCritic.setPassword(password);
			currCritic.setEmail(email);
			currCritic.setPhone(phone);
			currCritic.setDob(dob);
			currCritic.setUrlToOtherWork(url);
			currCritic.setReviews(reviews);
			currCritic.setFollowers(followers);
				
			//createCritic(currCritic);
			criticRepository.save(currCritic);
			
			
		}
	}
		
	// Check if Critic already exists
	public boolean existCritic(Critic critic) {
		List<Critic> critics = findAllCritics();
		for (Critic c : critics) {
			if (c.getUsername().equals(critic.getUsername())) {
				return true;
			}
		}
		return false;
	}
}
