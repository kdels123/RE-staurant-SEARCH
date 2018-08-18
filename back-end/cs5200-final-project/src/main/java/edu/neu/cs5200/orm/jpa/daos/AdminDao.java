package edu.neu.cs5200.orm.jpa.daos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import edu.neu.cs5200.orm.jpa.entities.Admin;
//import edu.neu.cs5200.orm.jpa.repositories.AdminRepository;


//@Component
//public class AdminDao {
//	@Autowired
//	AdminRepository adminRepository;
//	
//	// CREATE Admin
//	public Admin createAdmin(Admin admin) {
//		if(!existAdmin(admin)) {
//			return adminRepository.save(admin);
//		}
//		return null;
//	}
//		
//	// DELETE all admin
//	public void deleteAllAdmins() {
//		adminRepository.deleteAll();
//	}
//		
//	// DELETE Admin
//	public void deleteAdmin(Admin admin) {
//		adminRepository.delete(admin);
//	}
//		
//	// DELETE Admin by ID
//	public void deleteAdminById(int id) {
//		adminRepository.deleteById(id);
//	}
//		
//	// FIND ALL Admin
//	public List<Admin> findAllAdmins() {
//		return (List<Admin>) adminRepository.findAll();
//	}
//		
//	// FIND Admin by ID
//	public Optional<Admin> findAdminById(int id) {
//		return adminRepository.findById(id);
//	}
//		
//	// FIND Admin by username
//	public Admin findAdminByUsername(String username) {
//		return adminRepository.findAdminByUsername(username);
//	}
//	
//	// Find Admin by credentials (username and password)
//	public Admin findAdminByCredentials(String username, String password) {
//		return adminRepository.findAdminByCredentials(username, password);
//	}
//	
//	// UPDATE Admin
//	public void updateAdmin(int id, Admin newAdmin) {
//		Optional<Admin> optional = findAdminById(id);
//		if (optional.isPresent()) {
//			Admin currAdmin = optional.get();
//			String firstName = newAdmin.getFirstName() != null ? newAdmin.getFirstName() : currAdmin.getFirstName();
//			String lastName = newAdmin.getLastName() != null ? newAdmin.getLastName() : currAdmin.getLastName();
//			String username = newAdmin.getUsername() != null ? newAdmin.getUsername() : currAdmin.getUsername();
//			String password = newAdmin.getPassword() != null? newAdmin.getPassword(): currAdmin.getPassword();
//			String email = newAdmin.getEmail() != null ? newAdmin.getEmail() : currAdmin.getEmail();
//			String phone = newAdmin.getPhone() != null ? newAdmin.getPhone() : currAdmin.getPhone();
//			Date dob = newAdmin.getDob() != null ? newAdmin.getDob() : currAdmin.getDob();
//		
//			currAdmin.setFirstName(firstName);
//			currAdmin.setLastName(lastName);
//			currAdmin.setUsername(username);
//			currAdmin.setPassword(password);
//			currAdmin.setEmail(email);
//			currAdmin.setPhone(phone);
//			currAdmin.setDob(dob);
//				
//			adminRepository.save(currAdmin);
//		}
//	}
//		
//	// Check if Admin already exists
//	public boolean existAdmin(Admin admin) {
//		List<Admin> admins = findAllAdmins();
//		for (Admin a : admins) {
//			if (a.getUsername().equals(admin.getUsername())) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	
//}
