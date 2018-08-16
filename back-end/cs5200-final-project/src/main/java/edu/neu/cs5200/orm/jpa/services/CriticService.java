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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.cs5200.orm.jpa.daos.CriticDao;
import edu.neu.cs5200.orm.jpa.entities.Critic;
import edu.neu.cs5200.orm.jpa.entities.Owner;
import edu.neu.cs5200.orm.jpa.entities.User;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CriticService {
	@Autowired
	CriticDao criticDao;
	
	// GET: List of critics
	@GetMapping("/api/critic")
	public List<Critic> findAllCritics() {
		return criticDao.findAllCritics();
	}
	
	//GET: Critic instance whose primary key is cid
	@GetMapping("/api/critic/{cid}")
	public Optional<Critic> findCriticById (@PathVariable("cid") int id) {
		return criticDao.findCriticById(id);
	}
	
	//DELETE: Delete critic instance whose primary key is cid
	@DeleteMapping("/api/critic/{cid}")
	public void deleteCriticById(@PathVariable("cid") int id) {
		criticDao.deleteCriticById(id);
	}
	
	//POST: Create critic
	@PostMapping("/api/critic")
	public Critic createCritic(@RequestBody Critic critic) {
		return criticDao.createCritic(critic);
	}
	
	//PUT: Update critic instance whose primary key is cid
	@PutMapping("/api/critic/{cid}")
	@Transactional
	public void updateCritic(@PathVariable("cid")int id, @RequestBody Critic newCritic) {
		criticDao.updateCritic(id, newCritic);
	}
	
	//Post: Get Critic instance by credentials (username and password)
	@PostMapping("/api/critic/login")
	//@ResponseBody
	public Critic login(@RequestBody User user) {
		return criticDao.findCriticByCredentials(user.getUsername(), user.getPassword());	
	}
	
}
