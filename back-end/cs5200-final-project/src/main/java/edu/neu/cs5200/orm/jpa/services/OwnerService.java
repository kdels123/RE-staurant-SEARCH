package edu.neu.cs5200.orm.jpa.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.cs5200.orm.jpa.daos.OwnerDao;
import edu.neu.cs5200.orm.jpa.entities.Owner;
import edu.neu.cs5200.orm.jpa.entities.User;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class OwnerService {
	@Autowired
	OwnerDao ownerDao;
	
	// GET: List of owners
	@GetMapping("/api/owner")
	public List<Owner> findAllOwners() {
		return ownerDao.findAllOwners();
	}
	
	//GET: Owner instance whose primary key is oid
	@GetMapping("/api/owner/{oid}")
	public Optional<Owner> findOwnerById (@PathVariable("oid") int id) {
		return ownerDao.findOwnerById(id);
	}
	
	//GET: owner instance based on event (eid)
	@GetMapping("/api/event/{eid}/owner")
	public Owner findOwnerByEvent(@PathVariable("eid") int eid) {
		return ownerDao.findOwnerByEventId(eid);
	}
	
	//GET: update owner to include pid to patronsInvited
	@GetMapping("/api/patron/{pid}/owner/{oid}")
	public void addPatronInviteToOwner(@PathVariable("pid") int pid, @PathVariable("oid") int oid) {
		ownerDao.addPatronInviteToOwner(pid, oid);
	}
	
	//GET: update owner to include cid to catronsInvited
	@GetMapping("/api/critic/{cid}/owner/{oid}")
	public void addCriticnInviteToOwner(@PathVariable("cid") int cid, @PathVariable("oid") int oid) {
		ownerDao.addCriticInviteToOwner(cid, oid);
	}
		
	
	//DELETE: Delete owner instance whose primary key is oid
	@DeleteMapping("/api/owner/{oid}")
	public void deleteOwnerById(@PathVariable("oid") int id) {
		ownerDao.deleteOwnerById(id);
	}
	
	//POST: Create Owner
	@PostMapping("/api/owner")
	public Owner createOwner(@RequestBody Owner owner) {
		return ownerDao.createOwner(owner);
	}
	
	//PUT: Update owner instance whose primary key is oid
	@PutMapping("/api/owner/{oid}")
	@Transactional
	public void updateOwner(@PathVariable("oid")int id, @RequestBody Owner newOwner) {
		ownerDao.updateOwner(id, newOwner);
	}
	
	//Post: Get Owner instance by credentials (username and password)
	@PostMapping("/api/owner/login")
	public Owner login(@RequestBody User user) {
		return ownerDao.findOwnerByCredentials(user.getUsername(), user.getPassword());	
	}
	
	//Post: Get Owner instance by username
	@PostMapping("/api/owner/username")
	public Owner findOwnerByUsername(@RequestBody User user) {
		return ownerDao.findOwnerByUsername(user.getUsername());
	}
	
	
}
