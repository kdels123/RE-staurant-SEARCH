package edu.neu.cs5200.orm.jpa.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.neu.cs5200.orm.jpa.Cs5200FinalProjectApplication;

@Component
public class TestDao implements CommandLineRunner{
	@Autowired
	OwnerDao restaurantOwnerDao;
	
	public static void main(String[] args) {
		Cs5200FinalProjectApplication.main(args);
	}

	@Override
	public void run(String... args) throws Exception {
		restaurantOwnerDao.test();
		
	}
	
	
}