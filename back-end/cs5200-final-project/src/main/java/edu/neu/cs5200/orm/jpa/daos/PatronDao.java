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
import edu.neu.cs5200.orm.jpa.repositories.RestaurantRepository;

@Component
public class PatronDao {
	@Autowired
	PatronRepository patronRepository;
	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	CriticRepository criticRepository;
	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	CriticDao criticDao;
	@Autowired
	RestaurantDao restaurantDao;
	@Autowired
	OwnerDao ownerDao;
	@Autowired
	EventDao eventDao;

	public void test() {
		// //Delete all Patron
		deleteAllPatrons();
		//
		// //Create Patron
		// Patron patron = new Patron();
		// patron.setFirstName("Jen");
		// patron.setLastName("Sherman");
		// patron.setUsername("jenO");
		// patron.setPassword("jen123");
		// createPatron(patron);
		//
		// Patron patron2 = new Patron();
		// patron2.setFirstName("Chris");
		// patron2.setLastName("Chan");
		// patron2.setUsername("chrisC");
		// patron2.setPassword("chris123");
		// createPatron(patron2);
		// Delete all Patron
		// deleteAllPatrons();

		// Create Patron
		Patron patron = new Patron();
		patron.setFirstName("Jen");
		patron.setLastName("Sherman");
		patron.setUsername("jenO");
		patron.setPassword("jen123");

		Critic critic = new Critic();
		critic.setFirstName("Suzy");
		critic.setLastName("Smith");
		critic.setUsername("suzyS");
		critic.setPassword("suzy123");

		patron.setFavoriteCritic(critic);
		createPatron(patron);

		Patron patron2 = new Patron();
		patron2.setFirstName("Chris");
		patron2.setLastName("Chan");
		patron2.setUsername("chrisC");
		patron2.setPassword("chris123");

		// endorse Owner
		Owner owner = new Owner();
		owner.setFirstName("Ken");
		owner.setLastName("Oringer");
		owner.setPhone("617-536-4300");
		owner.setUsername("kenO");
		owner.setPassword("ken123");
		List<Owner> ownersEndorsed = new ArrayList<Owner>();
		ownersEndorsed.add(owner);

		patron2.setOwnersEndorsed(ownersEndorsed);

		createPatron(patron2);
	}

	// CREATE Patron
	public Patron createPatron(Patron patron) {
		if (patron.getFavoriteCritic() != null) {
			criticDao.createCritic(patron.getFavoriteCritic());
			Critic c = criticDao.findCriticByUsername(patron.getFavoriteCritic().getUsername());
			patron.setFavoriteCritic(c);
		}
		// if(patron.getOwnersEndorsed() != null) {
		// for (Owner o : patron.getOwnersEndorsed()) {
		// ownerDao.createOwner(o);
		// o = ownerDao.findOwnerByUsername(o.getUsername());
		// patron.getOwnersEndorsed().add(o);
		// }
		// }
		// if(patron.getRestaurantsVisited() != null) {
		// for (Restaurant r : patron.getRestaurantsVisited()) {
		// restaurantDao.createRestaurant(r);
		// r = restaurantDao.findRestaurantByName(r.getName());
		// patron.getRestaurantsVisited().add(r);
		// }
		// }

		if (!existPatron(patron)) {
			if (patron.getFavoriteCritic() != null) {
				criticDao.createCritic(patron.getFavoriteCritic());
				Critic c = criticDao.findCriticByUsername(patron.getFavoriteCritic().getUsername());
				patron.setFavoriteCritic(c);
			}
			return patronRepository.save(patron);
		}
		return null;
	}

	// DELETE all patrons
	public void deleteAllPatrons() {
		List<Patron> patronList = (List<Patron>) patronRepository.findAll();
		for (Patron p : patronList) {
			for (Critic c : p.getCriticsFollow()) {
				List<Patron> followers = c.getFollowers();
				followers.remove(p);
			}
			for (Critic c : p.getCriticsBlockedBy()) {
				List<Patron> blockedFollowers = c.getBlockedFollowers();
				blockedFollowers.remove(p);
			}
			for (Owner o : p.getOwnerInvites()) {
				List<Patron> patronsInvited = o.getPatronsInvited();
				patronsInvited.remove(p);
			}
			for (Owner o : p.getOwnersEndorsed()) {
				List<Patron> patronEndorsements = o.getPatronEndorsements();
				patronEndorsements.remove(p);
			}
			for (Event e : p.getEventsAttended()) {
				List<Patron> patronAttendees = e.getPatronAttendees();
				patronAttendees.remove(p);
			}
			for (Restaurant r : p.getRestaurantsVisited()) {
				List<Patron> patrons = r.getPatrons();
				patrons.remove(p);
			}
		}
		patronRepository.deleteAll();
	}

