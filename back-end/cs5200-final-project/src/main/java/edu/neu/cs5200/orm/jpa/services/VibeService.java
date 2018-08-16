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
import org.springframework.web.bind.annotation.RestController;

import edu.neu.cs5200.orm.jpa.daos.VibeDao;
import edu.neu.cs5200.orm.jpa.entities.Vibe;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class VibeService {
	@Autowired
	VibeDao vibeDao;
	
	// GET: List of vibes
		@GetMapping("/api/vibe")
		public List<Vibe> findAllVibes() {
			return vibeDao.findAllVibes();
		}
		
		//GET: Vibe instance whose primary key is vid
		@GetMapping("/api/vibe/{vid}")
		public Optional<Vibe> findVibeById (@PathVariable("vid") int id) {
			return vibeDao.findVibeById(id);
		}
		
		//DELETE: Delete vibe instance whose primary key is vid
		@DeleteMapping("/api/vibe/{vid}")
		public void deleteVibeById(@PathVariable("vid") int id) {
			vibeDao.deleteVibeById(id);
		}
		
		//POST: Create critic
		@PostMapping("/api/vibe")
		public Vibe createVibe(@RequestBody Vibe vibe) {
			return vibeDao.createVibe(vibe);
		}
		
		//PUT: Update critic instance whose primary key is cid
		@PutMapping("/api/vibe/{vid}")
		@Transactional
		public void updateVibe(@PathVariable("vid")int id, @RequestBody Vibe newVibe) {
			vibeDao.updateVibe(id, newVibe);
		}
}
