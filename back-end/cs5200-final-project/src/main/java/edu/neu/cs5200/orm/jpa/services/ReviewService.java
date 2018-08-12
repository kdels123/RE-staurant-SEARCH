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

import edu.neu.cs5200.orm.jpa.daos.ReviewDao;
import edu.neu.cs5200.orm.jpa.entities.Restaurant;
import edu.neu.cs5200.orm.jpa.entities.Review;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReviewService {
	@Autowired
	ReviewDao reviewDao;
	
	// GET: List of reviews
	@GetMapping("/api/review")
	public List<Review> findAllReview() {
		return reviewDao.findAllReviews();
	}
		
	//GET: Review instance whose primary key is rid
	@GetMapping("/api/review/{rid}")
	public Optional<Review> findReviewtById (@PathVariable("rid") int id) {
		return reviewDao.findReviewById(id);
	}
	
	//DELETE: Delete restaurant instance whose primary key is rid
	@DeleteMapping("/api/review/{rid}")
	public void deleteReviewById(@PathVariable("rid") int id) {
		reviewDao.deleteReviewById(id);
	}
	
	//POST: Create Review
	@PostMapping("/api/review")
	public Review createReview(@RequestBody Review review) {
		return reviewDao.createReview(review);
	}
	
	//PUT: Update review instance whose primary key is rid
	@PutMapping("/api/review/{rid}")
	@Transactional
	public void updateReview(@PathVariable("rid") int id, @RequestBody Review newReview) {
		reviewDao.updateReview(id, newReview);
	}
}
