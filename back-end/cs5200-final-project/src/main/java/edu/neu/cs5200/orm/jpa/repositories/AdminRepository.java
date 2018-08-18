package edu.neu.cs5200.orm.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.neu.cs5200.orm.jpa.entities.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>{
	@Query("SELECT a FROM Admin a WHERE a.username=:username")
	public Admin findAdminByUsername (@Param("username") String username);
	
	@Query("SELECT u FROM Admin u WHERE u.username=:username AND u.password=:password")
	public Admin findAdminByCredentials(@Param("username") String username, @Param("password") String password);
}
