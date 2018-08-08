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
import edu.neu.cs5200.orm.jpa.repositories.CriticRepository;

@Component
public class CriticDao {
	@Autowired
	CriticRepository criticRepository;
	
	public void test() {
		//Delete all owners
		deleteAllCritics();
				
		//Create owners
		Critic critic = new Critic();
		critic.setFirstName("Suzy");
		critic.setLastName("Smith");
		critic.setUsername("suzyS");
		createCritic(critic);
		
		Critic critic2 = new Critic();
		critic2.setFirstName("Rachel");
		critic2.setLastName("Harrison");
		critic2.setUsername("rHarrison");
		createCritic(critic2);
	}
	
	// CREATE Critic
	public void createCritic(Critic critic) {
			
		if(!existCritic(critic)) {
			criticRepository.save(critic);
		}
			
	}
		
	// DELETE all critics
	public void deleteAllCritics() {
		criticRepository.deleteAll();
	}
		
	// DELETE Critic
	public void deleteCritic(Critic critic) {
		criticRepository.delete(critic);
	}
		
	// DELETE Critic by ID
	public void deleteCriticById(int id) {
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
		
		// UPDATE Owner
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
				
			createCritic(currCritic);
			
			
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
