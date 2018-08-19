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

import edu.neu.cs5200.orm.jpa.daos.PatronDao;
import edu.neu.cs5200.orm.jpa.entities.Critic;
import edu.neu.cs5200.orm.jpa.entities.Patron;
import edu.neu.cs5200.orm.jpa.entities.Review;
import edu.neu.cs5200.orm.jpa.entities.User;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PatronService {
	@Autowired
	PatronDao patronDao;

	// GET : List of patrons
	@GetMapping("/api/patron")
	public List<Patron> findAllPatrons() {
		return patronDao.findAllPatrons();
	}

	// Get Patron instance whose primary key is pid
	@GetMapping("/api/patron/{pid}")
	public Optional<Patron> findPatronById(@PathVariable("pid") int id) {
		return patronDao.findPatronById(id);
	}

	// GET: Patron instances for a resturantId
	@GetMapping("/api/restaurant/{rid}/patron")
	public List<Patron> findPatronsForRestaurant(@PathVariable("rid") int rid) {
		return patronDao.findAllPatronsForRestaurant(rid);
	}

	// GET: Patron instances for a criticId
	@GetMapping("/api/critic/{cid}/patron")
	public List<Patron> findPatronsForCritic(@PathVariable("cid") int cid) {
		return patronDao.findPatronsForCritic(cid);
	}

	// GET: BlockPatron instances for a criticId
	@GetMapping("/api/critic/{cid}/blockpatron")
	public List<Patron> findBlockPatronsForCritic(@PathVariable("cid") int cid) {
		return patronDao.findBlockPatronsByCritic(cid);
	}

	// GET: Patron instances for a ownerId
	@GetMapping("/api/owner/{oid}/patron")
	public List<Patron> findPatronsByOwner(@PathVariable("oid") int oid) {
		return patronDao.findPatronsByOwner(oid);
	}

	// GET: Patron instances for a eventId
	@GetMapping("/api/event/{eid}/patron")
	public List<Patron> findPatronsByEvent(@PathVariable("eid") int eid) {
		return patronDao.findPatronsByEvent(eid);
	}
	
	// GET: Patron invite instances for a ownerId
		@GetMapping("/api/owner/{oid}/patronInvite")
		public List<Patron> findPatronInvitesByOwner(@PathVariable("oid") int oid) {
		return patronDao.findPatronInvitesByOwner(oid);
	}
	
	// GET: Critic instances for a patronId
	@GetMapping("/api/favoriteCritic/{pid}/patron")
	public Critic findFavoriteCriticByPatron(@PathVariable("pid") int pid) {
		return patronDao.findFavoriteCriticByPatron(pid);
	}

	// DELETE: Delete Patron instance whose primary key is pid
	@DeleteMapping("/api/patron/{pid}")
	public void deletePatronById(@PathVariable("pid") int id) {
		patronDao.deletePatronById(id);
	}

	// POST: Create patron
	@PostMapping("/api/patron")
	public Patron createPatron(@RequestBody Patron patron) {
		return patronDao.createPatron(patron);
	}

	// GET: Update patron to include the restaurantId
	@GetMapping("/api/restaurant/{rid}/patron/{pid}")
	public void addRestaurantToPatron(@PathVariable("rid") int rid, @PathVariable("pid") int pid) {
		patronDao.addRestaurantToPatron(rid, pid);
	}

	// GET: Update patron to include the eventId
	@GetMapping("/api/event/{eid}/patron/{pid}")
	public void addEventToPatron(@PathVariable("eid") int eid, @PathVariable("pid") int pid) {
		patronDao.addEventToPatron(eid, pid);
	}

	// GET: Update patron to include criticId for critics followed
	@GetMapping("/api/critic/{cid}/patron/{pid}")
	public void addCriticToPatron(@PathVariable("cid") int cid, @PathVariable("pid") int pid) {
		patronDao.addCriticToPatron(cid, pid);
	}

	// GET: Update patron to include favorite critic
	@GetMapping("/api/favoriteCritic/{cid}/patron/{pid}")
	public void addFavoriteCriticToPatron(@PathVariable("cid") int cid, @PathVariable("pid") int pid) {
		patronDao.addFavoriteCriticToPatron(cid, pid);
	}

	// GET: Update patron to include the ownerId for owners endorsed
	@GetMapping("/api/owner/{oid}/patron/{pid}")
	public void addOwnerToPatronEndorsed(@PathVariable("oid") int oid, @PathVariable("pid") int pid) {
		patronDao.addOwnerToPatronEndorsed(oid, pid);
	}

	// PUT: Update patron instance whose primary key is pid
	@PutMapping("/api/patron/{pid}")
	public void updatePatron(@PathVariable("pid") int id, @RequestBody Patron newPatron) {
		patronDao.updatePatron(id, newPatron);
	}

	// Post: Get patron instance by credentials (username and password)
	@PostMapping("/api/patron/login")
	// @ResponseBody
	public Patron login(@RequestBody User user) {
		return patronDao.findPatronByCredentials(user.getUsername(), user.getPassword());
	}

	// Post: Get patron instance by username
	@PostMapping("/api/patron/username")
	public Patron findPatronByUsername(@RequestBody User user) {
		return patronDao.findPatronByUsername(user.getUsername());
	}
}
