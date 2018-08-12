package edu.neu.cs5200.orm.jpa.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.neu.cs5200.orm.jpa.Cs5200FinalProjectApplication;

@Component
public class TestDao implements CommandLineRunner{
	@Autowired
	OwnerDao ownerDao;
	@Autowired
	CriticDao criticDao;
	@Autowired
	PatronDao patronDao;
	@Autowired
	RestaurantDao restaurantDao;
	@Autowired
	ReviewDao reviewDao;
	@Autowired
	EventDao eventDao;
	@Autowired
	VibeDao vibeDao;
	
	
	public static void main(String[] args) {
		Cs5200FinalProjectApplication.main(args);
	}

	@Override
	public void run(String... args) throws Exception {
		ownerDao.test();
		criticDao.test();
		patronDao.test();
		restaurantDao.test();
		reviewDao.test();
		eventDao.test();
		vibeDao.test();
		
	}
	
	
}
