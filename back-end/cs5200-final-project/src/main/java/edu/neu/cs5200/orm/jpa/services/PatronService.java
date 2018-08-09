package edu.neu.cs5200.orm.jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.cs5200.orm.jpa.daos.PatronDao;
import edu.neu.cs5200.orm.jpa.entities.Patron;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PatronService {
	@Autowired
	PatronDao patronDao;
	
	//GET : List of patrons
	@GetMapping("/api/patron")
	public List<Patron> findAllPatrons() {
		return patronDao.findAllPatrons();
	}
	
	//Get Patron instance whose primary key is pid
	@GetMapping("/api/patron/{pid}")
	public Optional<Patron> findPatronById(@PathVariable("pid") int id) {
		return patronDao.findPatronById(id);
	}
	
	//POST: Create patron
	@PostMapping("/api/patron")
	public void createPatron(@RequestBody Patron patron) {
		patronDao.createPatron(patron);
	}
	
	//PUT: Update patron instance whose primary key is pid
	@PutMapping("/api/patron/{pid}")
	public void updatePatron(@PathVariable("pid") int id, @RequestBody Patron newPatron) {
		patronDao.updatePatron(id, newPatron);
	}
}
