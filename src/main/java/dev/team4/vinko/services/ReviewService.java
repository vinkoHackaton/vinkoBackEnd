package dev.team4.vinko.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.team4.vinko.entities.Review;
import dev.team4.vinko.repositories.ReviewRepository;

@Service
public class ReviewService {
    private final ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public List<Review> getAllReviews() {
        return repository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return repository.findById(id);
    }

    public Review createReview(Review review) {
        return repository.save(review);
    }

    public Review updateReview(Long id, Review updatedReview) {
        return repository.findById(id).map(review -> {
            review.setStars(updatedReview.getStars());
            review.setComment(updatedReview.getComment());
            review.setElderlyUser(updatedReview.getElderlyUser());
            review.setCompanion(updatedReview.getCompanion());
            return repository.save(review);
        }).orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public void deleteReview(Long id) {
        repository.deleteById(id);
    }
}
