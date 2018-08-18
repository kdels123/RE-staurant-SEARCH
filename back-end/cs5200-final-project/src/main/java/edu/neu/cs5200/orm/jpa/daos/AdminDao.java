package edu.neu.cs5200.orm.jpa.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AdminDao {
//	@Autowired
//	AdminRepository adminRepository;
	
	// CREATE Admin
//		public Admin createAdmin(Admin admin) {
//			if(!existAdmin(admin)) {
//				return adminRepository.save(admin);
//			}
//			return null;
//		}
			
//		// DELETE all admin
//		public void deleteAllAdmins() {
//			adminRepository.deleteAll();
//		}
//			
//		// DELETE Admin
//		public void deleteAdmin(Admin admin) {
//			adminRepository.delete(admin);
//		}
//			
//		// DELETE Admin by ID
//		public void deleteAdminById(int id) {
//			criticRepository.deleteById(id);
//		}
//			
//		// FIND ALL Critic
//		public List<Critic> findAllCritics() {
//			return (List<Critic>) criticRepository.findAll();
//		}
//			
//		// FIND Critic by ID
//		public Optional<Critic> findCriticById(int id) {
//			return criticRepository.findById(id);
//		}
//			
//		// FIND Critic by username
//		public Critic findCriticByUsername(String username) {
//			return criticRepository.findCriticByUsername(username);
//		}
//		
//		// Find Critic by credentials (username and password)
//		public Critic findCriticByCredentials(String username, String password) {
//			return criticRepository.findCriticByCredentials(username, password);
//		}
//		
//		// UPDATE Owner
//		public void updateCritic(int id, Critic newCritic) {
//			Optional<Critic> optional = findCriticById(id);
//			if (optional.isPresent()) {
//				Critic currCritic = optional.get();
//				String firstName = newCritic.getFirstName() != null ? newCritic.getFirstName() : currCritic.getFirstName();
//				String lastName = newCritic.getLastName() != null ? newCritic.getLastName() : currCritic.getLastName();
//				String username = newCritic.getUsername() != null ? newCritic.getUsername() : currCritic.getUsername();
//				String password = newCritic.getPassword() != null? newCritic.getPassword(): currCritic.getPassword();
//				String email = newCritic.getEmail() != null ? newCritic.getEmail() : currCritic.getEmail();
//				String phone = newCritic.getPhone() != null ? newCritic.getPhone() : currCritic.getPhone();
//				Date dob = newCritic.getDob() != null ? newCritic.getDob() : currCritic.getDob();
//				String url = newCritic.getUrlToOtherWork() != null ? newCritic.getUrlToOtherWork() : currCritic.getUrlToOtherWork();
//				
//				List<Review> reviews = newCritic.getReviews() != null ? (List<Review>) newCritic.getReviews() : currCritic.getReviews();
//				List<Patron> followers = newCritic.getFollowers() != null ? (List<Patron>) newCritic.getFollowers() : currCritic.getFollowers();
//				
//				currCritic.setFirstName(firstName);
//				currCritic.setLastName(lastName);
//				currCritic.setUsername(username);
//				currCritic.setPassword(password);
//				currCritic.setEmail(email);
//				currCritic.setPhone(phone);
//				currCritic.setDob(dob);
//				currCritic.setUrlToOtherWork(url);
//				currCritic.setReviews(reviews);
//				currCritic.setFollowers(followers);
//					
//				//createCritic(currCritic);
//				criticRepository.save(currCritic);
//				
//				
//			}
//		}
//			
		// Check if Critic already exists
//		public boolean existCritic(Critic critic) {
//			List<Critic> critics = findAllCritics();
//			for (Critic c : critics) {
//				if (c.getUsername().equals(critic.getUsername())) {
//					return true;
//				}
//			}
//			return false;
//		}
}