	// DELETE Patron
	public void deletePatron(Patron patron) {
		Optional<Patron> optional = patronRepository.findById(patron.getId());
		if (optional.isPresent()) {
			Patron p = optional.get();
			for (Critic c : p.getCriticsFollow()) {
				List<Patron> followers = c.getFollowers();
				followers.remove(p);
			}
			for (Critic c : p.getCriticsBlockedBy()) {
				List<Patron> blockedFollowers = c.getBlockedFollowers();
				blockedFollowers.remove(p);
			}
			for (Owner o : p.getOwnerInvites()) {
				List<Patron> patronsInvited = o.getPatronsInvited();
				patronsInvited.remove(p);
			}
			for (Owner o : p.getOwnersEndorsed()) {
				List<Patron> patronEndorsements = o.getPatronEndorsements();
				patronEndorsements.remove(p);
			}
			for (Event e : p.getEventsAttended()) {
				List<Patron> patronAttendees = e.getPatronAttendees();
				patronAttendees.remove(p);
			}
			for (Restaurant r : p.getRestaurantsVisited()) {
				List<Patron> patrons = r.getPatrons();
				patrons.remove(p);
			}

		}
		patronRepository.delete(patron);
	}

	// DELETE Patron by ID
	public void deletePatronById(int id) {
		Optional<Patron> optional = patronRepository.findById(id);
		System.out.println("BEFORE LOOP");
		if (optional.isPresent()) {
			Patron p = optional.get();
			for (Critic c : p.getCriticsFollow()) {
				List<Patron> followers = c.getFollowers();
				followers.remove(p);
			}
			for (Critic c : p.getCriticsBlockedBy()) {
				List<Patron> blockedFollowers = c.getBlockedFollowers();
				blockedFollowers.remove(p);
			}
			for (Owner o : p.getOwnerInvites()) {
				List<Patron> patronsInvited = o.getPatronsInvited();
				patronsInvited.remove(p);
			}
			for (Owner o : p.getOwnersEndorsed()) {
				List<Patron> patronEndorsements = o.getPatronEndorsements();
				patronEndorsements.remove(p);
			}
			for (Event e : p.getEventsAttended()) {
				List<Patron> patronAttendees = e.getPatronAttendees();
				patronAttendees.remove(p);
			}
			for (Restaurant r : p.getRestaurantsVisited()) {
				List<Patron> patrons = r.getPatrons();
				patrons.remove(p);
			}
		}
		// List<Critic> criticsFollow =
		patronRepository.deleteById(id);
	}

	// FIND ALL Patrons
	public List<Patron> findAllPatrons() {
		return (List<Patron>) patronRepository.findAll();
	}

	// FIND Patron by ID
	public Optional<Patron> findPatronById(int id) {
		return patronRepository.findById(id);
	}

	// FIND Patron by username
	public Patron findPatronByUsername(String username) {
		return patronRepository.findPatronByUsername(username);
	}

	// Find Patron by credentials (username and password)
	public Patron findPatronByCredentials(String username, String password) {
		return patronRepository.findPatronByCredentials(username, password);
	}

	// Find Patrons by restaurant
	public List<Patron> findAllPatronsForRestaurant(int restaurantId) {
		Optional<Restaurant> data = restaurantDao.findRestaurantById(restaurantId);
		if (data.isPresent()) {
			Restaurant restaurant = data.get();
			return restaurant.getPatrons();
		} else {
			return null;
		}
	}

	// Find Patrons by critic
	public List<Patron> findPatronsForCritic(int criticId) {
		Optional<Critic> data = criticDao.findCriticById(criticId);
		if (data.isPresent()) {
			Critic critic = data.get();
			return critic.getFollowers();
		} else {
			return null;
		}
	}

	// Find blocked-patrons by critic
	public List<Patron> findBlockPatronsByCritic(int criticId) {
		Optional<Critic> data = criticDao.findCriticById(criticId);
		if (data.isPresent()) {
			Critic critic = data.get();
			return critic.getBlockedFollowers();
		} else {
			return null;
		}
	}
	
	// Find Patrons by owner
		public List<Patron> findPatronsByOwner(int ownerId) {
			Optional<Owner> data = ownerDao.findOwnerById(ownerId);
			if (data.isPresent()) {
				Owner owner = data.get();
				return owner.getPatronEndorsements();
			} else {
				return null;
			}
		}

	// UPDATE Patron add restaurantId to patron
	public void addRestaurantToPatron(int rid, int pid) {
		Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(rid);
		Optional<Patron> optionalPatron = findPatronById(pid);

		List<Restaurant> restaurantsVisited;
		List<Patron> patronVisitors;

		if (optionalPatron.isPresent() && optionalRestaurant.isPresent()) {
			Patron patron = optionalPatron.get();
			Restaurant restaurant = optionalRestaurant.get();

			restaurantsVisited = patron.getRestaurantsVisited();
			restaurantsVisited.add(restaurant);

			patronVisitors = restaurant.getPatrons();
			patronVisitors.add(patron);

			restaurant.setPatrons(patronVisitors);
			restaurantRepository.save(restaurant);

			patron.setRestaurantsVisited(restaurantsVisited);
			patronRepository.save(patron);
		}
	}

