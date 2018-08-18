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

//import edu.neu.cs5200.orm.jpa.daos.AdminDao;
//import edu.neu.cs5200.orm.jpa.entities.Admin;
import edu.neu.cs5200.orm.jpa.entities.User;

//@RestController
//@CrossOrigin(origins = "*", maxAge = 3600)
//public class AdminService {
//	@Autowired
//	AdminDao adminDao;
//	
//	// GET: List of admins
//	@GetMapping("/api/admin")
//	public List<Admin> findAllAdmins() {
//		return adminDao.findAllAdmins();
//	}
//	
//	//GET: Admin instance whose primary key is aid
//	@GetMapping("/api/admin/{aid}")
//	public Optional<Admin> findAdminById (@PathVariable("aid") int id) {
//		return adminDao.findAdminById(id);
//	}
//	
//	//DELETE: Delete admin instance whose primary key is aid
//	@DeleteMapping("/api/admin/{aid}")
//	public void deleteAdminById(@PathVariable("aid") int id) {
//		adminDao.deleteAdminById(id);
//	}
//	
//	//POST: Create admin
//	@PostMapping("/api/admin")
//	public Admin createAdmin(@RequestBody Admin admin) {
//		return adminDao.createAdmin(admin);
//	}
//	
//	//PUT: Update admin instance whose primary key is aid
//	@PutMapping("/api/admin/{aid}")
//	@Transactional
//	public void updateAdmin(@PathVariable("aid")int id, @RequestBody Admin newAdmin) {
//		adminDao.updateAdmin(id, newAdmin);
//	}
//	
//	//Post: Get Admin instance by credentials (username and password)
//	@PostMapping("/api/admin/login")
//	//@ResponseBody
//	public Admin login(@RequestBody User user) {
//		return adminDao.findAdminByCredentials(user.getUsername(), user.getPassword());	
//	}
//	
//	//Post: Get Admin instance by username
//	@PostMapping("/api/admin/username")
//	public Admin findAdminByUsername(@RequestBody User user) {
//		return adminDao.findAdminByUsername(user.getUsername());
//	}
//}
