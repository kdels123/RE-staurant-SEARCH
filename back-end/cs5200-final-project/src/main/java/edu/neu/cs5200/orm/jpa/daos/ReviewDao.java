package edu.neu.cs5200.orm.jpa.daos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.cs5200.orm.jpa.entities.Critic;
import edu.neu.cs5200.orm.jpa.entities.Event;
import edu.neu.cs5200.orm.jpa.entities.Owner;
import edu.neu.cs5200.orm.jpa.entities.Restaurant;
import edu.neu.cs5200.orm.jpa.entities.Review;
import edu.neu.cs5200.orm.jpa.repositories.ReviewRepository;

@Component
public class ReviewDao {
	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	CriticDao criticDao;
	@Autowired
	RestaurantDao restaurantDao;
	@Autowired
	EventDao eventDao;
	
	public void test() {
//		// Delete all reviews
//		deleteAllReviews();
//		
//		// Create Review
//		Review review = new Review();
//		review.setDescription("Tapas tapas tapas");
//		review.setRating(5);
//		review.setTitle("Where to go for Tapas");
//		
//		Critic critic = new Critic();
//		critic.setFirstName("Suzy");
//		critic.setLastName("Smith");
//		critic.setUsername("suzyS");
//		
//		review.setCritic(critic);
//		
//		Restaurant r1 = new Restaurant();
//		r1.setName("Toro");
//		r1.setAddress("1704 Washington St");
//		r1.setCity("Boston");
//		r1.setState("MA");
//		r1.setPhone("617-536-4300");
//		r1.setNumberOfVisits(2000);
//		r1.setPrice("$$$");
//		
//		Owner owner = new Owner();
//		owner.setFirstName("Ken");
//		owner.setLastName("Oringer");
//		owner.setPhone("617-536-4300");
//		owner.setUsername("kenO");
//		
//		r1.setOwner(owner);
//		
//		review.setRestaurant(r1);
//		
//		createReview(review);
	}
	
	// CREATE Review for Event
		public Review createReviewForEvent(Review review, int criticId, int eventId) {
			
			if(review.getCritic() != null) {
				criticDao.createCritic(review.getCritic());
				review.setCritic(criticDao.findCriticByUsername(review.getCritic().getUsername()));
			}
			
			if(review.getRestaurant() != null) {
				restaurantDao.createRestaurant(review.getRestaurant());
				review.setRestaurant(restaurantDao.findRestaurantByName(review.getRestaurant().getName()));
			}
			
			if(!existReview(review)) {
				Review newReview = new Review();
				newReview.setTitle(review.getTitle());
				newReview.setDescription(review.getDescription());
				newReview.setRating(review.getRating());
				newReview.setCritic(criticDao.findCriticById(criticId).get());
				newReview.setEvent(eventDao.findEventById(eventId).get());
				
				return reviewRepository.save(newReview);
			}
			
			return null;
		}
	
	// CREATE Review for Restaurant
	public Review createReview(Review review, int criticId, int restaurantId) {
		
		if(review.getCritic() != null) {
			criticDao.createCritic(review.getCritic());
			review.setCritic(criticDao.findCriticByUsername(review.getCritic().getUsername()));
		}
		
		if(review.getRestaurant() != null) {
			restaurantDao.createRestaurant(review.getRestaurant());
			review.setRestaurant(restaurantDao.findRestaurantByName(review.getRestaurant().getName()));
		}
		
		if(!existReview(review)) {
			Review newReview = new Review();
			newReview.setTitle(review.getTitle());
			newReview.setDescription(review.getDescription());
			newReview.setRating(review.getRating());
			newReview.setCritic(criticDao.findCriticById(criticId).get());
			newReview.setRestaurant(restaurantDao.findRestaurantById(restaurantId).get());
			
			return reviewRepository.save(newReview);
		}
		
		return null;
	}
	
	//CREATE review that already contains a critic and restaurant object
	public Review createReview(Review review) {
		
		if(review.getCritic() != null) {
			criticDao.createCritic(review.getCritic());
			review.setCritic(criticDao.findCriticByUsername(review.getCritic().getUsername()));
		}
		
		if(review.getRestaurant() != null) {
			restaurantDao.createRestaurant(review.getRestaurant());
			review.setRestaurant(restaurantDao.findRestaurantByName(review.getRestaurant().getName()));
		}
		
		if(!existReview(review)) {
			Review newReview = new Review();
			newReview.setTitle(review.getTitle());
			newReview.setDescription(review.getDescription());
			newReview.setRating(review.getRating());
			newReview.setCritic(criticDao.createCritic(review.getCritic()));
			newReview.setRestaurant(restaurantDao.createRestaurant(review.getRestaurant()));
			
			return reviewRepository.save(newReview);
		}
		
		return null;
	}
		
	// DELETE all Reviews
	public void deleteAllReviews() {
		reviewRepository.deleteAll();
	}
		
	// DELETE Review
	public void deleteReview(Review review) {
		reviewRepository.delete(review);
	}
		
	// DELETE Review by ID
	public void deleteReviewById(int id) {
		reviewRepository.deleteById(id);
	}
		
	// FIND ALL Review
	public List<Review> findAllReviews() {
		return (List<Review>) reviewRepository.findAll();
	}
		
	// FIND Review by ID
	public Optional<Review> findReviewById(int id) {
		return reviewRepository.findById(id);
	}
	
	// FIND Reviews for critic
	public List<Review> findAllReviewsForCritic(int criticId) {
		Optional<Critic> data = criticDao.findCriticById(criticId);
		if(data.isPresent()) {
			Critic critic = data.get();
			return critic.getReviews();
		}
		return null;
	}
	
	// FIND Reviews for restaurant
	public List<Review> findAllReviewsForRestaurant(int restaurantId) {
		Optional<Restaurant> data = restaurantDao.findRestaurantById(restaurantId);
		if(data.isPresent()) {
			Restaurant restaurant = data.get();
			return restaurant.getReviews();
		}
		return null;
	}
	
	// FIND Reviews for event
	public List<Review> findAllReviewsForEvent(int eventId) {
		Optional<Event> optional = eventDao.findEventById(eventId);
		if(optional.isPresent()) {
			Event event = optional.get();
			return event.getReviews();
		}
		return null;
	}

		
	// UPDATE Review
	public void updateReview(int id, Review newReview) {
		Optional<Review> optional = findReviewById(id);
		if (optional.isPresent()) {
			Review currReview = optional.get();
			
			String description = newReview.getDescription() != null ? newReview.getDescription() : currReview.getDescription();
			Integer rating = newReview.getRating() != null ? newReview.getRating() : currReview.getRating();
			String title = newReview.getTitle() != null ? newReview.getTitle() : currReview.getTitle();
			Critic critic = newReview.getCritic() != null ? newReview.getCritic() : currReview.getCritic();
			Restaurant restaurant = newReview.getRestaurant() != null ? newReview.getRestaurant() : currReview.getRestaurant();
			
			currReview.setDescription(description);
			currReview.setRating(rating);
			currReview.setTitle(title);
			currReview.setCritic(critic);
			currReview.setRestaurant(restaurant);
			
			
			reviewRepository.save(currReview);
		}
	}
		
	// Check if Review already exists
	public boolean existReview(Review review) {
		List<Review> reviews = findAllReviews();
		for (Review r : reviews) {
			if (r.getCritic().equals(review.getCritic())
					&& r.getRestaurant().equals(review.getRestaurant())) {
				return true;
			}
		}
		return false;
	}
}
