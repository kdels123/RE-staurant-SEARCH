package edu.neu.cs5200.orm.jpa.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.cs5200.orm.jpa.daos.OwnerDao;
import edu.neu.cs5200.orm.jpa.entities.Owner;

@RestController
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
	
	//PUT: Update owner instance whose primary key is oid
	@PutMapping("/api/owner/{oid}")
	@Transactional
	public void updateOwner(@PathVariable("oid")int id, @RequestBody Owner newOwner) {
		ownerDao.updateOwner(id, newOwner);
	}
}