	// UPDATE Patron add eventId to patron
	public void addEventToPatron(int eid, int pid) {
		Optional<Event> optionalEvent = eventDao.findEventById(eid);
		Optional<Patron> optionalPatron = findPatronById(pid);

		List<Event> eventsAttended;
		List<Patron> patronAttended;

		if (optionalPatron.isPresent() && optionalEvent.isPresent()) {
			Patron patron = optionalPatron.get();
			Event event = optionalEvent.get();

			eventsAttended = patron.getEventsAttended();
			eventsAttended.add(event);

			patronAttended = event.getPatronAttendees();
			patronAttended.add(patron);

			event.setPatronAttendees(patronAttended);
			eventRepository.save(event);

			patron.setEventsAttended(eventsAttended);
			patronRepository.save(patron);
		}
	}

	// UPDATE Patron add critic to patron criticsFollow
	public void addCriticToPatron(int cid, int pid) {
		Optional<Critic> optionalCritic = criticDao.findCriticById(cid);
		Optional<Patron> optionalPatron = findPatronById(pid);

		List<Critic> criticsFollow;
		List<Patron> patronFollowers;

		if (optionalPatron.isPresent() && optionalCritic.isPresent()) {
			Patron patron = optionalPatron.get();
			Critic critic = optionalCritic.get();

			criticsFollow = patron.getCriticsFollow();
			criticsFollow.add(critic);

			patronFollowers = critic.getFollowers();
			patronFollowers.add(patron);

			critic.setFollowers(patronFollowers);
			criticRepository.save(critic);

			patron.setCriticsFollow(criticsFollow);
			patronRepository.save(patron);
		}
	}

	// UPDATE Patron add oid to patron's ownersEndorsed
	public void addOwnerToPatronEndorsed(int oid, int pid) {
		Optional<Owner> optionalOwner = ownerDao.findOwnerById(oid);
		Optional<Patron> optionalPatron = findPatronById(pid);

		List<Owner> ownersEndorsed;
		List<Patron> patronEndorsements;

		if (optionalPatron.isPresent() && optionalOwner.isPresent()) {
			Patron patron = optionalPatron.get();
			Owner owner = optionalOwner.get();

			ownersEndorsed = patron.getOwnersEndorsed();
			ownersEndorsed.add(owner);

			patronEndorsements = owner.getPatronEndorsements();
			patronEndorsements.add(patron);

			owner.setPatronEndorsements(patronEndorsements);
			ownerRepository.save(owner);

			patron.setOwnersEndorsed(ownersEndorsed);
			patronRepository.save(patron);
		}
	}

	// UPDATE Patron
	public void updatePatron(int id, Patron newPatron) {
		Optional<Patron> optional = findPatronById(id);
		if (optional.isPresent()) {
			Patron currPatron = optional.get();
			String firstName = newPatron.getFirstName() != null ? newPatron.getFirstName() : currPatron.getFirstName();
			String lastName = newPatron.getLastName() != null ? newPatron.getLastName() : currPatron.getLastName();
			String username = newPatron.getUsername() != null ? newPatron.getUsername() : currPatron.getUsername();
			String password = newPatron.getPassword() != null ? newPatron.getPassword() : currPatron.getPassword();
			String email = newPatron.getEmail() != null ? newPatron.getEmail() : currPatron.getEmail();
			String phone = newPatron.getPhone() != null ? newPatron.getPhone() : currPatron.getPhone();
			Date dob = newPatron.getDob() != null ? newPatron.getDob() : currPatron.getDob();

			List<Restaurant> restaurantsVisited = newPatron.getRestaurantsVisited() != null
					? (List<Restaurant>) newPatron.getRestaurantsVisited()
					: currPatron.getRestaurantsVisited();
			List<Event> eventsAttended = newPatron.getEventsAttended() != null
					? (List<Event>) newPatron.getEventsAttended()
					: currPatron.getEventsAttended();
			List<Critic> criticsFollow = newPatron.getCriticsFollow() != null
					? (List<Critic>) newPatron.getCriticsFollow()
					: currPatron.getCriticsFollow();

			currPatron.setFirstName(firstName);
			currPatron.setLastName(lastName);
			currPatron.setUsername(username);
			currPatron.setPassword(password);
			currPatron.setEmail(email);
			currPatron.setPhone(phone);
			currPatron.setDob(dob);
			currPatron.setRestaurantsVisited(restaurantsVisited);
			currPatron.setEventsAttended(eventsAttended);
			currPatron.setCriticsFollow(criticsFollow);

			// createPatron(currPatron);
			patronRepository.save(currPatron);
		}
	}

	// Check if Patron already exists
	public boolean existPatron(Patron patron) {
		List<Patron> patrons = findAllPatrons();
		for (Patron p : patrons) {
			if (p.getUsername().equals(patron.getUsername())) {
				return true;
			}
		}
		return false;
	}
}
